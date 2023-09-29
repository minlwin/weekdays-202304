import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { PageResult } from '../../dto/page-result';

const API = `${environment.baseApi}/employee/customers`

@Injectable({
  providedIn: 'root'
})
export class EmployeeCustomerService {

  constructor(private http: HttpClient) { }

  save(customer: any) {
    const {id, ...value} = customer

    if(id > 0)
      return this.update(id, value)

    return this.create(value)
  }

  private create(data: any) {
    return this.http.post<any>(API, data)
  }

  private update(id: number, data: any) {
    return this.http.put<any>(`${API}/${id}`, data)
  }

  search(params: any) {
    return this.http.get<PageResult>(API, { params: params } )
  }

  findById(id: number) {
    return this.http.get<any>(`${API}/${id}`)
  }

  findByIdForEdit(id: number) {
    return this.http.get<any>(`${API}/${id}/edit`)
  }
}
