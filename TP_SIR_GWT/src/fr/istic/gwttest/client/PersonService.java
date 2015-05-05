package fr.istic.gwttest.client;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;

import fr.istic.gwttest.shared.Person;

public interface PersonService  extends RemoteService {
	List<Person> getPersonnes();
	void insererPersonne(String nom, String prenom, Date datenaissance, String adressemail, String sexe, String logfb);
}
