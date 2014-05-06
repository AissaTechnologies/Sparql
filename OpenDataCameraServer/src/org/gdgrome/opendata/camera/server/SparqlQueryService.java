package org.gdgrome.opendata.camera.server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SparqlQueryService {
	public String sparqlQueryData(){
	
		//init reader
		BufferedReader reader = null;
		try {
			//reader = new BufferedReader(new FileReader("C://sparqlQueryDbpedia.txt"));
			reader = new BufferedReader(new FileReader("C://sparqlQueryCamera.txt"));
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
		String line = null;
		//defining SPARQL Query
		String sparqlQuery = " SELECT ?resource ?value " + 
							" WHERE { " + 
							" ?resource a <http://dbpedia.org/class/yago/CitiesAndTownsInAbruzzo> . " + 
							" ?resource <http://dbpedia.org/property/populationTotal> ?value . " + 
							" FILTER (?value > 50000) " + 
							" } " + 
							" ORDER BY ?resource ?value";
//		String sparqlQuery = "SELECT distinct * WHERE { " +
//		"?votazione a ocd:votazione; " +
//		"dc:date ?data; " +
//		"dc:title ?denominazione; " +
//		"dc:description ?descrizione; " +
//		"ocd:votanti ?votanti; " + 
//		"ocd:richiestaFiducia 1; " + 
//		"ocd:approvato ?approvato; " + 
//		"ocd:favorevoli ?favorevoli; " + 
//		"ocd:contrari ?contrari; " +
//		"ocd:astenuti ?astenuti; " + 
//		"ocd:rif_leg ?leg} " + 
//	" ORDER BY DESC(?data)";
		
		//String sparqlQuery = "";
		//read line
		while(line != null){
			try {
				line = reader.readLine();				
				System.out.println("line = " + line);
				sparqlQuery += sparqlQuery + line;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(line == null){
			try {				
				reader.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
		return sparqlQuery;
	    
	}
	
}
