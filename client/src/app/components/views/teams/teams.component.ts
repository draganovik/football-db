import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core'
import { MatDialog } from '@angular/material/dialog'
import { MatPaginator } from '@angular/material/paginator'
import { MatSort } from '@angular/material/sort'
import { MatTableDataSource } from '@angular/material/table'
import { Subscription } from 'rxjs'
import { TeamsDialogComponent } from 'src/app/components/modals/teams-dialog/teams-dialog.component'
import { League } from 'src/app/models/league'
import { Player } from 'src/app/models/player'
import { Team } from 'src/app/models/team'
import { TeamsService } from 'src/app/services/teams.service'

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit, OnDestroy {
  dataSource!: MatTableDataSource<Team>
  dataLoading: boolean = true
  displayedColumns = ['id', 'naziv', 'osnovan', 'sediste', 'liga', 'actions']
  subscription!: Subscription
  selectedTeamTop!: Team

  @ViewChild(MatSort, { static: false }) sort!: MatSort
  @ViewChild(MatPaginator, { static: false }) paginator!: MatPaginator

  constructor(private teamsService: TeamsService, private dialog: MatDialog) {}

  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }

  ngOnInit(): void {
    this.loadData()
  }

  public loadData() {
    ;(this.subscription = this.teamsService.getAllTeams().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data)
      this.dataSource.sort = this.sort
      this.dataSource.paginator = this.paginator
      this.dataLoading = false
    })),
      (error: Error) => {
        console.log(error.name + ' ' + error.message)
      }
  }

  public openDialog(
    flag: number,
    id?: number,
    naziv?: string,
    osnovan?: Date,
    sediste?: string,
    liga?: League
  ) {
    const dialogRef = this.dialog.open(TeamsDialogComponent, {
      data: {
        id,
        naziv,
        osnovan,
        sediste,
        liga
      }
    })
    dialogRef.componentInstance.flag = flag
    dialogRef.afterClosed().subscribe((result) => {
      this.loadData()
    })
  }

  public selectRow(row: Team) {
    this.selectedTeamTop = row
  }

  public applyFilter(filter: any) {
    filter = filter.target.value
    filter = filter.trim()
    filter = filter.toLocaleLowerCase()
    this.dataSource.filter = filter
  }
}
