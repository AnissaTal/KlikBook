package fr.doranco.KlikBook.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.KlikBook.Dto.LivreDto;
import fr.doranco.KlikBook.control.ILivreMetier;
import fr.doranco.KlikBook.control.LivreMetier;
import fr.doranco.KlikBook.entity.Livre;
import fr.doranco.KlikBook.entity.User;

@ManagedBean(name = "livreBeans")
public class LivreBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final LivreDto livreDto = new LivreDto();
	private final ILivreMetier livreMetier =new LivreMetier();
	
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
		
		livreDto.setTitre(titre);
		livreDto.setAuteur(auteur);
		livreDto.setAnnee(annee);
		livreDto.setPrix(prix);
		
		try {
			livreMetier.addLivre(livreDto);
			messageSuccess = "Livre ajouté avec succès";
		}catch (Exception e) {
			System.out.println(e);
			messageError = "Erreur lors de l'ajout livre !\n" + e.getMessage();
		}
		
		return "";
	
	
	}

	public String getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(String idLivre) {
		this.idLivre = idLivre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getRemise() {
		return remise;
	}

	public void setRemise(String remise) {
		this.remise = remise;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public  void setMessageSuccess(String messageSuccess) {
		LivreBean.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public  void setMessageError(String messageError) {
		LivreBean.messageError = messageError;
	}

	public LivreDto getLivreDto() {
		return livreDto;
	}

	public ILivreMetier getLivreMetier() {
		return livreMetier;
	}
		
	
}