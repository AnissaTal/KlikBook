package fr.doranco.KlikBook.model;

import java.util.List;

import fr.doranco.KlikBook.entity.Commentaire;

public interface ICommentaireDao extends IEntityDao<Commentaire> {
	
	List<Commentaire> commentarieByNote (Integer note) throws Exception;
	

}
