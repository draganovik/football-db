import { Component, OnInit, ViewChild } from '@angular/core'
import { MatDialog } from '@angular/material/dialog'
import { MatPaginator } from '@angular/material/paginator'
import { MatSort } from '@angular/material/sort'
import { MatTableDataSource } from '@angular/material/table'
import { Subscription } from 'rxjs'
import { LeaguesDialogComponent } from 'src/app/components/modals/leagues-dialog/leagues-dialog.component'
import { League } from 'src/app/models/league'
import { LeaguesService } from 'src/app/services/leagues.service'

@Component({
  selector: 'app-leagues',
  templateUrl: './leagues.component.html',
  styleUrls: ['./leagues.component.css']
})
export class LeaguesComponent implements OnInit {
  dataSource!: MatTableDataSource<League>
  dataLoading: boolean = true
  displayedColumns = ['id', 'naziv', 'oznaka', 'actions']
  subscription!: Subscription

  @ViewChild(MatSort, { static: false }) sort!: MatSort
  @ViewChild(MatPaginator, { static: false }) paginator!: MatPaginator

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
      .subscribe((data?) => {
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

  public applyFilter(filter: any) {
    filter = filter.target.value
    filter = filter.trim()
    filter = filter.toLocaleLowerCase()
    this.dataSource.filter = filter
  }
}
