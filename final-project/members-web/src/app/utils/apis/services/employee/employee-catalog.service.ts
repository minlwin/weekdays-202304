import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';

const API = `${environment.baseApi}/employee/catalogs`

@Injectable({
  providedIn: 'root'
})
export class EmployeeCatalogService {

  constructor() { }
}
