package fr.doranco.KlikBook.control;

import java.util.List;

import fr.doranco.KlikBook.Dto.UserDto;
import fr.doranco.KlikBook.entity.User;

public interface IUserMetier {

	User seConnecter(String email, String password) throws Exception;
	User getUserByEmail(String email) throws Exception;
	User getUserById(Integer id) throws Exception;
	void addUser(UserDto userDto) throws Exception;
	List<User> getUsers() throws Exception;
	void removeUser(UserDto userDto) throws Exception;
	void updateUser (UserDto userDto) throws Exception;
}
