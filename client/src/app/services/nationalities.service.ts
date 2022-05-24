import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core'
import { Observable } from 'rxjs'
import { NATIONALITIES_URI } from '../constants'

@Injectable({
  providedIn: 'root'
})
export class NationalitiesService {
  constructor(private httpClient: HttpClient) {}

  public getAllNationalities(): Observable<any> {
    return this.httpClient.get(`${NATIONALITIES_URI}`)
  }
}
