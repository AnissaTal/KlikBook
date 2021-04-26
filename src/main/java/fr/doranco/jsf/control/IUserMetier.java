package fr.doranco.jsf.control;

import java.util.List;

import fr.doranco.jsf.entity.User;

public interface IUserMetier {

	User seConnecter(String email, String password) throws Exception;
	User getUserByEmail(String email) throws Exception;
	User getUserById(Integer id) throws Exception;
	User addUser(User user) throws Exception;
	List<User> getUsers() throws Exception;
	void removeUser(Integer id) throws Exception;
	void updateUser (User user) throws Exception;
}
