import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LigneCommande } from '../models/ligne-commande';

@Injectable({
  providedIn: 'root'
})
export class LigneCommandeService {

  constructor(private http:HttpClient) { }

  getAlllignesCommande(){

    return this.http.get<LigneCommande[]>('http://localhost:8015/api/lignesCommande');
  }
  getAlllignesCommandeParCommande(idCommande:number){

    return this.http.get<LigneCommande[]>('http://localhost:8015/api/lignesCommandes/'+idCommande);
  }
  DeletelignesCommande(idCategorie:number){
    return this.http.delete('http://localhost:8015/api/lignesCommande/'+idCategorie)
  }

  ModiflignesCommande(c:LigneCommande){
    return this.http.put<LigneCommande>('http://localhost:8015/api/lignesCommande', c)
  }
  
  getlignesCommande(idCategorie:number){
    return this.http.get<LigneCommande>('http://localhost:8015/api/lignesCommande/'+idCategorie)
  }
  
  postlignesCommande(c:LigneCommande){
    return this.http.post<LigneCommande>('http://localhost:8015/api/lignesCommande', c)
  }
}
