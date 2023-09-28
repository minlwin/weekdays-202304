import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment.development";

const API = `${environment.baseApi}/public/locations`

@Injectable({
  providedIn: 'root'
})
export class PublicLocationService {

  constructor(private http: HttpClient) {}

  getAllDivisions() {
    return this.http.get<any[]>(`${API}/divisions`)
  }

  getTownshipByDivision(divisionId: number) {
    return this.http.get<any[]>(`${API}/townships`, {params: {division: divisionId}})
  }

}
