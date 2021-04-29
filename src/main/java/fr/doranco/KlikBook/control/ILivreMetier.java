package fr.doranco.KlikBook.control;

import java.util.List;

import fr.doranco.KlikBook.entity.Livre;

public interface ILivreMetier {

	void add(Livre livre) throws Exception;

	List<Livre> getLivres() throws Exception;

	void remove(Livre livre) throws Exception;

	void update(Livre livre) throws Exception;

	List<Livre> getLivresByAuthor(String auteur) throws Exception;

	List<Livre> getLivresByAnnee(Integer annee) throws Exception;

	void gestionStock(String titre) throws Exception;

	List<Livre> getLivresByCategories(String nomCategorie) throws Exception;

}
