import { Component, OnInit } from '@angular/core'
import { MatDialog } from '@angular/material/dialog'
import { MatTableDataSource } from '@angular/material/table'
import { Subscription } from 'rxjs'
import { LeaguesDialogComponent } from 'src/app/components/leagues-dialog/leagues-dialog.component'
import { League } from 'src/app/models/league'
import { LeaguesService } from 'src/app/services/leagues.service'

@Component({
  selector: 'app-leagues',
  templateUrl: './leagues.component.html',
  styleUrls: ['./leagues.component.css']
})
export class LeaguesComponent implements OnInit {
  dataSource!: MatTableDataSource<League>
  displayedColumns = ['id', 'naziv', 'oznaka', 'actions']
  subscription!: Subscription

  constructor(
    private leaguesService: LeaguesService,
    private dialog: MatDialog
  ) {}

  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }

  ngOnInit(): void {
    this.loadData()
  }

  public loadData() {
    ;(this.subscription = this.leaguesService
      .getAllLeagues()
      .subscribe((data) => {
        this.dataSource = new MatTableDataSource(data)
      })),
      (error: Error) => {
        console.log(error.name + ' ' + error.message)
      }
  }

  public openDialog(
    flag: number,
    id?: number,
    naziv?: string,
    oznaka?: string
  ) {
    const dialogRef = this.dialog.open(LeaguesDialogComponent, {
      data: {
        id,
        naziv,
        oznaka
      }
    })
    dialogRef.componentInstance.flag = flag
    dialogRef.afterClosed().subscribe((result) => {
      this.loadData()
    })
  }
}
