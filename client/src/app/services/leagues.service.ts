import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core'
import { Observable } from 'rxjs'
import { LEAGUES_URI } from '../constants'
import { League } from '../models/league'

@Injectable({
  providedIn: 'root'
})
export class LeaguesService {
  constructor(private httpClient: HttpClient) {}

  public getAllLeagues(): Observable<any> {
    return this.httpClient.get(`${LEAGUES_URI}`)
  }
  public addLeague(league: League): Observable<any> {
    league.id = 0
    return this.httpClient.post(`${LEAGUES_URI}`, league)
  }
  public updateLeague(team: League): Observable<any> {
    return this.httpClient.put(`${LEAGUES_URI}`, team)
  }
  public deleteLeague(id: number) {
    return this.httpClient.delete(`${LEAGUES_URI}/${id}`)
  }
}
