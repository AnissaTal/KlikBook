package fr.doranco.jsf.model;

import java.util.List;
import java.util.Map;

import fr.doranco.jsf.entity.User;


public interface IUserDao {

	void addUser(User user) throws Exception;

	User getUser(Integer id) throws Exception;

	List<User> getUsers() throws Exception;

	void updateUser(User user) throws Exception;

	void removeUser(User user) throws Exception;

	User getUserByEmail(String email) throws Exception;

	List<User> getUsersOfVille(String ville) throws Exception;

	Map<String, List<User>> getUsersByVille() throws Exception;

	List<User> getUsersWithNoCommand() throws Exception;
}