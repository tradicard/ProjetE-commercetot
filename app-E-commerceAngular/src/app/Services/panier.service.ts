import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Panier } from '../models/panier';

@Injectable({
  providedIn: 'root'
})
export class PanierService {

  constructor(private http:HttpClient) { }

  getAllPanier(){

    return this.http.get<Panier[]>('http://localhost:8015/api/paniers');
  }
  DeletePanier(idCategorie:number){
    return this.http.delete('http://localhost:8015/api/paniers/'+idCategorie)
  }
  EcrasePanier(){
    return this.http.delete('http://localhost:8015/api/paniers')
  }
  ModifPanier(c:Panier){
    return this.http.put<Panier>('http://localhost:8015/api/paniers', c)
  }
  
  getPanier(idCategorie:number){
    return this.http.get<Panier>('http://localhost:8015/api/paniers/'+idCategorie)
  }
  
  postPanier(c:Panier){
    return this.http.post<Panier>('http://localhost:8015/api/paniers', c)
  }
}
