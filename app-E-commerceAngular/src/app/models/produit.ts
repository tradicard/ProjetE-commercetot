import { Categorie } from "./categorie";
import { LigneCommande } from "./ligne-commande";
import { LignePanier } from "./ligne-panier";

export class Produit {
	idProduit!:number;
	nomProduit!:string;
	img!:string;
	quantite!:number;
	lignescommande!:LigneCommande[];
	lignespanier!:LignePanier[];
	categorie!:Categorie;
}
