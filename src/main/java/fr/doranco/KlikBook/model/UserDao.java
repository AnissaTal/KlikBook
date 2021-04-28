package fr.doranco.KlikBook.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.KlikBook.entity.User;

public class UserDao extends AbstractEntityDao<User> implements IUserDao {

	public UserDao() {
	}

	@Override
	public List<User> getUsers() throws Exception {
		Session session = HibernateConnector.getSession();
		Query<User> query = session.createQuery("FROM User u", User.class); 
	
		List<User> users = query.list();
		if (session != null && session.isOpen())
			session.close();
		return users;
	}


	@Override
	public User getUserByEmail(String email) throws Exception {
		Session session = HibernateConnector.getSession();
		Query<User> query = session.createNamedQuery("User.findByEmail", User.class);  
		query.setParameter("email", email);
		User user = query.getSingleResult();
		if (session != null && session.isOpen())
			session.close();
		return user;
	}

	@Override
	public List<User> getUsersOfVille(String ville) throws Exception {
		Session session = HibernateConnector.getSession();
		Query<User> query = session.createNamedQuery("User.findByVille", User.class);
		query.setParameter("ville", ville);
		List<User> users = query.list();	
		if (session != null && session.isOpen())
			session.close();
		return users;
	}

	@Override
	public Map<String, List<User>> getUsersByVille() throws Exception {
		Session session = HibernateConnector.getSession();
		Query<String> query = session.createQuery("SELECT DISTINCT a.ville FROM Adresse a", String.class);
		List<String> villes = query.list();
		Map<String, List<User>> map = new HashMap<String, List<User>>();
		for (String ville : villes) {
			 List<User> users = getUsersOfVille(ville);
			 map.put(ville, users);
		}
		return map;
	}

}
