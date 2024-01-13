import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TnbTax } from '../../models/tnbTaxModel/tnb-tax';

@Injectable({
  providedIn: 'root',
})
export class TnbTaxService {
  private baseURL = 'http://localhost:8080/api/tax';

  constructor(private httpClient: HttpClient) {}

  getTnbTaxList(): Observable<TnbTax[]> {
    return this.httpClient.get<TnbTax[]>(`${this.baseURL}`);
  }
}
