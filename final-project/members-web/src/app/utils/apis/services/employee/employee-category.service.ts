import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';

const API = `${environment.baseApi}/employee/categories`

@Injectable({
  providedIn: 'root'
})
export class EmployeeCategoryService {

  constructor(private http: HttpClient) {}

  save(form: any) {
    const {id, ...value} = form

    if(id)
      return this.update(id, value)

    return this.create(value)
  }

  private create(data: any) {
    return this.http.post<any>(API, data)
  }

  private update(id: number, data: any) {
    return this.http.put<any>(`${API}/${id}`, data)
  }

  search() {
    return this.http.get<any[]>(API)
  }
}
