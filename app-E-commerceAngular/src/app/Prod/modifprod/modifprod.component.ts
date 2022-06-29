import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from 'src/app/models/categorie';
import { Produit } from 'src/app/models/produit';
import { CategorieServiceService } from 'src/app/Services/categorie-service.service';
import { ProduitServiceService } from 'src/app/Services/produit-service.service';

@Component({
  selector: 'app-modifprod',
  templateUrl: './modifprod.component.html',
  styleUrls: ['./modifprod.component.css']
})
export class ModifprodComponent implements OnInit {
  categories!:Categorie[];
  c!:Categorie;
  produits!:Produit[];
  p!:Produit;
  selectedOption!: number;
  printedOption!: number;
  selectedFile!: File;
  constructor(private service2:CategorieServiceService, private route:ActivatedRoute,private router:Router, private service:ProduitServiceService) { }

  ngOnInit(): void {
    this.recuperer();
    this.recupererC();
    this.c=new Categorie();
    this.p=new Produit();
  }
  recuperer() {
    const idProduit=+this.route.snapshot.params['id']
    this.service.getProduit(idProduit).subscribe(
    response=>this.p=response
    )
  } 

  retour(): void {
    this.router.navigateByUrl('')
  }
  selectEvent(event:any): void {
    this.selectedFile=event.target.files[0];
  }
  

   save(): void{
    const idProduit=+this.route.snapshot.params['id']
    console.log(this.selectedFile.name)
    this.printedOption=this.selectedOption;
    let formData=new FormData();
    formData.append("file", this.selectedFile)
    formData.append("nomProduit",this.p.nomProduit)
    formData.append("idcat",this.printedOption.toString())
    formData.append("quantite",this.p.quantite.toString())
    formData.append("id",idProduit.toString())
    console.log(this.printedOption)
    this.service.ModifProduit(formData).subscribe(
      response=>{  
        this.router.navigateByUrl('afficherProduits')
      }
    )
    
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

}
