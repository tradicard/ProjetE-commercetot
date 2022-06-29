package com.intiFormation.Controller;

import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.supercsv.io.CsvBeanWriter;
//import org.supercsv.io.ICsvBeanWriter;
//import org.supercsv.prefs.CsvPreference;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.Entity.Commande;
import com.intiFormation.Service.ICommandeService;
import com.intiFormation.Service.ICsvExportService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CVSController {
	@Autowired
	private ICommandeService cos;
	@Autowired
	private ICsvExportService icsv;
	
	
	/*
	//marche pas
	 @GetMapping("/gestionadmin/export")
	    public void exportToCSV(HttpServletResponse response) throws IOException {
	        response.setContentType("text/csv");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Commande> commandes = cos.getAllService();
	        
	        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
	        String[] csvHeader = {"ID", "date de la commande", "Utilisateur", "Produits commandés"};
	        String[] nameMapping = {"idCommande", "dateCommande", "utilisateur", "ligneCommandes"};
	         
	        csvWriter.writeHeader(csvHeader);
	        
			  
					for (Commande commande : commandes) { csvWriter.write(commande, nameMapping);
			  }
			 
	        csvWriter.close();
	 }
	 */
	 
	 
	 @GetMapping("/exportCSV")
	 public void getAllEmployeesInCsv(HttpServletResponse servletResponse) throws IOException {
	        servletResponse.setContentType("text/csv");
	        ////En mettant Content-Disposition à attachment, le doc est téléchargé.
	        servletResponse.addHeader("Content-Disposition","attachment; filename=\"commandes.csv\"");
	        
	        icsv.writeEmployeesToCsv(servletResponse.getWriter());
	 }

}
