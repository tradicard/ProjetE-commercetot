import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from 'src/app/models/categorie';
import { Produit } from 'src/app/models/produit';
import { CategorieServiceService } from 'src/app/Services/categorie-service.service';
import { ProduitServiceService } from 'src/app/Services/produit-service.service';

@Component({
  selector: 'app-listeprodclient',
  templateUrl: './listeprodclient.component.html',
  styleUrls: ['./listeprodclient.component.css']
})
export class ListeprodclientComponent implements OnInit {
  categories!:Categorie[];
  c!:Categorie;
  produits!:Produit[];
  p!:Produit;
  selectedOption!: number;
  printedOption!: number;
  constructor(private service2:CategorieServiceService, private route:ActivatedRoute,private router:Router, private service:ProduitServiceService) { }

  ngOnInit(): void {
    this.recuperer();
    this.recupererC();
    this.c=new Categorie();
    this.p=new Produit();
  }
  recuperer() {
    this.service.getAllProduits().subscribe(
    response=>this.produits=response
    )
  }
  cate(){
    
    this.service.getAllProduitsparCat(this.selectedOption).subscribe(
      response=>this.produits=response
      )
  }


  retour(): void {
    this.router.navigateByUrl('')
  }
  
 
  recupererC() {
    this.service2.getAllCategorie().subscribe(
    response=>this.categories=response
    )
  }
  

 
  recuperer2() {
    this.service.getAllProduits().subscribe(
    response=>this.produits=response
    )
  }
  reset() {
    this.recuperer2()
  }
}
