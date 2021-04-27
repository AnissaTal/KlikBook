package fr.doranco.KlikBook.model;

import java.util.List;
import java.util.Map;

import fr.doranco.KlikBook.entity.Commande;
import fr.doranco.KlikBook.entity.LigneDeCommande;
import fr.doranco.KlikBook.entity.User;


public interface ILigneDeCommandeDao {

	LigneDeCommande getLigneDeCommande(Integer id);
	void addLigneDeCommande(LigneDeCommande ligneDeCommande);
	void cancelLigneDeCommande(LigneDeCommande ligneDeCommande);
	List<LigneDeCommande> getLignesDeCommande(Integer commandId);


}