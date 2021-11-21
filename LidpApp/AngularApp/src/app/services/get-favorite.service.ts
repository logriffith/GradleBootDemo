import { HttpClient, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Name } from '../models/name';

@Injectable({
  providedIn: 'root'
})
export class GetFavoriteService {

  private url: string = "http://localhost:80/challenge/database/color/get";

  constructor(private httpClient: HttpClient) { }

  getFavorite(user: Name): Observable<any>{
    const postRequest = new HttpRequest('POST', this.url, user,
    { 
      reportProgress: true,
      responseType: 'text'
    });
    
    return this.httpClient.request(postRequest);
  }
}
