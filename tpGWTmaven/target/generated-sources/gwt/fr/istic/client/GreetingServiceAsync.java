package fr.istic.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface GreetingServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void greetServer( java.lang.String name, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void createPerson( java.lang.String name, java.lang.String prenom, java.lang.String mail, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void createHome( java.lang.String nom, java.lang.String prenom, int taille, int nbre_piece, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void getAllPerson( AsyncCallback<java.util.List<fr.istic.shared.Person>> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static GreetingServiceAsync instance;

        public static final GreetingServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (GreetingServiceAsync) GWT.create( GreetingService.class );
                ServiceDefTarget target = (ServiceDefTarget) instance;
                target.setServiceEntryPoint( GWT.getModuleBaseURL() + "greet" );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
