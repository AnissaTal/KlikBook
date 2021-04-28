package fr.doranco.KlikBook.model;

import org.hibernate.Session;

import fr.doranco.KlikBook.entity.CartePaiement;
import fr.doranco.KlikBook.entity.User;


public class CartePaiementDao extends AbstractEntityDao<CartePaiement> implements ICartePaiementDao {

	
	
	@Override
	public User getUserByCartePaiement (Integer utilisateurId) throws Exception {
		Session session = HibernateConnector.getSession();
		
		
		User user = query.getSingleResult();
		if (session != null && session.isOpen())
			session.close();
		return user;
		
	}
}
