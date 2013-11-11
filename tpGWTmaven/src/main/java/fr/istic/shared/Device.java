package fr.istic.shared;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Device {
	
	protected Long id;
	public void setId(Long id) {
		this.id = id;
	}
	protected String marque;
	protected String type;
	protected int conso;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getConso() {
		return conso;
	}
	public void setConso(int conso) {
		this.conso = conso;
	}
	
	
}
