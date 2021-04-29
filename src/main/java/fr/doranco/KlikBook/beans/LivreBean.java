package fr.doranco.KlikBook.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.KlikBook.control.ILivreMetier;
import fr.doranco.KlikBook.control.LivreMetier;
import fr.doranco.KlikBook.entity.Livre;

@ManagedBean(name = "livreBeans")
public class LivreBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private final ILivreMetier livreMetier = new LivreMetier();
	
	@ManagedProperty(name = "idLivre", value = "")
	private String idLivre;

	@ManagedProperty(name = "titre", value = "")
	private String titre;

	@ManagedProperty(name = "auteur", value = "")
	private String auteur;

	@ManagedProperty(name = "annee", value = "")
	private String annee;
	
	@ManagedProperty(name = "prix", value = "")
	private String prix;
	
	@ManagedProperty(name = "remise", value = "")
	private String remise;
	
	@ManagedProperty(name = "stock", value = "")
	private String stock;
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private static String messageSuccess;

	@ManagedProperty(name = "messageError", value = "")
	private static String messageError;
	
	static {
		messageSuccess = "";
		messageError = "";
	}

	public LivreBean() {
	
	}
	
	public String addLivre() {
		Livre livre= new Livre();
		
		livre.setTitre(titre);
		livre.setAuteur(auteur);
		//livre.setAnnee(annee);
		//livre.setPrix(prix);
		
		try {
			livreMetier.addLivre(livre);
			messageSuccess = "Livre ajouté avec succès";
		}catch (Expection e) {
			
		}
		
		return "";
	}
	
}
