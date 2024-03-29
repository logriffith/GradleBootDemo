import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ChooseColor } from '../models/choose-color';

@Injectable({
  providedIn: 'root'
})
export class ChooseColorService {

  private url: string = "http://localhost:80/challenge/database/color/choose";

  constructor(private http: HttpClient) { }

  chooseFavorite(user: ChooseColor): Observable<any>{
    return this.http.post(this.url, user) as Observable<any>;
  }
}
