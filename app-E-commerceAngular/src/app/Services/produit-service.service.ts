import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Produit } from '../models/produit';


@Injectable({
  providedIn: 'root'
})
export class ProduitServiceService {

  constructor(private http:HttpClient) { }

  getAllProduits(){
    /*
    let basicchaine=this.createBasicHttpHeader();
    let headers= new HttpHeaders({
      Authorization:basicchaine
    })*/
    return this.http.get<Produit[]>('http://localhost:8015/api/produits'
    /*,
    {headers:headers}*/);
  }
  DeleteProduit(idProduit:number){
    return this.http.delete('http://localhost:8015/api/produits/'+idProduit)
  }
  ModifProduit(formData:FormData){
    return this.http.put<Produit>('http://localhost:8015/api/produits', formData)
  }
  
  getProduit(idPassport:number){
    return this.http.get<Produit>('http://localhost:8015/api/produits/'+idPassport)
  }
  
  postProduit(formData:FormData){
    return this.http.post<Produit>('http://localhost:8015/api/produits',formData)
  }

  getSearch(cherche:string){
    return this.http.get<Produit>('http://localhost:8015/api/produitsch/'+cherche)
  }

  getAllProduitsparCat(idcat:number){
    
    return this.http.get<Produit[]>('http://localhost:8015/api/produitscats/'+idcat);
  }
}
