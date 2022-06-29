package com.intiFormation.Service;


import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import com.intiFormation.Entity.Commande;
import com.intiFormation.dao.ICommandeDao;

@Service
public class CsvExportService implements ICsvExportService{


    private  ICommandeDao icodao;

   

    public CsvExportService(ICommandeDao icodao) {
		this.icodao = icodao;
	}


    //Writer pour écrire des informations de type csv dans le doc
	public void writeEmployeesToCsv(Writer writer) {
		
        List<Commande> commande = icodao.findAll();
        //CSVPrinter export les informations
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
        	//for each commande
            for (Commande commandes : commande) {
                csvPrinter.printRecord(commandes.getIdCommande(), commandes.getUtilisateur().getNom(),
                		commandes.getUtilisateur().getPrenom(), commandes.getDateCommande(), commandes.getLigneCommandes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
