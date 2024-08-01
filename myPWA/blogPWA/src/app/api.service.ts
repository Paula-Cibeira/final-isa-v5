import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private apiUrl = 'http://localhost:8080/api'; // URL de la API de JHipster

  constructor(private http: HttpClient) {}

  getPosts(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/posts`); // Ajusta el endpoint según tu API
  }
}

//#getPosts(): Observable<any> {
//return this.http.get(`${this.apiUrl}/posts`);
