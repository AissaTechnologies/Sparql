package org.gdgrome.opendata.camera.server;

import java.io.IOException;

public class SparqlQueryService {
	public String sparqlQueryData() throws IOException{
		
		String sparqlQuery = "SELECT distinct * WHERE { " +
		"?votazione a ocd:votazione; " +
		"dc:date ?data; " +
		"dc:title ?denominazione; " +
		"dc:description ?descrizione; " +
		"ocd:votanti ?votanti; " + 
		"ocd:richiestaFiducia 1; " + 
		"ocd:approvato ?approvato; " + 
		"ocd:favorevoli ?favorevoli; " + 
		"ocd:contrari ?contrari; " +
		"ocd:astenuti ?astenuti; " + 
		"ocd:rif_leg ?leg} " + 
	" ORDER BY DESC(?data)";
		
//		//init reader
//		BufferedReader reader = null;
//		String line = null;
//		//defining SPARQL Query	
//		String sparqlQuery = "";
//		try {
//			File file = new File("C://anagrafica.txt");
//			reader = new BufferedReader(new FileReader(file));			
//			//read line
//			while((line = reader.readLine()) != null){				
//				sparqlQuery = line;				
//				System.out.println(sparqlQuery);				
//			}
//		} catch (FileNotFoundException e) {			
//			e.printStackTrace();
//		}
//		finally {
//		    try {
//		        reader.close();
//		    } catch (IOException e) {
//		        e.printStackTrace();
//		    }
//		}
		
		return sparqlQuery;
	    
	}
	
}
