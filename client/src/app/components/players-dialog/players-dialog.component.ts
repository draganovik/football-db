import { Component, OnInit, Inject } from '@angular/core'
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'
import { MatSnackBar } from '@angular/material/snack-bar'
import { Nationality } from 'src/app/models/nationality'
import { Player } from 'src/app/models/player'
import { NationalitiesService } from 'src/app/services/nationalities.service'
import { PlayersService } from 'src/app/services/players.service'

@Component({
  selector: 'app-players-dialog',
  templateUrl: './players-dialog.component.html',
  styleUrls: ['./players-dialog.component.css']
})
export class PlayersDialogComponent implements OnInit {
  flag!: number
  nationalities!: Nationality[]

  constructor(
    public snackbar: MatSnackBar,
    public dialogRef: MatDialogRef<PlayersDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Player,
    public playersService: PlayersService,
    public nationalitiesService: NationalitiesService
  ) {}

  ngOnInit(): void {
    this.nationalitiesService.getAllNationalities().subscribe((data) => {
      this.nationalities = data
    })
  }

  public complare(a: any, b: any) {
    return a.id == b.id
  }

  public add() {
    this.playersService.addPlayer(this.data).subscribe((data) => {
      console.log(this.data)
      this.snackbar.open('Uspešno dodata vrednost: ' + this.data.ime, 'Važi', {
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
  public update() {
    this.playersService.updatePlayer(this.data).subscribe((data) => {
      this.snackbar.open('Uspešno dodata vrednost: ' + this.data.ime, 'Važi', {
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
  public delete() {
    this.playersService.deletePlayer(this.data.id).subscribe(() => {
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
