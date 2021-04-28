package fr.doranco.KlikBook.model;

import java.util.List;
import java.util.Map;
import fr.doranco.KlikBook.entity.User;


public interface IUserDao {

	
	List<User> getUsers() throws Exception;

	User getUserByEmail(String email) throws Exception;

	List<User> getUsersOfVille(String ville) throws Exception;

	Map<String, List<User>> getUsersByVille() throws Exception;

}