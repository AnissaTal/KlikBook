package fr.doranco.KlikBook.control;

import java.util.List;

import fr.doranco.KlikBook.entity.User;

public interface IUserMetier {

	User seConnecter(String email, String password) throws Exception;
	User getUserByEmail(String email) throws Exception;
	User getUserById(Integer id) throws Exception;
	void add(User user) throws Exception;
	List<User> getUsers() throws Exception;
	void remove(User user) throws Exception;
	void update (User user) throws Exception;
}
