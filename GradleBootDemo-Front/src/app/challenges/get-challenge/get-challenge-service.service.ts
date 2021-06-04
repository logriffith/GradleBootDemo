import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GetInfoComponent } from './get-info/get-info.component';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class GetChallengeServiceService {

  private url = "http://localhost:80/lidp/challenge/info";

  constructor(private http: HttpClient) { }

  // getScores(): Observable<Score[]> {
  //   return this.http.get(this.ServerUrl + 'score') as Observable<Score[]>;
  // }

  getInfo(): Observable<string>{
    return this.http.get(this.url) as Observable<string>;
  }
}
