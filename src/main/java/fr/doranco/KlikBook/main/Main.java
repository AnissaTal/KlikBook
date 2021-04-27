package fr.doranco.KlikBook.main;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.doranco.KlikBook.entity.Adresse;
import fr.doranco.KlikBook.entity.Commande;
import fr.doranco.KlikBook.entity.LigneDeCommande;
import fr.doranco.KlikBook.entity.User;
import fr.doranco.KlikBook.model.CommandeDao;
import fr.doranco.KlikBook.model.ICommandeDao;
import fr.doranco.KlikBook.model.IUserDao;
import fr.doranco.KlikBook.model.UserDao;
import fr.doranco.KlikBook.utils.Dates;

public class Main {

	public static void main(String[] args) {

		try {
			Adresse adresse11 = new Adresse(5, "Rue Blaise Pascal", "75000", "Paris");
			Adresse adresse12 = new Adresse(7, "Rue Lafayette", "69000", "Lyon");
			
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
