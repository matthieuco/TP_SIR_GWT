package fr.istic.gwttest.client;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

import fr.istic.gwttest.shared.Person;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TP_SIR_GWT implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	/*private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
*/
	private final PersonServiceAsync personService = GWT
			.create(PersonService.class);
	/**
	 * This is the entry point method.
	 */
		final Label labelnom = new Label("Nom");
		final TextBox nom = new TextBox();
		final Label labelprenom = new Label("Prenom");
		final TextBox prenom = new TextBox();
		final Label labeldatenaissance = new Label("Date de naissance");
		final DatePicker datenaissance = new DatePicker();
		final Label labelmail = new Label("Mail");
		final TextBox mail = new TextBox();
		final Label labelsexe = new Label("Sexe");
		final ListBox sexe = new ListBox();
		final Label labelloginfb = new Label("Login Facebook");
		final TextBox loginfb = new TextBox();
	
		final Label errorLabel = new Label();	
		final Button sendButton = new Button("Envoyer");
		
	public void onModuleLoad() {
		

		// We can add style names to widgets
		//sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("labelnom").add(labelnom);
		RootPanel.get("nom").add(nom);
		RootPanel.get("labelprenom").add(labelprenom);
		RootPanel.get("prenom").add(prenom);
		RootPanel.get("labeldatenaissance").add(labeldatenaissance);
		RootPanel.get("datenaissance").add(datenaissance);
		RootPanel.get("labelmail").add(labelmail);
		RootPanel.get("mail").add(mail);
		RootPanel.get("labelsexe").add(labelsexe);
		sexe.addItem("M","1");
		sexe.addItem("F", "2");
		RootPanel.get("sexe").add(sexe);
		RootPanel.get("labelloginfb").add(labelloginfb);
		RootPanel.get("loginfb").add(loginfb);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendPersonne();
				//sendNameToServer();
			}

			private void sendPersonne() {
				String nomp = nom.getValue();
				String prenomp = prenom.getValue();
				Date datep = datenaissance.getValue();
				String mailp = mail.getValue();
				String sexep = sexe.getItemText(1);	
				String log = loginfb.getValue();
				
				AsyncCallback<Void> callback = null;
				personService.insererPersonne(nomp, prenomp, datep, mailp, sexep, log, callback);
				
				// TODO Auto-generated method stub
				
			}

			/**
			 * Fired when the user types in the nameField.
			 */

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				
			}
				
			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
	}
}
