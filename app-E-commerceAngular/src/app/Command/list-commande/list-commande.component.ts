import { Component, OnInit } from '@angular/core';
import { Commande } from 'src/app/models/commande';
import { LigneCommande } from 'src/app/models/ligne-commande';
import { CommandeServiceService } from 'src/app/Services/commande-service.service';
import { LigneCommandeService } from 'src/app/Services/ligne-commande.service';

@Component({
  selector: 'app-list-commande',
  templateUrl: './list-commande.component.html',
  styleUrls: ['./list-commande.component.css']
})
export class ListCommandeComponent implements OnInit {
commandes!:Commande[]
lignesCommandes!:LigneCommande[]
  constructor(private service:CommandeServiceService,private servicelc:LigneCommandeService) { }

  ngOnInit(): void {
    this.recuperer()
    this.recupererLc()
  }

  recuperer(){
    this.service.getAllCommande().subscribe(
      response=>this.commandes=response
    )
  }
  recupererLc(){
    this.servicelc.getAlllignesCommande().subscribe(
      response=>this.lignesCommandes=response
    )
  }

}
