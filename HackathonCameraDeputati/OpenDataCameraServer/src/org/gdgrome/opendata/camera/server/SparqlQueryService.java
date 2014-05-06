package org.gdgrome.opendata.camera.server;

import java.io.IOException;

public class SparqlQueryService {
	public String sparqlQueryData() throws IOException{
		//sparql query votes
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
		
		//spaqrl query members
		String sparqlQuery = "SELECT DISTINCT ?persona ?cognome ?nome " + 
			"?dataNascita  ?nato ?luogoNascita ?genere " + 
			"?collegio ?nomeGruppo ?sigla ?commissione ?aggiornamento " + 
			"WHERE { " + 
			"?persona ocd:rif_mandatoCamera ?mandato; a foaf:Person. " + 
			//"## deputato " + 
			"?d a ocd:deputato; ocd:aderisce ?aderisce; " + 
			"ocd:rif_leg <http://dati.camera.it/ocd/legislatura.rdf/repubblica_17>; " + 
			"ocd:rif_mandatoCamera ?mandato. " + 
			//"##anagrafica " + 
			"?d foaf:surname ?cognome; foaf:gender ?genere;foaf:firstName ?nome. " + 
			"OPTIONAL{ " + 
			"?persona <http://purl.org/vocab/bio/0.1/Birth> ?nascita. " + 
			"?nascita <http://purl.org/vocab/bio/0.1/date> ?dataNascita; " + 
			"rdfs:label ?nato; ocd:rif_luogo ?luogoNascitaUri. " + 
			"?luogoNascitaUri dc:title ?luogoNascita. " + 
			"} " + 
			//"##aggiornamento del sistema " + 
			"OPTIONAL{?d <http://lod.xdams.org/ontologies/ods/modified> ?aggiornamento.} " + 
			//"## mandato " + 
			"?mandato ocd:rif_elezione ?elezione. " + 
			"MINUS{?mandato ocd:endDate ?fineMandato.} " + 
			//"## elezione " + 
			"?elezione dc:coverage ?collegio. " + 
			//"## adesione a gruppo " + 
			"?aderisce ocd:rif_gruppoParlamentare ?gruppo. " + 
			"?gruppo <http://purl.org/dc/terms/alternative> ?sigla; " + 
			"dc:title ?nomeGruppo. " + 
			"MINUS{?aderisce ocd:endDate ?fineAdesione} " + 
			//"## organo " + 
			"?d ocd:membro ?membro.?membro ocd:rif_organo ?organo. " + 
			"?organo dc:title ?commissione . " + 
			"MINUS{?membro ocd:endDate ?fineMembership} " + 
			"} ";
		
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
