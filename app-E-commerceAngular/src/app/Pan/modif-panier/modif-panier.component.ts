import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from 'src/app/models/categorie';
import { LignePanier } from 'src/app/models/ligne-panier';
import { Panier } from 'src/app/models/panier';
import { Produit } from 'src/app/models/produit';
import { CategorieServiceService } from 'src/app/Services/categorie-service.service';
import { LignePanierService } from 'src/app/Services/ligne-panier.service';
import { PanierService } from 'src/app/Services/panier.service';
import { ProduitServiceService } from 'src/app/Services/produit-service.service';

@Component({
  selector: 'app-modif-panier',
  templateUrl: './modif-panier.component.html',
  styleUrls: ['./modif-panier.component.css']
})
export class ModifPanierComponent implements OnInit {

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
  constructor(private service4:LignePanierService,private service:PanierService, private route:ActivatedRoute,private router:Router, private service2:ProduitServiceService, private service3:CategorieServiceService) { }

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
  save(id:number) {
    this.router.navigateByUrl('ModifLignePanier/'+id)
  }
  modif(idPanier:number) {
    this.router.navigateByUrl('ModifPanier/'+idPanier)
  }
  suppr(idLignePanier:number) {
    this.service4.DeleteLignePanier(idLignePanier).subscribe(
    response=>this.recuperer2()
    )
  }
  recupererP() {
    this.service2.getAllProduits().subscribe(
    response=>this.produits=response
    )
  }
  recuperer() {
    const idPanier=+this.route.snapshot.params['id']

    this.service4.getAllParPanier(idPanier).subscribe(
    response=>{this.lignesPanier=response
    for (let i=0;i< this.lignesPanier.length;i++){
      console.log(this.lignesPanier[i].quantite)
    }}
    )
  }



  retour(): void {
    this.router.navigateByUrl('afficherPaniers')
  }

  
  recuperer2() {
    const idPanier=+this.route.snapshot.params['id']
    this.service4.getAllParPanier(idPanier).subscribe(
    response=>this.lignesPanier=response)
  }




}
