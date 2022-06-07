import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core'
import { Observable } from 'rxjs'
import { PLAYER_TEAM_URI, PLAYERS_URI } from '../constants'
import { Player } from '../models/player'

@Injectable({
  providedIn: 'root'
})
export class PlayersService {
  constructor(private httpClient: HttpClient) {}

  public getAllPlayers(): Observable<any> {
    return this.httpClient.get(`${PLAYERS_URI}`)
  }
  public getPlayersByTeam(teamID: number): Observable<any> {
    return this.httpClient.get(`${PLAYER_TEAM_URI}/${teamID}`)
  }
  public addPlayer(player: Player): Observable<any> {
    player.id = 0
    return this.httpClient.post(`${PLAYERS_URI}`, player)
  }
  public updatePlayer(player: Player): Observable<any> {
    return this.httpClient.put(`${PLAYERS_URI}`, player)
  }
  public deletePlayer(id: number) {
    return this.httpClient.delete(`${PLAYERS_URI}/${id}`)
  }
}
