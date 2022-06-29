import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LignePanier } from '../models/ligne-panier';

@Injectable({
  providedIn: 'root'
})
export class LignePanierService {

  constructor(private http:HttpClient) { }

  getAllLignePanier(){

    return this.http.get<LignePanier[]>('http://localhost:8015/api/LignesPanier');
  }
  getAllParPanier(idPanier:number){

    return this.http.get<LignePanier[]>('http://localhost:8015/api/LignesPanierParPanier/'+idPanier);
  }
  DeleteLignePanier(idCategorie:number){
    return this.http.delete('http://localhost:8015/api/LignesPanier/'+idCategorie)
  }

  ModifLignePanier(lp:LignePanier){
    return this.http.put<LignePanier>('http://localhost:8015/api/LignesPanier', lp)
  }
  
  getLignePanier(idCategorie:number){
    return this.http.get<LignePanier>('http://localhost:8015/api/LignesPanier/'+idCategorie)
  }
  
  postLignePanier(c:LignePanier){
    return this.http.post<LignePanier>('http://localhost:8015/api/LignesPanier', c)
  }
}
