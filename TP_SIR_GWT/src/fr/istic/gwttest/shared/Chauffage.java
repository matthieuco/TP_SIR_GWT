package fr.istic.gwttest.shared;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Chauffage")
public class Chauffage extends PeripheriquesIntelligents{
	private int capacite;
	
	public Chauffage(){
		super();
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

}
