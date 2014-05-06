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
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Resource;

public class TestSparqlQuery {

	public static void main(String[] args) throws RemoteException{
		SparqlQueryServiceStub stub = null;
		try {
			stub = new SparqlQueryServiceStub();
			
			SparqlQueryData sparqlQueryData0 = new SparqlQueryData();
			//stub.sparqlQueryData(sparlQueryData0);
			String sparqlQueryString = stub.sparqlQueryData(sparqlQueryData0).get_return();
			System.out.println("sparqlQueryString = " + sparqlQueryString);
			
			Query query = QueryFactory.create(sparqlQueryString);
		    ARQ.getContext().setTrue(ARQ.useSAX);
		    //Executing SPARQL Query and pointing to the DBpedia SPARQL Endpoint 
		    //QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dati.camera.it/sparql", query); //http://dati.camera.it/sparql is the sparql endpoint
		    QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query); //http://dbpedia.org/sparql is the sparql endpoint
		    //Retrieving the SPARQL Query results
		    ResultSet results = qexec.execSelect();
		    //ResultSetFormatter.out(System.out, results, query); //system.out should list the sparql query result
		    ResultSetFormatter.outputAsJSON(results);
		    //ResultSetFormatter.outputAsRDF("", results);		    

		} catch (AxisFault e) {			
			e.printStackTrace();
		}
	}
}
