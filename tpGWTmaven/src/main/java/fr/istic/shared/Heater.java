package fr.istic.shared;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class Heater extends Device{

	
	private Home home;
	
	
	public Heater(){
		super();
		}
	
	public Heater(String marque, String type, int conso, Home home) {

		this.marque = marque;
		this.type = type;
		this.conso = conso;
		this.home = home;
	}

	
	@ManyToOne
	public Home getHome() {
		return home;
	}
	
	public void setHome(Home home) {
		this.home = home;
	}
	
	
	
	
}
