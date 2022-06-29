import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AcceuilAdminComponent } from "./acceuil-admin/acceuil-admin.component";
import { AcceuilComponent } from "./acceuil/acceuil.component";
import { AddUtilisateurComponent } from "./add-utilisateur/add-utilisateur.component";
import { AuthComponent } from "./auth/auth.component";
import { ListecatComponent } from "./Cat/listecat/listecat.component";
import { ModifcatComponent } from "./Cat/modifcat/modifcat.component";
import { ListCommandeComponent } from "./Command/list-commande/list-commande.component";
import { ModifLignePanierComponent } from "./LignePan/modif-ligne-panier/modif-ligne-panier.component";
import { ListePanierComponent } from "./Pan/liste-panier/liste-panier.component";
import { ModifPanierComponent } from "./Pan/modif-panier/modif-panier.component";
import { ListeprodComponent } from "./Prod/listeprod/listeprod.component";
import { ListeprodclientComponent } from "./Prod/listeprodclient/listeprodclient.component";
import { ModifprodComponent } from "./Prod/modifprod/modifprod.component";
import { SearchProdComponent } from "./Prod/search-prod/search-prod.component";
import { SingleprodComponent } from "./Prod/singleprod/singleprod.component";

const routes: Routes = [
    {path:'afficherProduits',component:ListeprodComponent},
    {path:'afficherPaniers',component:ListePanierComponent},
    {path:'afficherProduitsC',component:ListeprodclientComponent},
    {path:'',component:AcceuilComponent},
    {path:'Admin',component:AcceuilAdminComponent},
    {path:'afficherCategories',component:ListecatComponent},
    {path:'ModifCategorie/:id',component:ModifcatComponent},
    {path:'afficherUnProduit/:id',component:SingleprodComponent},
    {path:'afficherUnProduit',component:SearchProdComponent},
    {path:'Authentication',component:AuthComponent},
    {path:'ModifPanier/:id',component:ModifPanierComponent},
    {path:'ModifProduit/:id',component:ModifprodComponent},
    {path:'ModifLignePanier/:id',component:ModifLignePanierComponent},
    {path:'afficherCommandes',component:ListCommandeComponent},
    {path:'addUtilisateur',component:AddUtilisateurComponent},

     ]


@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })

  export class AppRoutingModule { }