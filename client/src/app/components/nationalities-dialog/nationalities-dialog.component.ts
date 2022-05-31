import { Component, OnInit, Inject } from '@angular/core'
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'
import { MatSnackBar } from '@angular/material/snack-bar'
import { Nationalities } from 'src/app/models/nationalities'
import { NationalitiesService } from 'src/app/services/nationalities.service'

@Component({
  selector: 'app-nationalities-dialog',
  templateUrl: './nationalities-dialog.component.html',
  styleUrls: ['./nationalities-dialog.component.css']
})
export class NationalitiesDialogComponent implements OnInit {
  flag!: number

  constructor(
    public snackbar: MatSnackBar,
    public dialogRef: MatDialogRef<NationalitiesDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Nationalities,
    public nationalitiesService: NationalitiesService
  ) {}

  ngOnInit(): void {}

  public add() {
    this.nationalitiesService.addNationality(this.data).subscribe((data) => {
      console.log(this.data)
      this.snackbar.open(
        'Uspešno dodata vrednost: ' + this.data.naziv,
        'Važi',
        {
          duration: 3500
        }
      )
      this.dialogRef.close()
    }),
      (error: Error) => {
        console.log(error.name + ' ' + error.message)
        this.snackbar.open('Dogodila se greška', 'OK', {
          duration: 3500
        })
      }
  }
  public update() {
    this.nationalitiesService.updateNationality(this.data).subscribe((data) => {
      this.snackbar.open(
        'Uspešno dodata vrednost: ' + this.data.naziv,
        'Važi',
        {
          duration: 3500
        }
      )
      this.dialogRef.close()
    }),
      (error: Error) => {
        console.log(error.name + ' ' + error.message)
        this.snackbar.open('Dogodila se greška', 'OK', {
          duration: 3500
        })
      }
  }
  public delete() {
    this.nationalitiesService.deleteNationality(this.data.id).subscribe(() => {
      this.snackbar.open('Uspešno obrisana vrednost', 'Važi', {
        duration: 3500
      })
      this.dialogRef.close()
    }),
      (error: Error) => {
        console.log(error.name + ' ' + error.message)
        this.snackbar.open('Dogodila se greška', 'OK', {
          duration: 3500
        })
      }
  }
  public cancel() {
    this.dialogRef.close()
    this.snackbar.open('Izmena obustavljena', 'U redu', {
      duration: 3500
    })
  }
}
