package fr.doranco.KlikBook.main;


import fr.doranco.KlikBook.entity.Adresse;
import fr.doranco.KlikBook.entity.User;
import fr.doranco.KlikBook.model.IUserDao;
import fr.doranco.KlikBook.model.UserDao;
import fr.doranco.KlikBook.utils.Dates;

public class Main {

	public static void main(String[] args) {

		try {
			
			Adresse adresse11 = new Adresse(5, "Rue Blaise Pascal", "75000", "Paris");
			Adresse adresse12 = new Adresse(5, "Rue Blaise Pascal", "75000", "Orly");
			
			User user1 = new User("taleb", "anissa", Dates.convertStringToDateUtil("17/09/1990"), true, "client", "anissa@gmail.com");
	        adresse11.setUser(user1);
	        adresse12.setUser(user1);
	        
			user1.getAdresses().add(adresse11);
			user1.getAdresses().add(adresse12);
			
			
			
			
			
			
			
			
			
			
			
			
			Adresse adresse13 = new Adresse(5, "Rue Blaise Pascal", "75000", "Clamart");

			adresse13.setUser(user1);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			IUserDao userDao = new UserDao();
			
			userDao.add(user1);
			System.out.println("user ajouté : " + user1.getId() );
			System.out.println("adresse userId : " + adresse11.getUser().getId());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
