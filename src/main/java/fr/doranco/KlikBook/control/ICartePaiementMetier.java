package fr.doranco.KlikBook.control;

import fr.doranco.KlikBook.Dto.CartePaiementDto;

import fr.doranco.KlikBook.entity.User;

public interface ICartePaiementMetier {

	
	void addCartePaiement(CartePaiementDto cartePaiementDto) throws Exception ;

	void removeCartePaiement(CartePaiementDto cartePaiementDto) throws Exception;

	void updateCartePaiement(CartePaiementDto CartePaiementDto) throws Exception;
	
	User getUserByCartePaiement (Integer cartePaiementId) throws Exception;
	
	
	
}