package fr.doranco.KlikBook.model;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import fr.doranco.KlikBook.entity.Adresse;



public class AdresseDao extends AbstractEntityDao<Adresse> implements IAdresseDao {

	
	@Override
	public List<Adresse> getAdresses(Integer userId) throws Exception {
		Session session = HibernateConnector.getSession();
		Query<Adresse> query = session.createNativeQuery("SELECT*from Adresse WHERE user_id = ?", Adresse.class);
		query.setParameter("user_id", userId);
		List<Adresse> adresses = query.list();	
		if (session != null && session.isOpen())
			session.close();
		return adresses;	
	}

}
