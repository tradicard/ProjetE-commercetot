import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
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
  getPdf() {

    const httpOptions = {
      responseType: ('blob' as 'json')
    };
  
    return this.http.get<any>('http://localhost:8015/pdfreport', httpOptions);
  }

  public getPDF2(): Observable<Blob> {   
    //const options = { responseType: 'blob' }; there is no use of this
        let uri = 'http://localhost:8015/pdfreport';
        // this.http refers to HttpClient. Note here that you cannot use the generic get<Blob> as it does not compile: instead you "choose" the appropriate API in this way.
        return this.http.get(uri, { responseType: 'blob' });
    }
  /*
  getPDfCommandes(){
    return this.http.get<any>()
  }
*/
  getCSVCommandes(){
    return this.http.get<any>('http://localhost:8015/exportCSVcommandes')
  }

  getCommande(idCategorie:number){
    return this.http.get<Commande>('http://localhost:8015/api/commandes/'+idCategorie)
  }

  
  
  postCommande(co:Commande){
    return this.http.post<Commande>('http://localhost:8015/api/commandes', co)
  }
}
