import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RadiusServiceService {

  private url: string = "http://localhost:80/lidp/challenge/circumference"

  constructor(private http: HttpClient) { }

  sendRadius(radius: number): Observable<number>{
    return this.http.post<number>(this.url, radius);
  }
}
