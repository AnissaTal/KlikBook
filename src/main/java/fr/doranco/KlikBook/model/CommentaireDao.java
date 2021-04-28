package fr.doranco.KlikBook.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.KlikBook.entity.Commentaire;

public class CommentaireDao  extends AbstractEntityDao<Commentaire> implements ICommentaireDao {

	@Override
	public List<Commentaire> commentarieByNote(Integer note) throws Exception {
		Session session = HibernateConnector.getSession();
		// organizer les commentaires par order decreciente 
		Query<Commentaire> query = session.createQuery("FROM Commentaire c", Commentaire.class); 
		List<Commentaire> commentaires = query.list();
		if (session != null && session.isOpen())
			session.close();
		return commentaires;
	}

}
