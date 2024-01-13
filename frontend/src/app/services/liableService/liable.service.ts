import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Liable } from '../../models/liableModel/liable';

@Injectable({
  providedIn: 'root',
})
export class LiableService {
  private baseURL = 'http://localhost:8080/api/liable';

  constructor(private httpClient: HttpClient) {}

  getLiableList(): Observable<Liable[]> {
    return this.httpClient.get<Liable[]>(`${this.baseURL}`);
  }
}
