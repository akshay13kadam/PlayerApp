import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class PlayerService {

  private baseUrl = 'http://localhost:8080/api/';

  constructor(private http:HttpClient) { }

  getPlayerList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+'player-list');
  }

  createPlayer(player: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`+'save-player', player);
  }

  deletePlayer(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete-player/${id}`, { responseType: 'text' });
  }

  getPlayer(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/player/${id}`);
  }

  updatePlayer(id: number, value: any): Observable<Object> {
    return this.http.post(`${this.baseUrl}/update-player/${id}`, value);
  }
  
}                                           