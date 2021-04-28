package fr.doranco.KlikBook.main;


import fr.doranco.KlikBook.entity.Adresse;
import fr.doranco.KlikBook.entity.User;
import fr.doranco.KlikBook.model.AdresseDao;
import fr.doranco.KlikBook.model.IAdresseDao;
import fr.doranco.KlikBook.model.IUserDao;
import fr.doranco.KlikBook.model.UserDao;
import fr.doranco.KlikBook.utils.Dates;

public class Main {

	public static void main(String[] args) {

		try {
			
			Adresse adresse11 = new Adresse(5, "Rue Blaise Pascal", "75000", "Paris");
			Adresse adresse12 = new Adresse(5, "Rue Blaise Pascal", "75000", "Orly");
			
			Adresse adresse21 = new Adresse(5, "Rue 21 ", "75000", "Paris");
			Adresse adresse22 = new Adresse(5, "Rue 22 Pascal", "75000", "Orly");
			Adresse adresse23 = new Adresse(5, "Rue 23 Pascal", "75000", "Paris");
			Adresse adresse24 = new Adresse(5, "Rue 24 Pascal", "75000", "Orly");
			
			User user1 = new User("taleb", "anissa", Dates.convertStringToDateUtil("17/09/1990"), true, "client", "anissa@gmail.com");
			User user2 = new User("taleb", "skander", Dates.convertStringToDateUtil("29/06/2013"), true, "client", "skander@gmail.com");
			
			
	        adresse11.setUser(user1);
	        adresse12.setUser(user1);
	        
	        adresse21.setUser(user2);
	        adresse22.setUser(user2);
	        adresse23.setUser(user2);
	        adresse24.setUser(user2);
	        
	         user1.getAdresses().add(adresse11);
			user1.getAdresses().add(adresse12);
			user2.getAdresses().add(adresse21);
			user2.getAdresses().add(adresse22);
			user2.getAdresses().add(adresse23);
		user2.getAdresses().add(adresse24);
		
			Adresse adresse13 = new Adresse(5, "Rue Blaise Pascal", "75000", "Clamart");
			adresse13.setUser(user1);
		
			
			IUserDao userDao = new UserDao();
			

			userDao.add(user1);
			userDao.add(user2);
			
			IAdresseDao adresseDao= new AdresseDao();
			
			
			
			adresseDao.getAdresses(1);
			System.out.println(adresseDao);
			
		System.out.println("user ajouté : " + user1.getId() );
		System.out.println("adresse userId : " + adresse11.getUser().getId());
			
	
		
		
		

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
