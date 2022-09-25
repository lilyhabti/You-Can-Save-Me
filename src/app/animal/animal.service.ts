import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Animal } from '../models/animal';

@Injectable({
  providedIn: 'root'
})
export class AnimalService {

  private baseURL = "http://localhost:8080/animals";

  constructor(private httpClient: HttpClient) { }

  getAnimalsList(): Observable<Animal[]>{
    return this.httpClient.get<Animal[]>(`${this.baseURL}`);
  }

  createAnimal(animal: Animal): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, animal);
  }
  updateEmployee(id_animal: number, animal: Animal): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id_animal}`, animal);
  }
  getAnimalById(id_animal: number): Observable<Animal>{
    return this.httpClient.get<Animal>(`${this.baseURL}/${id_animal}`);
  }
  deleteAnimal(id_animal: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id_animal}`);
  }
}
