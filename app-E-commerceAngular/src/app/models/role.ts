import { Utilisateur } from "./utilisateur";

export class Role {
    idRole!:number;
	librole!:string;
	description!:string;
	utilisateurs!:Utilisateur;
}
