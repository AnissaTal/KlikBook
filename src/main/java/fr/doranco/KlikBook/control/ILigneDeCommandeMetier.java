package fr.doranco.KlikBook.control;

import java.util.List;
import fr.doranco.KlikBook.entity.LigneDeCommande;



public interface ILigneDeCommandeMetier {
	
	List<LigneDeCommande> getLignesDeCommande(Integer commandId);


}