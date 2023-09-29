import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { PageResult } from '../../dto/page-result';

const API = `${environment.baseApi}/public/catalogs`

@Injectable({
  providedIn: 'root'
})
export class PublicCatalogService {

  constructor(private http: HttpClient) { }

  search(params: any) {
    return this.http.get<PageResult>(API, { params : params })
  }
}
