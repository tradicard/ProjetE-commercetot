import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from 'src/app/models/categorie';
import { Produit } from 'src/app/models/produit';
import { CategorieServiceService } from 'src/app/Services/categorie-service.service';
import { ProduitServiceService } from 'src/app/Services/produit-service.service';

@Component({
  selector: 'app-listeprod',
  templateUrl: './listeprod.component.html',
  styleUrls: ['./listeprod.component.css']
})
export class ListeprodComponent implements OnInit {
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
    this.service.getAllProduits().subscribe(
    response=>this.produits=response
    )
  }

  deletion(id:number): void {
    //const idPersonne=+this.route.snapshot.params['id']
    this.service.DeleteProduit(id).subscribe(
      response=>{
        //this.router.navigateByUrl('afficherPersonnes')
        this.recuperer2();
      }
    )
  } 

  retour(): void {
    this.router.navigateByUrl('')
  }
  selectEvent(event:any): void {
    this.selectedFile=event.target.files[0];
  }
  

   save(): void{
    console.log(this.selectedFile.name)
    this.printedOption=this.selectedOption;
    let formData=new FormData();
    formData.append("file", this.selectedFile)
    formData.append("nomProduit",this.p.nomProduit)
    formData.append("idcat",this.printedOption.toString())
    formData.append("quantite",this.p.quantite.toString())
    console.log(this.printedOption)
    this.service.postProduit(formData).subscribe(
      response=>{  
        this.recuperer2()
      }
    )
    
  } 
 
  recupererC() {
    this.service2.getAllCategorie().subscribe(
    response=>this.categories=response
    )
  }
  

  modification(id:number): void {
        this.router.navigateByUrl('ModifProduit/'+id)
  }
  recuperer2() {
    this.service.getAllProduits().subscribe(
    response=>this.produits=response
    )
  }

}
