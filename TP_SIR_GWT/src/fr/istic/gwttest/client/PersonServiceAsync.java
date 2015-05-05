package fr.istic.gwttest.client;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.istic.gwttest.shared.Person;

public interface PersonServiceAsync {
	void getPersonnes(AsyncCallback<List<Person>> callback);

	void insererPersonne(String nom, String prenom, Date datenaissance,
			String adressemail, String sexe, String logfb,
			AsyncCallback<Void> callback);

}
