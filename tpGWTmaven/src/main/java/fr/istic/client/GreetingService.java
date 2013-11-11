package fr.istic.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.istic.shared.PersonServiceImpl;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService, Serializable {
  String greetServer(String name) throws IllegalArgumentException;
  void createPerson(String name, String prenom, String mail);
  void createHome(String nom,String prenom,int taille,int nbre_piece);
  List<PersonServiceImpl> getAllPerson();
}
