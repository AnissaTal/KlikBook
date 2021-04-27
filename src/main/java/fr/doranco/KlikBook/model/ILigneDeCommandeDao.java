package fr.doranco.jsf.model;

import java.util.List;
import java.util.Map;

import fr.doranco.jsf.entity.Commande;
import fr.doranco.jsf.entity.LigneDeCommande;
import fr.doranco.jsf.entity.User;


public interface ILigneDeCommandeDao {

	LigneDeCommande getLigneDeCommande(Integer id);
	void addLigneDeCommande(LigneDeCommande ligneDeCommande);
	void cancelLigneDeCommande(LigneDeCommande ligneDeCommande);
	List<LigneDeCommande> getLignesDeCommande(Integer commandId);


}