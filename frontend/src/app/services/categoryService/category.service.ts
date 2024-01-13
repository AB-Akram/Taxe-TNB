import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from '../../models/categoryModel/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private baseURL = "http://localhost:8080/api/category";

  constructor(private httpClient: HttpClient) {} // il'est pas injecter s'il n'est pas configurer sur le fichier 'app.config.ts'

  getCategoryList(): Observable<Category[]>{
    return this.httpClient.get<Category[]>(`${this.baseURL}`);
  }
}
