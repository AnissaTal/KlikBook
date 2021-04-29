package fr.doranco.KlikBook.control;

import java.util.List;

import fr.doranco.KlikBook.entity.Adresse;



public interface IAdresseMetier {

	void addAdresse(Adresse adresse) throws Exception;
	List<Adresse> getAdressesById(Integer userId) throws Exception;
	void updateAdresse(Adresse adresse) throws Exception;
	void removeAdresse(Adresse adresse) throws Exception;

}
