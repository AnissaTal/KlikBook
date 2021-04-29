package fr.doranco.KlikBook.model;

import java.util.List;

import fr.doranco.KlikBook.entity.Adresse;


public interface IAdresseDao  extends IEntityDao<Adresse>{

	List<Adresse> getAdresses(Integer userId) throws Exception;
}
