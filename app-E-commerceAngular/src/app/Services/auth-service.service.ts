import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private http:HttpClient) { }

  authenticate(username:string, password:string) {
        
    return this.http.post<any>('http://localhost:8015/authenticate', {username,password} )
  
  }
}
