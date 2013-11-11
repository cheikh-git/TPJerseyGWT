package fr.istic.shared;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Person {

	private Long id;
	private String name;
	private String prenom;
	private String mail;
	private List<Home> homes = new ArrayList<Home>();
	private List<Person>amis = new ArrayList<Person>();
	
	public Person(){
	}
	
	public Person (String name, String prenom, String mail,Home home){
		this.name = name;
		this.prenom = prenom;
		this.mail = mail;	
		this.homes.add(home);
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
	public List<Home> getHome() {
		return homes;
	}
	
	public void addHome(Home m){
		Person p = m.getPerson();
		if(p!=null)
			p.homes.remove(m);
		this.homes.add(m);
		m.setPerson(this);
	}
	
	public void setHome(List<Home> home) {
		this.homes = home;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
}
	

