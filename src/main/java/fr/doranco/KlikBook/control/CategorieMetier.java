package fr.doranco.KlikBook.control;

import java.util.List;

import fr.doranco.KlikBook.entity.Categorie;
import fr.doranco.KlikBook.model.CategorieDao;
import fr.doranco.KlikBook.model.ICategorieDao;

public class CategorieMetier implements ICategorieMetier {
	
	private final ICategorieDao categorieDao = new CategorieDao();

	
	@Override
	public void addCategorie(Categorie categorie) throws Exception {
		if (categorie == null) {
			throw new NullPointerException("L'adresse Ã  ajouter ne doit pas Ãªtre NULL !");
		}
		
		if (categorie.getNom() == null || categorie.getNom().trim().isEmpty() 
				|| categorie.getRemise()== null
		) {
			throw new IllegalArgumentException("tous les champs sont obligatoires");
		}
		categorieDao.add(categorie);
	}
	@Override
	public List<Categorie> getCategories() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	public void updateCategorie(Categorie categorie) throws Exception {
		if (categorie == null) {
			throw new NullPointerException("La categorie  à mettreà jours n'existe pas !"); }  
		categorieDao.update(categorie);
	}

	@Override
	public void removeCategorie(Categorie categorie) throws Exception {
		if (categorie == null) {
			throw new NullPointerException("La categorie à mettreà jours n'existe pas !"); }  

		categorieDao.remove(categorie);
	}

}
