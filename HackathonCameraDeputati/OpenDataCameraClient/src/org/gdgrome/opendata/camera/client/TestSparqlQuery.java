package org.gdgrome.opendata.camera.client;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.gdgrome.opendata.camera.server.SparqlQueryServiceStub;
import org.gdgrome.opendata.camera.server.SparqlQueryServiceStub.SparqlQueryData;

import com.hp.hpl.jena.query.ARQ;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;

public class TestSparqlQuery {

	public static void main(String[] args) throws RemoteException{
		SparqlQueryServiceStub stub = null;
		try {
			stub = new SparqlQueryServiceStub();			
			SparqlQueryData sparqlQueryData0 = new SparqlQueryData();
			//String tag = "PREFIX ocd: <http://dati.camera.it/ocd/> PREFIX dc: <http://purl.org/dc/elements/1.1/> ";
			String tagAnag = "prefix ocd: <http://dati.camera.it/ocd/> " + 
							"prefix foaf: <http://xmlns.com/foaf/0.1/> " + 
							"prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> " + 
							"prefix dc: <http://purl.org/dc/elements/1.1/> ";
							//"##prefix dcterms: <http://purl.org/dc/terms/> ";
			//String sparqlQueryString = tag + stub.sparqlQueryData(sparqlQueryData0).get_return();
			String sparqlQueryString = tagAnag + stub.sparqlQueryData(sparqlQueryData0).get_return();
			System.out.println("sparqlQueryString = " + sparqlQueryString);
			
			Query query = QueryFactory.create(sparqlQueryString);
		    ARQ.getContext().setTrue(ARQ.useSAX);
		    //Executing SPARQL Query and pointing to the Camera SPARQL Endpoint 
		    QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dati.camera.it/sparql", query); 		   
		    //Retrieving the SPARQL Query results
		    ResultSet results = qexec.execSelect();
		    //ResultSetFormatter.out(System.out, results, query); 
		    ResultSetFormatter.outputAsJSON(results);
		    //ResultSetFormatter.outputAsRDF("", results);		    

		} catch (AxisFault e) {			
			e.printStackTrace();
		}
	}
}
