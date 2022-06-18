import { Component, OnInit, Inject } from '@angular/core'
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'
import { MatSnackBar } from '@angular/material/snack-bar'
import { League } from 'src/app/models/league'
import { Team } from 'src/app/models/team'
import { LeaguesService } from 'src/app/services/leagues.service'
import { TeamsService } from 'src/app/services/teams.service'

@Component({
  selector: 'app-teams-dialog',
  templateUrl: './teams-dialog.component.html',
  styleUrls: ['./teams-dialog.component.css']
})
export class TeamsDialogComponent implements OnInit {
  flag!: number
  leagues!: League[]

  constructor(
    public snackbar: MatSnackBar,
    public dialogRef: MatDialogRef<TeamsDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Team,
    public teamsService: TeamsService,
    public leaguesService: LeaguesService
  ) {}

  ngOnInit(): void {
    this.leaguesService.getAllLeagues().subscribe((data) => {
      this.leagues = data
    })
  }

  public complare(a: any, b: any) {
    return a.id == b.id
  }

  public add() {
    this.teamsService.addTeam(this.data).subscribe((data) => {
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
    this.teamsService.updateTeam(this.data).subscribe((data) => {
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
    this.teamsService.deleteTeam(this.data.id).subscribe(() => {
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
