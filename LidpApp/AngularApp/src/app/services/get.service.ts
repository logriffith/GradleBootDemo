import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GetInfo } from '../models/get-info';

@Injectable({
  providedIn: 'root'
})
export class GetService {
    private url: string = "http://localhost:80/challenge/info";

  constructor(private http: HttpClient) { }

  getInfo(): Observable<GetInfo> {
    return this.http.get(this.url) as Observable<GetInfo>;
  }
}
