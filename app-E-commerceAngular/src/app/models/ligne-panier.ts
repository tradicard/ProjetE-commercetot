import { Panier } from "./panier";
import { Produit } from "./produit";

export class LignePanier {
    idLignePanier!:number;
	produit!:Produit;
	quantite!:number;
	panier!:Panier;
}
