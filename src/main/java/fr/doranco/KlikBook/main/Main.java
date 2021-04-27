package fr.doranco.hibernate.main;

import fr.doranco.jsf.entity.Adresse;
import fr.doranco.jsf.entity.Commande;
import fr.doranco.jsf.entity.LigneDeCommande;
import fr.doranco.jsf.entity.User;
import fr.doranco.jsf.model.CommandeDao;
import fr.doranco.jsf.model.ICommandeDao;
import fr.doranco.jsf.model.IUserDao;
import fr.doranco.jsf.model.UserDao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.doranco.hibernate.utils.Dates;

public class Main {

	public static void main(String[] args) {

		try {
			Adresse adresse11 = new Adresse(5, "Rue Blaise Pascal", "75000", "Paris");
			Adresse adresse12 = new Adresse(7, "Rue Lafayette", "69000", "Lyon");
			User user1 = new User("HUGO", "Jean", Dates.convertStringToDateUtil("14/04/1956"), true, "jean@gmail.com", "jean");
			
			adresse11.setUser(user1);
			adresse12.setUser(user1);
			user1.getAdresses().add(adresse11);
			user1.getAdresses().add(adresse12);

			User user2 = new User("SAMY", "Antoine", Dates.convertStringToDateUtil("05/06/1985"), true, "antoine@gmail.com", "antoine");
			Adresse adresse2 = new Adresse(5, "Rue de la paix", "75000", "Paris");
			adresse2.setUser(user2);
			user2.getAdresses().add(adresse2);

			User user3 = new User("DUPOND", "Durand",  Dates.convertStringToDateUtil("01/01/2015"), true, "durand@yahoo.fr", "durand");
			Adresse adresse3 = new Adresse(9, "Rue Doranco", "69000", "Lyon");
			adresse3.setUser(user3);
			user3.getAdresses().add(adresse3);
			
			User user4 = new User("MONTAND", "Charles",  Dates.convertStringToDateUtil("26/11/1984"), true, "charles@gmail.com", "charles");
			Adresse adresse4 = new Adresse(8, "Place de la Bastille", "75000", "Paris");
			adresse4.setUser(user4);
			user4.getAdresses().add(adresse4);

			IUserDao userDao = new UserDao();
			userDao.addUser(user1);
			userDao.addUser(user2);
			userDao.addUser(user3);
			userDao.addUser(user4);
			
			
			Commande cde = new Commande(1,  Dates.convertStringToDateUtil("26/11/1984"), Dates.convertStringToDateUtil("26/11/1984"), 500, user1);
			LigneDeCommande lCde=new LigneDeCommande(1,2.0f,"testarticle", cde);
			
			lCde.setCommande(cde);
			cde.getLigneDeCommande().add(lCde);
			
			ICommandeDao cdeDao=new CommandeDao();
			cdeDao.addCommande(cde);

			System.out.println("========= PARIS =========");
			userDao.getUsersOfVille("Paris").forEach(user -> System.out.println(user.getNom() + " " + user.getPrenom()));
			
			System.out.println("========= LYON =========");
			userDao.getUsersOfVille("Lyon").forEach(user -> System.out.println(user.getNom() + " " + user.getPrenom()));
			
			System.out.println("============================================");
			System.out.println("==== Liste des utilisateurs par ville ====");
			Map<String, List<User>> map = userDao.getUsersByVille();
			Iterator<Entry<String, List<User>>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<String, List<User>> entry = iterator.next();
				System.out.println("Ville : " + entry.getKey());
				for (User user : entry.getValue()) {
					System.out.println("    -> " + user.getNom() + " " + user.getPrenom());
				}
			}

			System.exit(0);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
