package fr.istic.gwttest.shared;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Equipement")
public class Equipement extends PeripheriquesIntelligents {

	private int superficiechaufage;
	
	public Equipement(){
		super();
	}

	public int getSuperficiechauffage() {
		return superficiechaufage;
	}


	public void setSuperficiechauffage(int superficiechaufage) {
		this.superficiechaufage = superficiechaufage;
	}
	
}


