package com.intiFormation.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.intiFormation.Entity.Commande;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdfReport {
	
	//sert en cas d'erreur ou d'exception
	private static final Logger logger = LoggerFactory.getLogger(GeneratePdfReport.class);

	
    public static ByteArrayInputStream commandesReport(List<Commande> commandes) {

        Document document = new Document();
        //The data will be written to ByteArrayOutputStream.
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
        	//creation d'une table de 4 collonne
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(80);
            table.setWidths(new int[]{1, 3, 2, 6});
            
            //Policede l'ecriture
            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            
            //Legende
            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Id", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Utilisateur", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Date", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Commande", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            //For each commande
            for (Commande commande : commandes) {
            	
                PdfPCell cell;
                cell = new PdfPCell(new Phrase(String.valueOf(commande.getIdCommande())));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                
                String np= commande.getUtilisateur().getNom()+" "+commande.getUtilisateur().getPrenom();
                cell = new PdfPCell(new Phrase(np));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(commande.getDateCommande()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(commande.getLigneCommandes().toString())));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);
            }
            //creation et exportation du doc
            //With PdfWriter, the document is written to the ByteArrayOutputStream.
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);
            document.close();

        } catch (DocumentException ex) {
        	//message d'erreur
            logger.error("Error occurred: {0}", ex);
        }
        //In the end, the data is returned as ByteArrayInputStream.
        return new ByteArrayInputStream(out.toByteArray());
    }

}
