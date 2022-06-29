import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Produit } from 'src/app/models/produit';
import { ProduitServiceService } from 'src/app/Services/produit-service.service';

@Component({
  selector: 'app-singleprod',
  templateUrl: './singleprod.component.html',
  styleUrls: ['./singleprod.component.css']
})
export class SingleprodComponent implements OnInit {
  p!:Produit;
  cherche!:string
  constructor(private service:ProduitServiceService,private route:ActivatedRoute,private router:Router) { }
  ngOnInit(): void {
    //this.recupererP();

  }
  retour(): void {
    this.router.navigateByUrl('')
  }
  
  recupererP() {
    const idProduit=+this.route.snapshot.params['id']
    console.log(idProduit)
    this.service.getProduit(idProduit).subscribe(
    response=>this.p=response
    )
  }

/*
recuperer() {
  this.cherche=+this.route.snapshot.params['cherche']
  console.log(this.cherche)
  this.service.getSearch(this.cherche).subscribe(
  response=>this.p=response
  )
}
*/
}
