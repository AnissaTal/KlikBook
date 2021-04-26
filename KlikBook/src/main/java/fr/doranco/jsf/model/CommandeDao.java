package fr.doranco.jsf.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.jsf.entity.Commande;

public class CommandeDao implements ICommandeDao{

	@Override
	public Commande getCommande(Integer id) {
		Session session = HibernateConnector.getSession();
		Commande commande = session.get(Commande.class, id);
		if (session != null && session.isOpen())
			session.close();
		return commande;
	}

	@Override
	public void addCommande(Commande commande) throws Exception{
		
			Transaction tx = null;
			Session session = null;
			try {
				session = HibernateConnector.getSession();
				tx = session.beginTransaction();
				session.save(commande);
				tx.commit();
			} catch (Exception ex) {
				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			} finally {
				if (session != null && session.isOpen())
					session.close();
			}
	
	}

	@Override
	public void updateCommande(Commande commande) {
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.update(commande);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		
	}

	@Override
	public void cancelCommande(Integer id) {
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.remove(id);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		
	}

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
			Query query = session.createQuery("FROM User u WHERE u.user := user");  // requete JPQL
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
