import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Taskclass } from '../models/taskclass';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private baseURL = "http://localhost:8080/tasks";

  constructor(private httpClient: HttpClient) { }

  getTasksList(): Observable<Taskclass[]>{
    return this.httpClient.get<Taskclass[]>(`${this.baseURL}`);
  }

  createTask(task: Taskclass): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, task);
  }

  getTaskById(id_task: number): Observable<Taskclass>{
    return this.httpClient.get<Taskclass>(`${this.baseURL}/${id_task}`);
  }
  updateTask(id_task: number, task: Taskclass): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id_task}`, task);
  }

  deleteTask(id_task: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id_task}`);
  }
}
