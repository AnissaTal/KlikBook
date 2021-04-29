package fr.doranco.KlikBook.control;

import java.util.List;

import fr.doranco.KlikBook.entity.ArticlePanier;
import fr.doranco.KlikBook.model.ArticlePanierDao;
import fr.doranco.KlikBook.model.IArticlePanierDao;

public class ArticlePanierMetier implements IArticlePanierMetier {

	IArticlePanierDao articlePanierDao = new ArticlePanierDao();
	
	@Override
	public List<ArticlePanier> getArticlePaniers(Integer userId) throws Exception {
		if (userId == null)
			throw new NullPointerException("L'id de l'utilisateur à récupérer ne doit pas être NULL !");
		if (userId <= 0)
				throw new IllegalArgumentException("L'id de l'utilisateur à récupérer ne doit pas être <= 0");
		return articlePanierDao.getArticlePaniers(userId);
	}

}
