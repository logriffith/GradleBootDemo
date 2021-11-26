import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ChooseColor } from '../models/choose-color';

@Injectable({
  providedIn: 'root'
})
export class UpdateFavoriteService {

  private url: string = "http://localhost:80/challenge/database/color/update";

  constructor(private httpClient: HttpClient) { }

  updateColor(color: ChooseColor): Observable<any>{
    return this.httpClient.put(this.url, color) as Observable<any>;
  }

}
