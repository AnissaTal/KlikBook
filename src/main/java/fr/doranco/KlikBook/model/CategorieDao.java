package fr.doranco.KlikBook.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.KlikBook.entity.Categorie;
import fr.doranco.KlikBook.entity.Livre;

public class CategorieDao extends AbstractEntityDao<Categorie> implements ICategorieDao {

	@Override
	public List<Categorie> getCategories() throws Exception {
		Session session = HibernateConnector.getSession();

		Query<Categorie> query = session.createQuery("FROM Categorie c", Categorie.class); // requete JPQL
		// Query query = session.createNativeQuery("SELECT * FROM user", User.class); //
		// requete SQL pure
		// Query query = session.createNamedQuery("User.findAll", User.class); //
		// requete prédéfinie

		List<Categorie> categories = query.list();
		if (session != null && session.isOpen())
			session.close();
		return categories;
	}
	
	
//je ne sais pas si cet methode dois etre en livre??
	@Override
	public List<Livre> getLivresByCategories(String nom) throws Exception {
	//nom de la categorie 
		Session session = HibernateConnector.getSession();
		Query<Livre> query = session.createNamedQuery("Livre.findByCategorie",Livre.class);
		query.setParameter("nom", nom);
		List<Livre> livres = query.list();	
		if (session != null && session.isOpen())
			session.close();
		return livres;
	}

}
