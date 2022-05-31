import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core'
import { Observable } from 'rxjs'
import { NATIONALITIES_URI } from '../constants'
import { Nationalities } from '../models/nationalities'

@Injectable({
  providedIn: 'root'
})
export class NationalitiesService {
  constructor(private httpClient: HttpClient) {}

  public getAllNationalities(): Observable<any> {
    return this.httpClient.get(`${NATIONALITIES_URI}`)
  }
  public addNationality(nationality: Nationalities): Observable<any> {
    nationality.id = 0
    return this.httpClient.post(`${NATIONALITIES_URI}`, nationality)
  }
  public updateNationality(nationality: Nationalities): Observable<any> {
    return this.httpClient.put(`${NATIONALITIES_URI}`, nationality)
  }
  public deleteNationality(id: number) {
    return this.httpClient.delete(`${NATIONALITIES_URI}/${id}`)
  }
}
