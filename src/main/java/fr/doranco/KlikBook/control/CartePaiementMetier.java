package fr.doranco.KlikBook.control;

import fr.doranco.KlikBook.Dto.CartePaiementDto;
import fr.doranco.KlikBook.entity.CartePaiement;
import fr.doranco.KlikBook.entity.User;
import fr.doranco.KlikBook.model.CartePaiementDao;
import fr.doranco.KlikBook.model.ICartePaiementDao;
import fr.doranco.KlikBook.utils.Dates;

public class CartePaiementMetier implements ICartePaiementMetier {

	private final ICartePaiementDao cartePaiementDao = new CartePaiementDao();
	
	@Override
	public void addCartePaiement(CartePaiementDto cartePaiementDto) throws Exception {
		if (cartePaiementDto == null) {
			throw new NullPointerException("la carte de paiement à ajouter est null à ajouter est NULL !");
		}
		if (cartePaiementDto.getNomProprietaire() == null || cartePaiementDto.getNomProprietaire().trim().isEmpty()
				|| cartePaiementDto.getPrenomProprietaire() == null|| cartePaiementDto.getPrenomProprietaire().trim().isEmpty() 
				|| cartePaiementDto.getNumero() == null
				|| cartePaiementDto.getCryptogramme() == null 
				|| cartePaiementDto.getDateFinValidite() == null 
				
		) {
			throw new IllegalArgumentException("tous les champs sont obligatoires");
		}

		CartePaiement cartePaiement = new CartePaiement();
		cartePaiement.setNomProprietaire(cartePaiementDto.getNomProprietaire());
		cartePaiement.setPrenomProprietaire(cartePaiementDto.getPrenomProprietaire());
		cartePaiement.setNumero((cartePaiementDto.getNumero().getBytes()));
		cartePaiement.setCryptogramme(cartePaiementDto.getCryptogramme().getBytes());
		cartePaiement.setDateFinValidite(Dates.convertStringToDateUtil(cartePaiementDto.getDateFinValidite()));

		
		cartePaiementDao.add(cartePaiement);

	}

	@Override
	public void removeCartePaiement(CartePaiementDto cartePaiementDto) throws Exception {
	

	}

	@Override
	public void updateCartePaiement(CartePaiementDto cartePaiementDto) throws Exception {
		

	}

	@Override
	public User getUserByCartePaiement(Integer cartePaiementId) throws Exception {
		
		return null;
	}

}