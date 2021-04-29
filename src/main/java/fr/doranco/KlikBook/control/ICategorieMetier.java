package fr.doranco.KlikBook.control;

import java.util.List;

import fr.doranco.KlikBook.entity.Adresse;
import fr.doranco.KlikBook.entity.Categorie;

public interface ICategorieMetier {

	List<Categorie> getCategories() throws Exception;

	void addCategorie(Categorie categorie) throws Exception;

	void updateCategorie(Categorie categorie) throws Exception;

	void removeCategorie(Categorie categorie) throws Exception;

}
