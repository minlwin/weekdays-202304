import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';

const API = `${environment.baseApi}/public/categories`

@Injectable({
  providedIn: 'root'
})
export class PublicCategoryService {

  constructor(private http: HttpClient) { }

  findAll() {
    return this.http.get<any[]>(API)
  }
}
