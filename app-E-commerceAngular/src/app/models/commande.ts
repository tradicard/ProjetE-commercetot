import { LigneCommande } from "./ligne-commande";
import { Utilisateur } from "./utilisateur";

export class Commande {
    idCommande!:number;
	dateCommande!:string;
	utilisateur!:Utilisateur;
	ligneCommandes!:LigneCommande[];
}
