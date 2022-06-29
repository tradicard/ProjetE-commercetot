import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Utilisateur } from '../models/utilisateur';
import { AuthServiceService } from '../Services/auth-service.service';
import { UtilisateurServiceService } from '../Services/utilisateur-service.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
  username!:string
  password!:string
  invalidLogin=false
  u!:Utilisateur
  ut!:Utilisateur
  dat!:string
  error=false
  constructor(private serviceut: UtilisateurServiceService,private service: AuthServiceService , private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.u=new Utilisateur()
  }

  register(){
    this.router.navigateByUrl('addUtilisateur')
  }


  login(){
     console.log(this.username)
    this.service.authenticate(this.username, this.password).subscribe(
      response=>{
        console.log(response.jwt)
        sessionStorage.setItem("token", "Bearer "+response.jwt)
        sessionStorage.setItem("username", this.username)
        
        this.invalidLogin=false
        this.serviceut.getUtilisateur(this.username).subscribe(
          response=>{
            
            this.u=response
            console.log(this.u.role.idRole)
            
            if(this.u.role.idRole===1){
              this.router.navigateByUrl('Admin')
            }
            else{
              this.router.navigateByUrl('')
            }
            
          sessionStorage.setItem("u",JSON.stringify(this.u))
          
          let uStr = sessionStorage.getItem("u");

          if (uStr) {
            this.ut = JSON.parse(uStr) as Utilisateur;
          }
          console.log(this.ut.nom)
          
          }
        )
      },
      error=>{
        this.invalidLogin=true
        console.log("ko  ko")
      }
    );
    return false;
  }


}
