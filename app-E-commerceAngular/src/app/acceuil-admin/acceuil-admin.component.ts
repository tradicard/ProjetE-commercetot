import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Produit } from '../models/produit';
import { CommandeServiceService } from '../Services/commande-service.service';

@Component({
  selector: 'app-acceuil-admin',
  templateUrl: './acceuil-admin.component.html',
  styleUrls: ['./acceuil-admin.component.css']
})
export class AcceuilAdminComponent implements OnInit {
  cherche!:string
  p!:Produit
  blob!:Blob;
    constructor(private router:Router, private service:CommandeServiceService) { }
  
    ngOnInit(): void {
      this.p= new Produit()
      this.p.nomProduit=this.cherche
    }
  
    afficherCategories(): void {
      this.router.navigateByUrl('afficherCategories')
    }
    connectionutil(): void {
      this.router.navigateByUrl('Authentication')
    }
    logout():void{
      //sessionStorage.removeItem("b")
      sessionStorage.removeItem("token")
      sessionStorage.removeItem("u")
      this.router.navigateByUrl('Authentication')
    }
    afficherProduits(): void {
      this.router.navigateByUrl('afficherProduits')
    }
    afficherProduitsC(): void {
      this.router.navigateByUrl('afficherProduitsC')
    }
  
  afficherPaniers(): void {
    this.router.navigateByUrl('afficherPaniers')
  }
  
  searchprod(): void {
    this.router.navigateByUrl('afficherUnProduit')
    sessionStorage.setItem("cherche",this.p.nomProduit)
    console.log(this.cherche)
    //this.router.navigateByUrl('afficherUnProduit')
  }
  afficherCommandes(){
    this.router.navigateByUrl('afficherCommandes')
  }
 /*  afficherPDFCommandes(){
    this.service.getPDfCommandes().subscribe()
  } */
  public showPDF(): void {
    this.service.getPdf().subscribe((data) => {

      this.blob = new Blob([data], {type: 'application/pdf'});
    
      var downloadURL = window.URL.createObjectURL(data);
      var link = document.createElement('a');
      link.href = downloadURL;
      link.download = "help.pdf";
      link.click();
    
    });

}
}
