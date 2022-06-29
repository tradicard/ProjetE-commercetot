import { Commande } from "./commande";
import { Produit } from "./produit";

export class LigneCommande {
    idLigneCommande!:number;
	commande!:Commande;
	produit!:Produit;
	quantite!:number;
}
