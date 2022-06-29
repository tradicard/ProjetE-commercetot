import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Produit } from 'src/app/models/produit';
import { ProduitServiceService } from 'src/app/Services/produit-service.service';

@Component({
  selector: 'app-search-prod',
  templateUrl: './search-prod.component.html',
  styleUrls: ['./search-prod.component.css']
})
export class SearchProdComponent implements OnInit {

  p!:Produit;
  cherche!:string
  constructor(private service:ProduitServiceService,private route:ActivatedRoute,private router:Router) { }
  ngOnInit(): void {
    this.recuperer();

  }
  retour(): void {
    this.router.navigateByUrl('')
  }
  



recuperer() {
  let cherche=sessionStorage.getItem("cherche")
  console.log(this.cherche)
  this.service.getSearch(this.cherche).subscribe(
  response=>this.p=response
  )
  sessionStorage.removeItem("cherche")
}


}
