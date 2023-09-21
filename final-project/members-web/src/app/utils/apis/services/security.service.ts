import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { SignInResult } from '../dto/signin-result';

const API = `${environment.baseApi}/public/signin`

@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  constructor(private http: HttpClient) { }

  singIn(form: any) {
    return this.http.post<SignInResult>(`${API}`, form)
  }
}
