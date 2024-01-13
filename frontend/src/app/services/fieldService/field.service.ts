import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Field } from '../../models/fieldModel/field';

@Injectable({
  providedIn: 'root',
})
export class FieldService {
  private baseURL = 'http://localhost:8080/api/field';

  constructor(private httpClient: HttpClient) {}

  getFieldList(): Observable<Field[]> {
    return this.httpClient.get<Field[]>(`${this.baseURL}`);
  }
}
