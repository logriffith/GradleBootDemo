import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class RadiusService {
  private url: string = "http://localhost:80/challenge/circumference"

  constructor(private http: HttpClient) { }

  sendRadius(radius: number): Observable<number> {
    return this.http.post<number>(this.url, radius);
  }
}
