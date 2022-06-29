import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Commande } from '../models/commande';
import { Panier } from '../models/panier';

@Injectable({
  providedIn: 'root'
})
export class CommandeServiceService {

  constructor(private http:HttpClient) { }

  getAllCommande(){

    return this.http.get<Commande[]>('http://localhost:8015/api/commandes');
  }
  DeleteCommande(idCategorie:number){
    return this.http.delete('http://localhost:8015/api/commandes/'+idCategorie)
  }

  ModiflignesCommande(c:Commande){
    return this.http.put<Commande>('http://localhost:8015/api/commandes', c)
  }
  
  getCommande(idCategorie:number){
    return this.http.get<Commande>('http://localhost:8015/api/commandes/'+idCategorie)
  }
  
  postCommande(co:Commande){
    return this.http.post<Commande>('http://localhost:8015/api/commandes', co)
  }
}
