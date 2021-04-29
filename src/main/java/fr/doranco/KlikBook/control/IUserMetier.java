package fr.doranco.KlikBook.control;

import java.util.List;

import fr.doranco.KlikBook.Dto.UserDto;
import fr.doranco.KlikBook.entity.User;

public interface IUserMetier {

	User seConnecter(String email, String password) throws Exception;
	User getUserByEmail(String email) throws Exception;
	User getUserById(Integer id) throws Exception;
	void addUser(UserDto userdto) throws Exception;
	List<User> getUsers() throws Exception;
	void removeUser(User user) throws Exception;
	void updateUser (User user) throws Exception;
}
