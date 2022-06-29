
import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Role } from '../models/role';
import { Utilisateur } from '../models/utilisateur';
import { UtilisateurServiceService } from '../Services/utilisateur-service.service';

@Component({
  selector: 'app-add-utilisateur',
  templateUrl: './add-utilisateur.component.html',
  styleUrls: ['./add-utilisateur.component.css']
})
export class AddUtilisateurComponent implements OnInit {
u!:Utilisateur
dateNaissance!:Date
dat!:string
errorr=false
  constructor( private service:UtilisateurServiceService, private router: Router) { }

  ngOnInit(): void {
    this.u=new Utilisateur()
  }

  save(){

    this.service.postUtilisateur(this.u).subscribe(
      response=>{ 
        this.router.navigateByUrl('Authentication')
      },
      error=>this.errorr=true
      

    )
  }
}
