import {
  Component,
  Input,
  OnChanges,
  OnDestroy,
  OnInit,
  SimpleChanges,
  ViewChild
} from '@angular/core'
import { MatDialog } from '@angular/material/dialog'
import { MatSort } from '@angular/material/sort'
import { MatTableDataSource } from '@angular/material/table'
import { Subscription } from 'rxjs'
import { PlayersDialogComponent } from 'src/app/components/players-dialog/players-dialog.component'
import { Nationality } from 'src/app/models/nationality'
import { Player } from 'src/app/models/player'
import { Team } from 'src/app/models/team'
import { PlayersService } from 'src/app/services/players.service'

@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.css']
})
export class PlayersComponent implements OnInit, OnDestroy, OnChanges {
  dataSource!: MatTableDataSource<Player>
  displayedColumns = [
    'id',
    'ime',
    'prezime',
    'brojReg',
    'datumRodjenja',
    'nacionalnost',
    'actions'
  ]
  subscription!: Subscription
  @Input() selectedTeamBottom!: Team
  @ViewChild(MatSort, { static: false }) sort!: MatSort

  constructor(
    private playersService: PlayersService,
    private dialog: MatDialog
  ) {}

  ngOnChanges(changes: SimpleChanges): void {
    this.loadData()
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }

  ngOnInit(): void {
    this.loadData()
  }

  public loadData(teamID: number = this.selectedTeamBottom.id) {
    ;(this.subscription = this.playersService
      .getPlayersByTeam(teamID)
      .subscribe((data) => {
        this.dataSource = new MatTableDataSource(data)
        this.dataSource.sort = this.sort
      })),
      (error: Error) => {
        console.log(error.name + ' ' + error.message)
      }
  }

  public openDialog(
    flag: number,
    id?: number,
    ime?: string,
    prezime?: string,
    brojReg?: string,
    datumRodjenja?: Date,
    nacionalnost?: Nationality
  ) {
    const dialogRef = this.dialog.open(PlayersDialogComponent, {
      data: {
        id,
        ime,
        prezime,
        brojReg,
        datumRodjenja,
        nacionalnost
      }
    })
    dialogRef.componentInstance.flag = flag
    dialogRef.componentInstance.data.tim = this.selectedTeamBottom
    dialogRef.afterClosed().subscribe((result) => {
      this.loadData()
    })
  }
}
