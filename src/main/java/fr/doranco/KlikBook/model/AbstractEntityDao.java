package fr.doranco.KlikBook.model;

import org.hibernate.Session;
import org.hibernate.Transaction;


public abstract class AbstractEntityDao<T> implements IEntityDao<T> {

	public AbstractEntityDao() {
	}

	@Override
	public void add(T entity) throws Exception {
		
		Session session = HibernateConnector.getSession();
		Transaction tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		if (session != null && session.isOpen())
			session.close();
	}

	@Override
	public T get(Class<T> entity, Integer id) throws Exception {
		
		Session session = HibernateConnector.getSession();
		T entityT = session.get((Class<T>) entity, id);
		if (session != null && session.isOpen())
			session.close();
		return entityT;
	}

	@Override
	public void update(T entity) throws Exception {
		
		Session session = HibernateConnector.getSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		if (session != null && session.isOpen())
			session.close();
	}

	@Override
	public void remove(T entity) throws Exception {
	
		Session session = HibernateConnector.getSession();
		Transaction tx = session.beginTransaction();
		session.remove(entity);
		tx.commit();
		if (session != null && session.isOpen())
			session.close();
	}

}
