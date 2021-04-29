package fr.doranco.KlikBook.control;
import java.util.List;

import fr.doranco.KlikBook.entity.Adresse;
import fr.doranco.KlikBook.model.AdresseDao;

public class AdresseMetier implements IAdresseMetier {

	private final AdresseDao adresseDao = new AdresseDao();

	@Override
	public void addAdresse(Adresse adresse) throws Exception {
		if (adresse == null) {
			throw new NullPointerException("L'adresse à ajouter ne doit pas être NULL !");
		}
		if (adresse.getNumero() <= 0 || adresse.getRue() == null || adresse.getRue().isEmpty()
				|| adresse.getVille() == null || adresse.getVille().isEmpty() || adresse.getCodePostal() == null
				|| adresse.getCodePostal().isEmpty()) {

			throw new IllegalArgumentException("Tous les paramètres de l'adresse à ajouter sont obligatoires");
		}
		adresseDao.add(adresse);
	}

	@Override
	public List<Adresse> getAdressesById(Integer userId) throws Exception {

		if (getUserById(userId) == null) {
			throw new NullPointerException("L'utilisateur � supprimer n'existe pas !");
		}
		if (userId <= 0)
			throw new IllegalArgumentException("L'id de l'utilisateur � r�cup�rer ne doit pas �tre <= 0");

		return adresseDao.getAdresses(userId);
	}

	private Object getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAdresse(Adresse adresse) throws Exception {
		if (adresse == null) {
			throw new NullPointerException("L'utilisateur � mettre� jours n'existe pas !"); }   
		adresseDao.update(adresse);
	}

	@Override
	public void removeAdresse(Adresse adresse) throws Exception {
		if (adresse == null) {
			throw new NullPointerException("L'utilisateur � mettre� jours n'existe pas !"); }  
		adresseDao.remove(adresse);
	}

}
