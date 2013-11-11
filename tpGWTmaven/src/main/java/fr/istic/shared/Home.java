package fr.istic.shared;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
public class Home {
	
	private Long id;
	private int taille;
	private int nb_piece;
	private Person person;
	private List<Heater> heaters = new ArrayList<Heater>();
	private List<ElectronicDevice> electronic_devices = new ArrayList<ElectronicDevice>();
	
	public Home() {
	
	}
	
	
	public Home(int taille, int nb_piece) {
		this.id = id;
		this.taille = taille;
		this.nb_piece = nb_piece;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Id
	@GeneratedValue
	public Long getId(){
		return id;
		
	}


	public int getTaille() {
		return taille;
	}


	public void setTaille(int taille) {
		this.taille = taille;
	}


	public int getNb_piece() {
		return nb_piece;
	}


	public void setNb_piece(int nb_piece) {
		this.nb_piece = nb_piece;
	}

	@ManyToOne
	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}

	@OneToMany(mappedBy= "home" , cascade= CascadeType.PERSIST)
	public List<Heater> getHeaters() {
		return heaters;
	}


	public void setHeaters(List<Heater> heaters) {
		this.heaters = heaters;
	}

	@OneToMany(mappedBy= "home" , cascade= CascadeType.PERSIST)
	public List<ElectronicDevice> getElectronic_devices() {
		return electronic_devices;
	}


	public void setElectronic_devices(List<ElectronicDevice> electronic_devices) {
		this.electronic_devices = electronic_devices;
	}
	
	
	
}
