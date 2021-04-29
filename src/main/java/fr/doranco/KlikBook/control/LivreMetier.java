package fr.doranco.KlikBook.control;

import java.util.List;

import fr.doranco.KlikBook.entity.Livre;
import fr.doranco.KlikBook.model.ILivreDao;
import fr.doranco.KlikBook.model.LivreDao;

public class LivreMetier implements ILivreMetier {

	private final ILivreDao livreDao = new LivreDao(); 
	
	@Override
	public void add(Livre livre) throws Exception {
		if (livre == null) {
			throw new NullPointerException("le livre à ajouter est NULL !");
		}
		
		if (livre.getTitre() == null || livre.getTitre().trim().isEmpty() ||
				livre.getAuteur() == null|| livre.getAuteur().isEmpty() 
				|| livre.getAnnee() == null
				//|| livre.getPrix() == null 
				|| livre.getRemise()== null
				|| livre.getStock()== null

		) {
			throw new IllegalArgumentException("tous les champs sont obligatoires");
		}
		livreDao.add(livre);

	}

	
	@Override
	public List<Livre> getLivres() throws Exception {
		
		return null;
	}

	@Override
	public void remove(Livre livre) throws Exception {
		if (livre == null) {
			throw new NullPointerException("L'utilisateur à eliminer n'existe pas !"); }  
		livreDao.remove(livre);

	}

	@Override
	public void update(Livre livre) throws Exception {
		if (livre == null) {
			throw new NullPointerException("L'utilisateur metre à jours n'existe pas !"); }  
		livreDao.update(livre);

	}

	@Override
	public List<Livre> getLivresByAuthor(String auteur) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livre> getLivresByAnnee(Integer annee) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void gestionStock(String titre) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Livre> getLivresByCategories(String nomCategorie) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
