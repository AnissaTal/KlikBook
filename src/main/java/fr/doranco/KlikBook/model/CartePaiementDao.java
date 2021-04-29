package fr.doranco.KlikBook.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.doranco.KlikBook.entity.CartePaiement;
import fr.doranco.KlikBook.entity.User;


public class CartePaiementDao extends AbstractEntityDao<CartePaiement> implements ICartePaiementDao {

	@Override
	public User getUserByCartePaiement(Integer cartePaiementId) throws Exception {
		
		Session session = HibernateConnector.getSession();
		
		Query query = session.createQuery("SELECT user FROM carte_paiement where id = :id", User.class); 
        query.setParameter("id", cartePaiementId);
    User user = (User) query.getSingleResult();
        if (session != null && session.isOpen())
            session.close();
          
		
		return user;
	}

	
	
	
}
