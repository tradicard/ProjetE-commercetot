import { Commande } from "./commande";
import { Role } from "./role";

export class Utilisateur {
    id!:number;
	nom!:string;
	prenom!:string;
	dateNaissance!:string;
	username!:string;
	password!:string;
	mail!:string;
	role!:Role;
	commandes!:Commande[];
}
