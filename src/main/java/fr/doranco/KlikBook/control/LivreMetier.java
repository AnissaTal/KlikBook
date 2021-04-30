package fr.doranco.KlikBook.control;

import java.util.List;

import fr.doranco.KlikBook.Dto.LivreDto;
import fr.doranco.KlikBook.entity.Livre;
import fr.doranco.KlikBook.model.ILivreDao;
import fr.doranco.KlikBook.model.LivreDao;

public class LivreMetier implements ILivreMetier {

	private final ILivreDao livreDao = new LivreDao(); 
	

	
	@Override
	public void addLivre(LivreDto livreDto) throws Exception {
		if (livreDto == null) {
			throw new NullPointerException("le livre à ajouter est NULL !");
		}
		
		if (livreDto.getTitre() == null || livreDto.getTitre().trim().isEmpty() ||
				livreDto.getAuteur() == null||livreDto.getAuteur().isEmpty() 
				|| livreDto.getAnnee() == null
				|| livreDto.getPrix() == null 
				|| livreDto.getRemise()== null
				|| livreDto.getStock()== null
		) {
			throw new IllegalArgumentException("tous les champs sont obligatoires");
		}
		
		Livre livre = new Livre();
		livre.setTitre(livreDto.getTitre());
		livre.setAuteur(livreDto.getAuteur());
		livre.setAnnee(Integer.parseInt(livreDto.getAnnee()));
		livre.setPrix(Integer.parseInt(livreDto.getPrix()));
		livre.setRemise(Integer.parseInt(livreDto.getRemise()));
		livre.setStock(Integer.parseInt(livreDto.getStock()));
			
		livreDao.add(livre);
	}


	
	@Override
	public List<Livre> getLivres() throws Exception {
		
		return null;
	}

	@Override
	public void removeLivre(Livre livre) throws Exception {
		if (livre == null) {
			throw new NullPointerException("L'utilisateur à eliminer n'existe pas !"); }  
		livreDao.remove(livre);

	}

	@Override
	public void updateLivre(Livre livre) throws Exception {
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
