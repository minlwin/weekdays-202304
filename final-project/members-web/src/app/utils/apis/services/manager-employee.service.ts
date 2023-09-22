import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { PageResult } from '../dto/page-result';

const API = `${environment.baseApi}/manager/employees`

@Injectable({
  providedIn: 'root'
})
export class ManagerEmployeeService {

  constructor(private http: HttpClient) { }

  search(form: any) {
    return this.http.get<PageResult>(API, { params: form })
  }

  save(form: any) {
    const {id, ...value} = form

    if(id > 0) {
      return this.update(id, value)
    }
    return this.create(value)
  }

  private create(value: any) {
    return this.http.post<any>(API, value)
  }

  private update(id: number, value: any) {
    return this.http.put<any>(`${API}/${id}`, value)
  }

  findById(id: number) {
    return this.http.get<any>(`${API}/${id}`)
  }
}
