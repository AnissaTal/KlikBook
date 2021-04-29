package fr.doranco.KlikBook.control;

import java.util.ArrayList;
import java.util.List;

import fr.doranco.KlikBook.entity.Commande;
import fr.doranco.KlikBook.model.CommandeDao;
import fr.doranco.KlikBook.model.ICommandeDao;

public class CommandeMetier implements ICommandeMetier {
 
	private final ICommandeDao commandeDao= new CommandeDao();
	
	@Override
	public List<Commande> getCommandes() throws Exception {
		List<Commande> commandes = commandeDao.getCommandes();
		if (commandes != null)
		return commandes;
		return new ArrayList<Commande>();
	}

	@Override
	public List<Commande> getCommandesByUserId(Integer userId) throws Exception {
		if (userId <= 0) 
			throw new IllegalArgumentException("L'id de l'utilisateur à récupérer ne doit pas être <= 0");
		return commandeDao.getCommandesByUtilisateurId(userId) ;
	}

}
