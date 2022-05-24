import { Component, OnDestroy, OnInit } from '@angular/core'
import { MatTableDataSource } from '@angular/material/table'
import { Subscription } from 'rxjs'
import { Nationalities } from 'src/app/models/nationalities'
import { NationalitiesService } from 'src/app/services/nationalities.service'

@Component({
  selector: 'app-nationalities',
  templateUrl: './nationalities.component.html',
  styleUrls: ['./nationalities.component.css']
})
export class NationalitiesComponent implements OnInit, OnDestroy {
  dataSource!: MatTableDataSource<Nationalities>
  displayedColumns = ['id', 'naziv', 'skracenica', 'actions']
  subscription!: Subscription

  constructor(private nationalitiesService: NationalitiesService) {}

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
      })),
      (error: Error) => {
        console.log(error.name + ' ' + error.message)
      }
  }
}
