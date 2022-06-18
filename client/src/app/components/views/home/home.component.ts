import { Component, OnInit } from '@angular/core'
import { LeaguesService } from 'src/app/services/leagues.service'
import { NationalitiesService } from 'src/app/services/nationalities.service'
import { PlayersService } from 'src/app/services/players.service'
import { TeamsService } from 'src/app/services/teams.service'

export interface Tile {
  cols: number
  rows: number
  title?: number
  subtitle: string
  uri: string
  icon: string
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  subscription: any
  constructor(
    private playersService: PlayersService,
    private leaguesService: LeaguesService,
    private teamsService: TeamsService,
    private nationalitiesService: NationalitiesService
  ) {}

  ngOnInit(): void {
    this.loadData(() => this.playersService.getAllPlayers(), 0)
    this.loadData(() => this.leaguesService.getAllLeagues(), 1)
    this.loadData(() => this.teamsService.getAllTeams(), 2)
    this.loadData(() => this.nationalitiesService.getAllNationalities(), 3)
  }

  tiles: Tile[] = [
    {
      subtitle: 'Ukupno igrača',
      cols: 4,
      rows: 1,
      uri: 'timovi',
      icon: 'sports_soccer'
    },
    {
      subtitle: 'Ukupno liga',
      cols: 2,
      rows: 2,
      uri: 'lige',
      icon: 'leaderboard'
    },
    {
      subtitle: 'Ukupno timova',
      cols: 2,
      rows: 1,
      uri: 'timovi',
      icon: 'workspaces'
    },
    {
      subtitle: 'Ukupno nacionalnosti',
      cols: 2,
      rows: 1,
      uri: 'nacionalnosti',
      icon: 'flag'
    }
  ]

  public loadData(service: any, id: number = 0) {
    ;(this.subscription = service().subscribe((data: string | any[]) => {
      this.tiles[id].title = data.length
    })),
      (error: Error) => {
        console.log(error.name + ' ' + error.message)
      }
  }
}
