import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { PageResult } from '../../dto/page-result';

const API = `${environment.baseApi}/employee/catalogs`

@Injectable({
  providedIn: 'root'
})
export class EmployeeCatalogService {

  constructor(private http: HttpClient) {}

  save(catalog: any) {
    const {id, ...value} = catalog

    if(id > 0)
      return this.update(id, value)

    return this.create(value)
  }

  private create(value: any) {
    return this.http.post<any>(API, value)
  }

  private update(id: number, value: any) {
    return this.http.put<any>(`${API}/${id}`, value)
  }

  search(params: any) {
    return this.http.get<PageResult>(API, { params: params })
  }

  findById(id: number) {
    return this.http.get<any>(`${API}/${id}`)
  }

  uploadPhotos(id: number, photos: any) {
    return this.http.get<any>(`${API}/${id}/uploads`)
  }
}
