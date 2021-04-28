package fr.doranco.KlikBook.model;

import java.util.List;

import fr.doranco.KlikBook.entity.Commentaire;

public interface ICommentaireDao {
	
	List<Commentaire> commentarieByNote (Integer note) throws Exception;
	

}
