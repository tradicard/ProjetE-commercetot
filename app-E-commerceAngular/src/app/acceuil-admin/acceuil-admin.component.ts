import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Produit } from '../models/produit';

@Component({
  selector: 'app-acceuil-admin',
  templateUrl: './acceuil-admin.component.html',
  styleUrls: ['./acceuil-admin.component.css']
})
export class AcceuilAdminComponent implements OnInit {
  cherche!:string
  p!:Produit
    constructor(private router:Router) { }
  
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

}
