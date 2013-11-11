package fr.istic.client;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import fr.istic.shared.Person;

public interface GreetingServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void greetServer( java.lang.String p0, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see fr.istic.client.GreetingService
     */
    void createPerson( java.lang.String p0, java.lang.String p1, java.lang.String p2, AsyncCallback<Void> callback );


    void createHome(String nom, String prenom, int taille, int nbre_piece,
			AsyncCallback<Void> callback);


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
                target.setServiceEntryPoint( GWT.getModuleBaseURL() + "GreetingService" );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }


	void getAllPerson(AsyncCallback<List<Person>> callback);
}
