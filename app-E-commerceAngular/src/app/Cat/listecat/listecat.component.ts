import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from 'src/app/models/categorie';
import { Produit } from 'src/app/models/produit';
import { CategorieServiceService } from 'src/app/Services/categorie-service.service';
import { ProduitServiceService } from 'src/app/Services/produit-service.service';

@Component({
  selector: 'app-listecat',
  templateUrl: './listecat.component.html',
  styleUrls: ['./listecat.component.css']
})
export class ListecatComponent implements OnInit {
  categories!:Categorie[];
  c!:Categorie;
  produits!:Produit[];
  p!:Produit;
  constructor(private service:CategorieServiceService, private route:ActivatedRoute,private router:Router, private service2:ProduitServiceService) { }

  ngOnInit(): void {
    this.recuperer();
    this.c=new Categorie();
    this.p=new Produit();
  }
  recuperer() {
    this.service.getAllCategorie().subscribe(
    response=>this.categories=response
    )
  }

  deletion(id:number): void {
    //const idPersonne=+this.route.snapshot.params['id']
    this.service.DeleteCategorie(id).subscribe(
      response=>{
        //this.router.navigateByUrl('afficherPersonnes')
        this.recuperer2();
      }
    )
  } 

  retour(): void {
    this.router.navigateByUrl('')
  }
  saveCategorie(c:Categorie): void{
    this.service.postCategorie(c).subscribe(
      response=>  this.recuperer2()

    )
    
  }
  

  modification(id:number): void {
        this.router.navigateByUrl('ModifCategorie/'+id)
  }
  recuperer2() {
    this.service.getAllCategorie().subscribe(
    response=>this.categories=response
    )
  }

  search(idPassport:number): void{
    this.router.navigateByUrl('afficherUnProduit/'+idPassport)
  }


}
