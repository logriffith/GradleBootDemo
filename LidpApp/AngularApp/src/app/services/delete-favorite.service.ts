import { HttpClient, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FavoriteColor } from '../models/favorite-color';
import { Name } from '../models/name';

@Injectable({
  providedIn: 'root'
})
export class DeleteFavoriteService {

  private url: string = "http://localhost:80/challenge/database/color/delete";

  constructor(private http: HttpClient) { }

  deleteColor(user: Name): Observable<any>{
    const req = new HttpRequest("DELETE", this.url, user, { 
      reportProgress: true,
      responseType: 'text'
    });
    
    return this.http.request(req);
  }
}
