import { ThisReceiver } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from 'src/app/models/categorie';
import { Commande } from 'src/app/models/commande';
import { LigneCommande } from 'src/app/models/ligne-commande';
import { LignePanier } from 'src/app/models/ligne-panier';
import { Panier } from 'src/app/models/panier';
import { Produit } from 'src/app/models/produit';
import { Utilisateur } from 'src/app/models/utilisateur';
import { CategorieServiceService } from 'src/app/Services/categorie-service.service';
import { CommandeServiceService } from 'src/app/Services/commande-service.service';
import { LigneCommandeService } from 'src/app/Services/ligne-commande.service';
import { LignePanierService } from 'src/app/Services/ligne-panier.service';
import { PanierService } from 'src/app/Services/panier.service';
import { ProduitServiceService } from 'src/app/Services/produit-service.service';
import { UtilisateurServiceService } from 'src/app/Services/utilisateur-service.service';

@Component({
  selector: 'app-liste-panier',
  templateUrl: './liste-panier.component.html',
  styleUrls: ['./liste-panier.component.css']
})
export class ListePanierComponent implements OnInit {
  categories!:Categorie[];
  c!:Categorie;
  produits!:Produit[];
  p!:Produit;
  pa!:Panier
  paniers!:Panier[];
  selectedOption!:number
  selectedOption2!:number
  pan!:Panier
  lp!:LignePanier
  lignesPanier!:LignePanier[]
  username2!:string
  lignesCommande!:LigneCommande[]
  co!:Commande
  lc!:LigneCommande;
  lpa!:LignePanier
  u!:Utilisateur
  lignesPaniers!:LignePanier[];
  doublon=false;
  trop=false;
  constructor(private servicelc:LigneCommandeService,private serviceco:CommandeServiceService,private service5:UtilisateurServiceService,private service4:LignePanierService,private service:PanierService, private route:ActivatedRoute,private router:Router, private service2:ProduitServiceService, private service3:CategorieServiceService) { }

  ngOnInit(): void {
    this.recuperer();
    this.recupererC()
    this.recupererP()
    this.recupererLP()
    this.c=new Categorie();
    this.p=new Produit();
    this.pa=new Panier();
    this.lp=new LignePanier();
    this.co=new Commande();


  }
  recupererC() {
    this.service3.getAllCategorie().subscribe(
    response=>this.categories=response
    )
  }
  
  confirm(idPanier:number) {
    
    let uStr = sessionStorage.getItem("u");
    if (uStr) {
      this.u = JSON.parse(uStr) as Utilisateur;
    }
    
    console.log(this.u.nom)
    console.log(this.u.id)
    this.co.utilisateur=this.u
    console.log(this.co.utilisateur.nom)
    
    this.service4.getAllParPanier(idPanier).subscribe(
      response=>{
        this.lignesPaniers=response
        for(let k=0;k<this.lignesPaniers.length;k++){
          for(let j=0;j<this.lignesPaniers.length;j++){
            if(k!=j){
              if(this.lignesPanier[k].produit.idProduit===this.lignesPanier[j].produit.idProduit){
                this.doublon=true
                console.log("doublon!!!")
                return
              }
            }
          }
          if(this.lignesPaniers[k].quantite>this.lignesPaniers[k].produit.quantite){
            this.trop=true
            console.log("trop!!!")
            return
          }
        }


        
        this.serviceco.postCommande(this.co).subscribe(
          response=>{
            this.co=response;
            for(let i=0;i<this.lignesPaniers.length;i++){
              this.lc =new LigneCommande();
              this.lc.commande=this.co
              this.lc.produit=this.lignesPaniers[i].produit;
              this.lc.quantite=this.lignesPaniers[i].quantite;
              this.servicelc.postlignesCommande(this.lc).subscribe()
            }
            this.service.DeletePanier(this.lignesPanier[0].panier.idPanier).subscribe(
              response=>{this.recuperer2()
              this.recupererP()}
            )
          
          }
        )


        
        
        
      }
    )    
  }

  modif(idPanier:number) {
    this.router.navigateByUrl('ModifPanier/'+idPanier)
  }
  suppr(idPanier:number) {
    this.service.DeletePanier(idPanier).subscribe(
    response=>this.recuperer2()
    )
  }
  Ajouter() {
    this.service.postPanier(this.pa).subscribe(
    response=>this.recuperer2()
    )
  }
  recupererP() {
    this.service2.getAllProduits().subscribe(
    response=>this.produits=response
    )
  }
  recuperer() {
    this.service.getAllPanier().subscribe(
    response=>this.paniers=response
    )
  }

  recupererLP() {
    this.service4.getAllLignePanier().subscribe(
    response=>this.lignesPanier=response
    )
  }
  
  addPanier(id:number){
    console.log(this.selectedOption2)
    this.service.getPanier(this.selectedOption2).subscribe(
      response=>{this.pan=response
        this.lp.panier=response
        this.service2.getProduit(id).subscribe(
          response=>{
            this.lp.produit=response
            this.service4.postLignePanier(this.lp).subscribe(
              response=>{this.recupererLP()
              this.recuperer2}
            )
          }
      )
      }
    )
  }

  retour(): void {
    this.router.navigateByUrl('')
  }
  cate(){
    
    this.service2.getAllProduitsparCat(this.selectedOption).subscribe(
      response=>this.produits=response
      )
  }
  


  recuperer2() {
    this.service.getAllPanier().subscribe(
    response=>this.paniers=response
    )
  }


  reset() {
    this.recupererP()
  }

}
