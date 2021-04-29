package fr.doranco.KlikBook.control;

import java.util.List;
import fr.doranco.KlikBook.entity.Commande;

public interface ICommandeMetier{
	
	List<Commande> getCommandes()throws Exception; 
	List<Commande> getCommandesByUserId(Integer userId)throws Exception;

}