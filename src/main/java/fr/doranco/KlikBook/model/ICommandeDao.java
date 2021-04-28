package fr.doranco.KlikBook.model;

import java.util.List;
import fr.doranco.KlikBook.entity.Commande;

public interface ICommandeDao extends IEntityDao<Commande>{
	
	List<Commande> getCommandes()throws Exception; 
	List<Commande> getCommandesByUtilisateurId(Integer utilisateurId)throws Exception;
	List<Commande> getCommandesByVille(String ville)throws Exception;

}