import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Utilisateur } from '../models/utilisateur';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurServiceService {

  constructor(private http:HttpClient) { }
  getAllUtilisateurs(){
    /*
    let basicchaine=this.createBasicHttpHeader();
    let headers= new HttpHeaders({
      Authorization:basicchaine
    })*/
    return this.http.get<Utilisateur[]>('http://localhost:8015/api/utilisateurs'
    /*,
    {headers:headers}*/);
  }
  DeleteUtilisateur(idProduit:number){
    return this.http.delete('http://localhost:8015/api/utilisateurs/'+idProduit)
  }
  ModifUtilisateur(formData:FormData){
    return this.http.put<Utilisateur>('http://localhost:8015/api/utilisateurs', formData)
  }
  
  getUtilisateur(username:string){
    return this.http.get<Utilisateur>('http://localhost:8015/api/utilisateurs/'+username)
  }
  
  postUtilisateur(u:Utilisateur){
    return this.http.post<Utilisateur>('http://localhost:8015/api/utilisateurs',u)
  }

}
