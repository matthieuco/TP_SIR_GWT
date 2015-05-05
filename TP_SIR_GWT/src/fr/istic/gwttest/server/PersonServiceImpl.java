package fr.istic.gwttest.server;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.istic.gwttest.client.PersonService;
import fr.istic.gwttest.shared.Person;

public class PersonServiceImpl extends RemoteServiceServlet implements PersonService {
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("Abh_Col_SIR_TPgwt");
	EntityManager manager = factory.createEntityManager();
	@Override
	public List<Person> getPersonnes() {
		// TODO Auto-generated method stub
		
		List<Person> listPersonnes = manager.createQuery("SELECT a FROM Person a",Person.class).getResultList();
		return listPersonnes;
	}
	@Override
	public void insererPersonne(String nom, String prenom, Date datenaissance,
			String adressemail, String sexe, String logfb) {
		
		Person user = new Person(nom, prenom , adressemail, sexe,  datenaissance, logfb);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(user);
		tx.commit();
		// TODO Auto-generated method stub
		
	}
}
