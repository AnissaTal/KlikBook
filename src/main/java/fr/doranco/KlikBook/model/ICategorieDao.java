package fr.doranco.KlikBook.model;

import java.util.List;

import fr.doranco.KlikBook.entity.Categorie;
import fr.doranco.KlikBook.entity.Livre;

public interface ICategorieDao {

	List<Categorie> getCategories () throws Exception;
	List<Livre> getLivresByCategories (String nom) throws Exception;
}
