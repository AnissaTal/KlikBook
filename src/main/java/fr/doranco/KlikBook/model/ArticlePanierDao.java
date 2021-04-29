package fr.doranco.KlikBook.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import fr.doranco.KlikBook.entity.ArticlePanier;


public class ArticlePanierDao  extends AbstractEntityDao<ArticlePanier> implements IArticlePanier {
	@Override
	public List<ArticlePanier> getArticlePaniers(Integer userId) throws Exception {
		Session session = HibernateConnector.getSession();
		Query<ArticlePanier> query = session.createNativeQuery("SELECT*from article_panier WHERE User_id = ?", ArticlePanier.class);
		query.setParameter("user_id", userId);
		List<ArticlePanier> articlesPanier = query.list();	
		if (session != null && session.isOpen())
			session.close();
		return articlesPanier;	
	}
}
