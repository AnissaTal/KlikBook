package fr.doranco.KlikBook.model;

import fr.doranco.KlikBook.entity.User;

public interface ICartePaiementDao {
	
	User getUserByCartePaiement (Integer utilisateurId) throws Exception;
	

}
