import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from 'src/app/models/categorie';
import { LignePanier } from 'src/app/models/ligne-panier';
import { Panier } from 'src/app/models/panier';
import { Produit } from 'src/app/models/produit';
import { LignePanierService } from 'src/app/Services/ligne-panier.service';
import { PanierService } from 'src/app/Services/panier.service';
import { ProduitServiceService } from 'src/app/Services/produit-service.service';

@Component({
  selector: 'app-modif-ligne-panier',
  templateUrl: './modif-ligne-panier.component.html',
  styleUrls: ['./modif-ligne-panier.component.css']
})
export class ModifLignePanierComponent implements OnInit {

  categories!:Categorie[];
  c!:Categorie;
  produits!:Produit[];
  p!:Produit;
  pa!:Panier
  paniers!:Panier[];
  selectedOption!:number
  selectedOption2!:number
  pan!:Panier
  l!:LignePanier
  lignesPanier!:LignePanier[]
  constructor(private service:LignePanierService,private service3:PanierService, private route:ActivatedRoute,private router:Router, private service2:ProduitServiceService) { }

  ngOnInit(): void {
    this.lignesPanier=[];
    this.recuperer();
    for (let i=0;i< this.lignesPanier.length;i++){
      console.log(this.lignesPanier[i].quantite)
    }
    this.recupererP()
    this.c=new Categorie();
    this.p=new Produit();
    this.pa=new Panier();
  }
  save() {
    
      this.service2.getProduit(this.selectedOption).subscribe(
        response=>{this.l.produit=response
          this.service.ModifLignePanier(this.l).subscribe(
            response=>this.router.navigateByUrl('afficherPaniers')
          )
        }
      )
  }
  suppr(idLignePanier:number) {
    this.service.DeleteLignePanier(idLignePanier).subscribe(
      response=>this.router.navigateByUrl('afficherPaniers')
    )
  }
  recupererP() {
    
    this.service2.getAllProduits().subscribe(
    response=>this.produits=response
    )
  }
  recuperer() {
    const idPanier=+this.route.snapshot.params['id']

    this.service.getLignePanier(idPanier).subscribe(
    response=>{this.l=response
    for (let i=0;i< this.lignesPanier.length;i++){
      console.log(this.lignesPanier[i].quantite)
    }}
    )
  }



  retour(): void {
    this.router.navigateByUrl('afficherPaniers')
  }

  
}
