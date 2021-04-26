package fr.doranco.jsf.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.jsf.entity.User;

public class UserDao implements IUserDao {

	public UserDao() {
	}

	@Override
	public void addUser(User user) throws Exception {
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.save(user);
			//user.getAdresses().forEach(adresse -> session.save(adresse));
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
	public User getUser(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		User user = session.get(User.class, id);
//		return session.find(User.class, id);
		if (session != null && session.isOpen())
			session.close();
		return user;
	}

	@Override
	public List<User> getUsers() throws Exception {
		Session session = HibernateConnector.getSession();
		// 3 possibilités d'exécuter une requete :
		Query<User> query = session.createQuery("FROM User u", User.class); // requete JPQL
		//Query query = session.createNativeQuery("SELECT * FROM user", User.class);  // requete SQL pure
		//Query query = session.createNamedQuery("User.findAll", User.class);  // requete prédéfinie

		List<User> users = query.list();
		if (session != null && session.isOpen())
			session.close();
		return users;
	}

	@Override
	public void updateUser(User user) throws Exception {
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.update(user);
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
	public void removeUser(User user) throws Exception {
		
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.remove(user);
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
	public User getUserByEmail(String email) throws Exception {
		Session session = HibernateConnector.getSession();
		Query<User> query = session.createNamedQuery("User.findByEmail", User.class);  // requete prédéfinie
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
		Query<String> query = session.createQuery("SELECT DISTINCT a.ville FROM Adresse a", String.class); // requete JPQL
		List<String> villes = query.list();
		Map<String, List<User>> map = new HashMap<String, List<User>>();
		for (String ville : villes) {
			 List<User> users = getUsersOfVille(ville);
			 map.put(ville, users);
		}
		return map;
	}


	@Override
	public List<User> getUsersWithNoCommand() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
