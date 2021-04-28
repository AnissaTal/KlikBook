package fr.doranco.KlikBook.model;

import java.util.List;
import fr.doranco.KlikBook.entity.LigneDeCommande;



public interface ILigneDeCommandeDao extends IEntityDao<LigneDeCommande> {
	
	List<LigneDeCommande> getLignesDeCommande(Integer commandId);


}