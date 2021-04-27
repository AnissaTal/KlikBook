package fr.doranco.KlikBook.model;

import java.util.List;
import java.util.Map;

import fr.doranco.KlikBook.entity.Commande;
import fr.doranco.KlikBook.entity.User;


public interface ICommandeDao {

	Commande getCommande(Integer id)throws Exception;
	void addCommande(Commande commande)throws Exception;
	void updateCommande(Commande commande)throws Exception;
	void cancelCommande(Integer id)throws Exception;
	List<Commande> getCommandes()throws Exception; 
	List<Commande> getCommandesByUtilisateurId(Integer utilisateurId)throws Exception;
	List<Commande> getCommandesByVille(String ville)throws Exception;

}