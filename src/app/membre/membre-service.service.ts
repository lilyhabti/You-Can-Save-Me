import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { Membre } from '../models/membre';

@Injectable({
  providedIn: 'root'
})
export class MembreServiceService {

  private baseURL = "http://localhost:8080/membres";
  
  membre:Membre=new Membre();

  constructor(private httpClient: HttpClient) { }

  getMembresList(): Observable<Membre[]>{
    return this.httpClient.get<Membre[]>(`${this.baseURL}`);
  }

  createMembre(membre:Membre):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,membre);
  }

  getMembreById(id_user: number): Observable<Membre>{
    return this.httpClient.get<Membre>(`${this.baseURL}/${id_user}`);
  }

  updateEmployee(id_user: number, membre: Membre): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id_user}`, membre);
  }
}
