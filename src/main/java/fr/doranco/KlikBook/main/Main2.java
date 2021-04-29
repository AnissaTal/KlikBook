package fr.doranco.KlikBook.main;

import fr.doranco.KlikBook.entity.Adresse;
import fr.doranco.KlikBook.entity.Categorie;
import fr.doranco.KlikBook.entity.Livre;
import fr.doranco.KlikBook.entity.User;
import fr.doranco.KlikBook.model.CategorieDao;
import fr.doranco.KlikBook.model.ICategorieDao;
import fr.doranco.KlikBook.model.ILivreDao;
import fr.doranco.KlikBook.model.IUserDao;
import fr.doranco.KlikBook.model.LivreDao;
import fr.doranco.KlikBook.model.UserDao;
import fr.doranco.KlikBook.utils.Dates;

public class Main2 {

	public static void main(String[] args) {
		try {

			Adresse adresse11 = new Adresse(5, "Rue Blaise Pascal", "75000", "Paris");
			Adresse adresse12 = new Adresse(5, "Rue Blaise Pascal", "75000", "Orly");
			Adresse adresse13 = new Adresse(5, "Rue Blaise Pascal", "75000", "Clamart");
			User user1 = new User("taleb", "anissa", Dates.convertStringToDateUtil("17/09/1990"), true, "client",
					"anissa@gmail.com");
			adresse11.setUser(user1);
			adresse12.setUser(user1);
			adresse13.setUser(user1);

			user1.getAdresses().add(adresse11);
			user1.getAdresses().add(adresse12);

			IUserDao userDao = new UserDao();

			userDao.add(user1);
			System.out.println("user ajouté : " + user1.getId());
			System.out.println("adresse userId : " + adresse11.getUser().getId());
			/// ----------------------------------------------------------
			//adresse = livre
			//user = categorie
			
			Livre livre1 = new Livre("Le petit prince", "Antoine de Saint-Exupéry", 1943, 19f, 20, 5);
			Livre livre2 = new Livre("Le petit prince 2 la vengence", "Antoine de Saint-Exupéry", 1950, 50f, 20, 1);
		
					
			Categorie categorie1 = new Categorie(20, "Litterature");
			
			livre1.setCategorie(categorie1);
			livre2.setCategorie(categorie1);
			categorie1.getLivres().add(livre1);
			categorie1.getLivres().add(livre2);			
			
			ICategorieDao categorieDao = new CategorieDao();
			
			//ILivreDao livreDao = new LivreDao();
			//livreDao.add(livre1);
			//livreDao.add(livre2);		
			
			categorieDao.add(categorie1);

			// System.out.println(categorie1);
			System.out.println("categorie ajoutée : " + categorie1.getId());
			System.out.println("livre ajoute " + livre1.getId());
			// categorie1.getLivres().forEach(livre-> System.out.println(livre));
			// System.exit(0);

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}
}
