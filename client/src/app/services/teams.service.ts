import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core'
import { Observable } from 'rxjs'
import { TEAMS_URI } from '../constants'
import { Team } from '../models/team'

@Injectable({
  providedIn: 'root'
})
export class TeamsService {
  constructor(private httpClient: HttpClient) {}

  public getAllTeams(): Observable<any> {
    return this.httpClient.get(`${TEAMS_URI}`)
  }
  public addTeam(team: Team): Observable<any> {
    team.id = 0
    return this.httpClient.post(`${TEAMS_URI}`, team)
  }
  public updateTeam(team: Team): Observable<any> {
    return this.httpClient.put(`${TEAMS_URI}`, team)
  }
  public deleteTeam(id: number) {
    return this.httpClient.delete(`${TEAMS_URI}/${id}`)
  }
}
