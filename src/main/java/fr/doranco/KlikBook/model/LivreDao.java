package fr.doranco.KlikBook.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.KlikBook.entity.Livre;





public class LivreDao extends AbstractEntityDao<Livre> implements ILivreDao {

	@Override
	public List<Livre> getLivres() throws Exception {
		Session session = HibernateConnector.getSession();
		
		Query<Livre> query = session.createQuery("FROM Livre l", Livre.class);
	
		List<Livre> livres = query.list();
		if (session != null && session.isOpen())
			session.close();
		return livres;
	}

	@Override
	public List<Livre> getLivresByAuthor(String auteur) throws Exception {
		Session session = HibernateConnector.getSession();
		Query<Livre> query = session.createNamedQuery("Livre.findByAuthor",Livre.class);
		query.setParameter("auteur", auteur);
		List<Livre> livres = query.list();	
		if (session != null && session.isOpen())
			session.close();
		return livres;
	}

	@Override
	public List<Livre> getLivresByAnnee(Integer annee) throws Exception {
		Session session = HibernateConnector.getSession();
		Query<Livre> query = session.createNamedQuery("Livre.findByAnnee",Livre.class);
		query.setParameter("annee", annee);
		List<Livre> livres = query.list();	
		if (session != null && session.isOpen())
			session.close();
		return livres;
	}

	@Override
	public void gestionStock(String titre) throws Exception {
		

	}

}
