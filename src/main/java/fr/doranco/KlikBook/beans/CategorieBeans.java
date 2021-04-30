package fr.doranco.KlikBook.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


import fr.doranco.KlikBook.control.CategorieMetier;
import fr.doranco.KlikBook.control.ICategorieMetier;
import fr.doranco.KlikBook.entity.Categorie;

@ManagedBean(name = "categorieBeans")
public class CategorieBeans implements Serializable {

	private static final long serialVersionUID = 1L;
	private final ICategorieMetier categorieMetier = new CategorieMetier();
	
	@ManagedProperty(name = "idCategorie", value = "")
	private String idCategorie;
	
	
	@ManagedProperty(name = "remise", value = "")
	private Integer remise;
	
	
	@ManagedProperty(name = "nom", value = "")
	private String nom;
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private static String messageSuccess;

	@ManagedProperty(name = "messageError", value = "")
	private static String messageError;
	
	static {
		messageSuccess = "";
		messageError = "";
	}

	public CategorieBeans() {
		
	}
	
 public String addCategorie() {
	Categorie categorie = new Categorie();
	
	categorie.setRemise(remise);
	categorie.setNom(nom);
	try {
		categorieMetier.addCategorie(categorie);
		messageSuccess = "Categorie ajouté avec succès";
	}catch (Exception e) {
		System.out.println(e);
		messageError = "Erreur lors de l'ajout de la categorie!\n" + e.getMessage();
	}
	
	 return "";
 }

public String getIdCategorie() {
	return idCategorie;
}

public void setIdCategorie(String idCategorie) {
	this.idCategorie = idCategorie;
}

public Integer getRemise() {
	return remise;
}

public void setRemise(Integer remise) {
	this.remise = remise;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public  String getMessageSuccess() {
	return messageSuccess;
}

public  void setMessageSuccess(String messageSuccess) {
	CategorieBeans.messageSuccess = messageSuccess;
}

public  String getMessageError() {
	return messageError;
}

public void setMessageError(String messageError) {
	CategorieBeans.messageError = messageError;
}


	
 
	
}
