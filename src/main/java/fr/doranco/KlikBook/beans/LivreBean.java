package fr.doranco.KlikBook.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.KlikBook.control.ILivreMetier;
import fr.doranco.KlikBook.control.LivreMetier;

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
	
}
