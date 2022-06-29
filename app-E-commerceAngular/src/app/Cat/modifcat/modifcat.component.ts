import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from 'src/app/models/categorie';
import { CategorieServiceService } from 'src/app/Services/categorie-service.service';

@Component({
  selector: 'app-modifcat',
  templateUrl: './modifcat.component.html',
  styleUrls: ['./modifcat.component.css']
})
export class ModifcatComponent implements OnInit {
  c!:Categorie;
  constructor(private service:CategorieServiceService, private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.recupererC();
  }

  retour(): void {
    this.router.navigateByUrl('')
  }

  recupererC() {
    const idCategorie=+this.route.snapshot.params['id']
    console.log(idCategorie)
    this.service.getCategorie(idCategorie).subscribe(
    response=>this.c=response
    )
  }

  modif(){
    console.log(this.c.idCategorie)
    this.service.ModifCategorie(this.c).subscribe(
      response=>this.router.navigateByUrl('afficherCategories'))
    
  }

}
