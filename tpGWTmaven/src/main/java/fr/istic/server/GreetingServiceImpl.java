package fr.istic.server;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.istic.client.GreetingService;
import fr.istic.shared.Home;
import fr.istic.shared.Person;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	EntityManager manager;
	
	public String greetServer(String input) throws IllegalArgumentException {
		return input.toLowerCase();

	}


	public GreetingServiceImpl() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		manager = factory.createEntityManager();

	}

	public void createPerson(String name, String prenom, String mail) {
		Person p = new Person();
		p.setName(name);
		p.setPrenom(prenom);
		p.setMail(mail);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(p);
		tx.commit();

	}


	public void createHome(String nom,String prenom,int taille, int nbre_piece) {
		Person p = new Person();
		p.setName(nom);
		p.setPrenom(prenom);
		Query q = manager.createQuery("SELECT p FROM Person p WHERE p.name= ?1 AND p.prenom= ?2")
		.setParameter(1, nom)
		.setParameter(2, prenom);
		if(q==null)
			Window.alert("Personne inexistante");
		else {
		Home h = new Home();
		h.setTaille(taille);
		h.setNb_piece(nbre_piece);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(h);
		p.addHome(h);
		tx.commit();
		}
	}

	public List<Person> getAllPerson() {
		Query q = manager.createQuery("SELECT p FROM Person p");
		List <Person> l = new ArrayList<Person>();
		l.addAll((List<Person>)q.getResultList()); 
		return l;
	} 

}
