package fr.doranco.KlikBook.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import fr.doranco.KlikBook.entity.LigneDeCommande;

public class LigneDeCommandeDao  extends AbstractEntityDao<LigneDeCommande> implements ILigneDeCommandeDao{



	@Override
	public List<LigneDeCommande> getLignesDeCommande(Integer commandId) {
			Session session = HibernateConnector.getSession();
				Query query = session.createQuery("FROM Commande c WHERE c.commande := commande"); 
				query.setParameter("commande", commandId);
				return query.list();
			
		}
	

}
