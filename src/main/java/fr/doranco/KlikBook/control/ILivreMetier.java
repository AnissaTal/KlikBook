package fr.doranco.KlikBook.control;

import java.util.List;

import fr.doranco.KlikBook.Dto.LivreDto;
import fr.doranco.KlikBook.entity.Livre;

public interface ILivreMetier {

  void addLivre(LivreDto livreDto) throws Exception ;

	List<Livre> getLivres() throws Exception;

	void removeLivre(Livre livre) throws Exception;

	void updateLivre(Livre livre) throws Exception;

	List<Livre> getLivresByAuthor(String auteur) throws Exception;

	List<Livre> getLivresByAnnee(Integer annee) throws Exception;

	void gestionStock(String titre) throws Exception;

	List<Livre> getLivresByCategories(String nomCategorie) throws Exception;

}
