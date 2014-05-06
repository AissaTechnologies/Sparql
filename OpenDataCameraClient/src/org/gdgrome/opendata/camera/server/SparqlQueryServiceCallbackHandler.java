
/**
 * SparqlQueryServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package org.gdgrome.opendata.camera.server;

    /**
     *  SparqlQueryServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class SparqlQueryServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public SparqlQueryServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public SparqlQueryServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for sparqlQueryData method
            * override this method for handling normal response from sparqlQueryData operation
            */
           public void receiveResultsparqlQueryData(
                    org.gdgrome.opendata.camera.server.SparqlQueryServiceStub.SparqlQueryDataResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sparqlQueryData operation
           */
            public void receiveErrorsparqlQueryData(java.lang.Exception e) {
            }
                


    }
    