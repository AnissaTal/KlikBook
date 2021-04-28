package fr.doranco.KlikBook.model;

import fr.doranco.KlikBook.entity.CartePaiement;

import fr.doranco.KlikBook.entity.User;


public interface ICartePaiementDao  extends IEntityDao<CartePaiement> {
	
	User getUserByCartePaiement (Integer cartePaiementId) throws Exception;
	

}
