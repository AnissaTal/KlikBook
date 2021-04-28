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
			User user1 =new User("taleb", "anissa", Dates.convertStringToDateUtil("17/09/1900"), true, "cliente", "anissa@gmail.com", null,0102030405, 1, 1, 1, null, null, null, null, null, null);
			//user1.getAdresses().add(adresse11);
			
			IUserDao userDao = new UserDao();
			
			userDao.add(user1);
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
