package fr.doranco.KlikBook.model;

import java.util.List;

import fr.doranco.KlikBook.entity.Livre;




public interface ILivreDao extends IEntityDao<Livre>{

	
	List<Livre> getLivres() throws Exception;
	
	List<Livre> getLivresByAuthor(String auteur) throws Exception;
	
	List<Livre> getLivresByAnnee(Integer annee) throws Exception;
	
	void gestionStock (String titre) throws Exception;

	List<Livre> getLivresByCategories(String nomCategorie) throws Exception;
	
}
