import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Name } from '../models/name';

@Injectable({
  providedIn: 'root'
})
export class GetFavoriteService {

  private url: string = "http://localhost:80/challenge/database/color/get";

  constructor(private http: HttpClient) { }

  getFavorite(user: Name): Observable<any>{
    return this.http.post(this.url, user) as Observable<any>;
  }
}
