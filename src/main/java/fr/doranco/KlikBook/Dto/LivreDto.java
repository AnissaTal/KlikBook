package fr.doranco.KlikBook.Dto;


import fr.doranco.KlikBook.control.ILivreMetier;
import fr.doranco.KlikBook.control.LivreMetier;

public class LivreDto  {

	ILivreMetier livreMetier = new  LivreMetier();

	private String id;
	private String titre;
	private String auteur;
	private String annee;
	private String prix;
	private String remise;
	private String stock;

	
	public LivreDto() {
		
	}

	public LivreDto(String titre, String auteur, String annee, String prix, String remise, String stock) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.annee = annee;
		this.prix = prix;
		this.remise = remise;
		this.stock = stock;
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

	
	
}
