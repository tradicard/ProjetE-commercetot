import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ListeprodComponent } from './Prod/listeprod/listeprod.component';
import { SingleprodComponent } from './Prod/singleprod/singleprod.component';
import { ModifprodComponent } from './Prod/modifprod/modifprod.component';
import { ListecatComponent } from './Cat/listecat/listecat.component';
import { ModifcatComponent } from './Cat/modifcat/modifcat.component';
import { ListeprodclientComponent } from './Prod/listeprodclient/listeprodclient.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { InterceptServiceService } from './Services/intercept-service.service';
import { AuthComponent } from './auth/auth.component';
import { ListCommandeComponent } from './Command/list-commande/list-commande.component';
import { ListePanierComponent } from './Pan/liste-panier/liste-panier.component';
import { ModifPanierComponent } from './Pan/modif-panier/modif-panier.component';
import { ModifLignePanierComponent } from './LignePan/modif-ligne-panier/modif-ligne-panier.component';
import { SearchProdComponent } from './Prod/search-prod/search-prod.component';
import { AddUtilisateurComponent } from './add-utilisateur/add-utilisateur.component';


@NgModule({
  declarations: [
    AppComponent,
    ListeprodComponent,
    SingleprodComponent,
    ModifprodComponent,
    ListecatComponent,
    ModifcatComponent,
    ListeprodclientComponent,
    AuthComponent,
    ListCommandeComponent,
    ListePanierComponent,
    ModifPanierComponent,
    ModifLignePanierComponent,
    SearchProdComponent,
    AddUtilisateurComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [{provide:HTTP_INTERCEPTORS,useClass:InterceptServiceService,multi:true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
