package fr.doranco.KlikBook.control;

import java.util.List;

import fr.doranco.KlikBook.entity.LigneDeCommande;
import fr.doranco.KlikBook.model.ILigneDeCommandeDao;
import fr.doranco.KlikBook.model.LigneDeCommandeDao;

public class LigneDeCommandeMetier implements ILigneDeCommandeMetier {
    ILigneDeCommandeDao ligneDeCommandeDao = new LigneDeCommandeDao();
	
	@Override
	public List<LigneDeCommande> getLignesDeCommande(Integer commandeId) {
		if (commandeId <= 0)
			throw new IllegalArgumentException("L'id de l'utilisateur � r�cup�rer ne doit pas �tre <= 0");
	
		return ligneDeCommandeDao.getLignesDeCommande(commandeId);
	}

}
