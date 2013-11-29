package fr.istic.client;

import java.util.Iterator;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

//import fr.istic.shared.PersonServiceImpl;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class FirstGWT implements EntryPoint {
	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private final Messages messages = GWT.create(Messages.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		
		final AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setVisible(false);
		
		//attributs pour la creation de personne
		final Button sendButton = new Button(messages.sendButton());
		final TextBox nameField = new TextBox();
		final TextBox prenom = new TextBox(); //texbox pour le prenom
		final TextBox mail=new TextBox();
		//final https:github.com/barais/gwtjerseyjpaexample mail = new TextBox(); 
		
		nameField.setText(messages.nameField());
		
		//attributs pour la creation de maison
		final Button createHome = new Button("Creer Maison");
		final TextBox taille = new TextBox();
		final TextBox piece = new TextBox();
		final TextBox nomProprietaire = new TextBox();
		final TextBox prenomProprietaire = new TextBox();
		//final ListBox propriete = new ListBox();
		
		//test sur les TabPanel
		TabPanel tabPanel =new TabPanel();
		
		
		AbsolutePanel p_person=new AbsolutePanel();
		AbsolutePanel p_home=new AbsolutePanel();
		AbsolutePanel p_heater=new AbsolutePanel();
		AbsolutePanel p_electronic=new AbsolutePanel();

	//	final Button send = new Button("toto");

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get();
			
		
		//definition des attributs du panel_person 
		Label label_nom = new Label(messages.label_nom());
		p_person.add(label_nom);
		label_nom.setSize("131px", "27px");
		p_person.add(nameField);
		
		Label label_prenom = new Label(messages.label_prenom());
		p_person.add(label_prenom);
		label_prenom.setSize("131px", "27px");
		p_person.add(prenom);
		
		Label label_mail = new Label(messages.label_mail());
		p_person.add(label_mail);
		label_mail.setSize("131px", "27px");
		p_person.add(mail);
		
		p_person.add(sendButton);
		
		//definition des attributs pour le creation de maison
		Label label_nom_pro = new Label("Nom du Proprietaire");
		p_home.add(label_nom_pro);
		label_nom_pro.setSize("131px", "27px");
		p_home.add(nomProprietaire);
		
		Label label_prenom_pro = new Label("Prenom du Proprietaire");
		p_home.add(label_prenom_pro);
		label_nom_pro.setSize("131px", "27px");
		p_home.add(prenomProprietaire);
		
		Label label_taille = new Label("Taille de la maison");
		p_home.add(label_taille);
		p_home.add(taille);
		label_taille.setSize("131px", "27px");
		
		Label label_piece = new Label("nombre de pieces");
		p_home.add(label_piece);
		label_piece.setSize("131px", "27px");
		p_home.add(piece);
		
		p_home.add(createHome);
		
		//ajout du panel_person dans le panel TabPanel
		tabPanel.add(p_person,"AJOUT PERSON");
		tabPanel.add(p_home,"AJOUT DE MAISON");
		p_home.setSize("367px", "118px");
		tabPanel.add(p_home,"AJOUT DE MAISON");
		tabPanel.add(p_heater,"AJOUT DE HEATER");
		tabPanel.add(p_electronic,"ELECTRONIC DEVICE");
		
		

		sendButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {

				greetingService.createPerson(nameField.getText(), prenom.getText(), mail.getText(), new AsyncCallback<Void>() {

					public void onFailure(Throwable arg0) {
						Window.alert("failure" +arg0.getMessage());
						
					}

					public void onSuccess(Void arg0) {
						Window.alert("Personne Ajoutée avec Success");
						
					}
					
				});

			}
		});
		
		
		createHome.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent arg0) {
				greetingService.createHome(nameField.getText(),prenom.getText(),Integer.parseInt(taille.getText()),Integer.parseInt(piece.getText()), new AsyncCallback<Void>(){

					public void onFailure(Throwable arg0) {
						Window.alert("Failure" + arg0.getMessage());
						
					}

					public void onSuccess(Void arg0) {
						Window.alert("Maison Ajoutée avec Succes");
						
					}
					
				});
				
			}
		});
		
		
		
		tabPanel.selectTab(0);
	    tabPanel.setSize("500px", "250px");
	    rootPanel.add(tabPanel);
	}
}
