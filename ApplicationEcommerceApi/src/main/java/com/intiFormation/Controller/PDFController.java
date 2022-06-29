package com.intiFormation.Controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.Entity.Commande;
import com.intiFormation.Service.ICommandeService;
import com.intiFormation.util.GeneratePdfReport;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PDFController {

	
	  @Autowired private ICommandeService cos;
	  
	  @GetMapping(value = "/pdfreport", produces =
	  MediaType.APPLICATION_PDF_VALUE)
	  public ResponseEntity<InputStreamResource> commandesReport() {
	  
	  List<Commande> commandes = cos.getAllService();
	  //appel de la methode
	  ByteArrayInputStream bis = GeneratePdfReport.commandesReport(commandes);
	  
	  //En mettant Content-Disposition à inline, le PDF file s'affiche directement sur le navigateur.
	  HttpHeaders headers = new HttpHeaders(); headers.add("Content-Disposition",
	  "attachment; filename=ListCommandes.pdf");
	  
	  //On crée une réponse avec ResponseEntity. Specification du headers, content type, et body.
	  return ResponseEntity .ok() .headers(headers)
	  .contentType(MediaType.APPLICATION_PDF) .body(new InputStreamResource(bis));
	  }
	 
}
