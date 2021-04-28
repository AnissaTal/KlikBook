package fr.doranco.KlikBook.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.KlikBook.entity.Commande;

public class CommandeDao  extends AbstractEntityDao<Commande> implements ICommandeDao{


	@Override
	public List<Commande> getCommandes() {
		Session session = HibernateConnector.getSession();
		Query<Commande> query = session.createQuery("FROM Commande u", Commande.class); 
		List<Commande> commandes = query.list();
		if (session != null && session.isOpen())
			session.close();
		return commandes;
	}

	@Override
	public List<Commande> getCommandesByUtilisateurId(Integer utilisateurId) {
		Session session = HibernateConnector.getSession();
			Query query = session.createQuery("FROM User u WHERE u.user := user"); 
			query.setParameter("user", utilisateurId);
			return query.list();
		
	}

	@Override
	public List<Commande> getCommandesByVille(String ville) {
		Session session = HibernateConnector.getSession();
		Query query = session.createQuery("SELECT DISTINCT a.ville FROM Adresse a", String.class); 
		query.setParameter("adresse", ville);
		return query.list();
	}

}
