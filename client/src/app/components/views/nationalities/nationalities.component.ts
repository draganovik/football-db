import {
  ChangeDetectorRef,
  Component,
  OnDestroy,
  OnInit,
  ViewChild
} from '@angular/core'
import { MatDialog } from '@angular/material/dialog'
import { MatPaginator } from '@angular/material/paginator'
import { MatSort } from '@angular/material/sort'
import { MatTableDataSource } from '@angular/material/table'
import { Subscription } from 'rxjs'
import { NationalitiesDialogComponent } from 'src/app/components/modals/nationalities-dialog/nationalities-dialog.component'
import { Nationality } from 'src/app/models/nationality'
import { NationalitiesService } from 'src/app/services/nationalities.service'

@Component({
  selector: 'app-nationalities',
  templateUrl: './nationalities.component.html',
  styleUrls: ['./nationalities.component.css']
})
export class NationalitiesComponent implements OnInit, OnDestroy {
  dataSource!: MatTableDataSource<Nationality>
  dataLoading: boolean = true
  displayedColumns = ['id', 'naziv', 'skracenica', 'actions']
  subscription!: Subscription

  @ViewChild(MatSort, { static: false }) sort!: MatSort
  @ViewChild(MatPaginator, { static: false }) paginator!: MatPaginator

  constructor(
    private nationalitiesService: NationalitiesService,
    private dialog: MatDialog,
    private changeDetectorRef: ChangeDetectorRef
  ) {}

  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }

  ngOnInit(): void {
    this.loadData()
  }

  public loadData() {
    ;(this.subscription = this.nationalitiesService
      .getAllNationalities()
      .subscribe((data) => {
        this.dataSource = new MatTableDataSource(data)
        this.dataLoading = false
        this.changeDetectorRef.detectChanges()
        this.dataSource.sort = this.sort
        this.dataSource.paginator = this.paginator
      })),
      (error: Error) => {
        console.log(error.name + ' ' + error.message)
        this.dataLoading = false
      }
  }

  public openDialog(
    flag: number,
    id?: number,
    naziv?: string,
    skracenica?: string
  ) {
    const dialogRef = this.dialog.open(NationalitiesDialogComponent, {
      data: {
        id,
        naziv,
        skracenica
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
