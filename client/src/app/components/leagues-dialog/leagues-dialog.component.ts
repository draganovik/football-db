import { Component, OnInit, Inject } from '@angular/core'
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'
import { MatSnackBar } from '@angular/material/snack-bar'
import { League } from 'src/app/models/league'
import { LeaguesService } from 'src/app/services/leagues.service'

@Component({
  selector: 'app-leagues-dialog',
  templateUrl: './leagues-dialog.component.html',
  styleUrls: ['./leagues-dialog.component.css']
})
export class LeaguesDialogComponent implements OnInit {
  flag!: number

  constructor(
    public snackbar: MatSnackBar,
    public dialogRef: MatDialogRef<LeaguesDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: League,
    public leaguesService: LeaguesService
  ) {}

  ngOnInit(): void {}

  public complare(a: any, b: any) {
    return a.id == b.id
  }

  public add() {
    this.leaguesService.addLeague(this.data).subscribe((data) => {
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
    this.leaguesService.updateLeague(this.data).subscribe((data) => {
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
    this.leaguesService.deleteLeague(this.data.id).subscribe(() => {
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
