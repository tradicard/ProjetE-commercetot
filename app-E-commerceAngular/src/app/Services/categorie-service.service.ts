import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Categorie } from '../models/categorie';

@Injectable({
  providedIn: 'root'
})
export class CategorieServiceService {

  constructor(private http:HttpClient) { }

  getAllCategorie(){

    return this.http.get<Categorie[]>('http://localhost:8015/api/categories');
  }
  DeleteCategorie(idCategorie:number){
    return this.http.delete('http://localhost:8015/api/categories/'+idCategorie)
  }
  ModifCategorie(c:Categorie){
    return this.http.put<Categorie>('http://localhost:8015/api/categories', c)
  }
  
  getCategorie(idCategorie:number){
    return this.http.get<Categorie>('http://localhost:8015/api/categories/'+idCategorie)
  }
  
  postCategorie(c:Categorie){
    return this.http.post<Categorie>('http://localhost:8015/api/categories', c)
  }
}
