package fr.doranco.KlikBook.control;

import java.util.ArrayList;
import java.util.List;

import fr.doranco.KlikBook.Dto.UserDto;
import fr.doranco.KlikBook.entity.User;
import fr.doranco.KlikBook.model.IUserDao;
import fr.doranco.KlikBook.model.UserDao;

public class UserMetier implements IUserMetier {

	private final IUserDao userDao = new UserDao();

	
	@Override
	public User seConnecter(String email, String password) throws Exception {
		User user = userDao.getUserByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	@Override
	public void addUser(UserDto userDto) throws Exception {

		if (userDto == null) {
			throw new NullPointerException("l'utilisateur � ajouter est NULL !");
		}
		if (userDto.getNom() == null || userDto.getNom().trim().isEmpty() || userDto.getPrenom() == null
				|| userDto.getPrenom().trim().isEmpty() || userDto.getEmail() == null || userDto.getEmail().trim().isEmpty()
				|| userDto.getPassword() == null || userDto.getPassword().toString().trim().isEmpty()

		) {
			throw new IllegalArgumentException("tous les champs sont obligatoires");
		}
		User userInDb = userDao.getUserByEmail(userDto.getEmail());
		if (userInDb != null) {
			throw new IllegalArgumentException("Vilation de contrainte ! L'email de l'utilisateur � ajouter existe d�j�.");
		}
		
		userDto.setNom(userDto.getNom().toUpperCase());
		userDto.setPrenom(userDto.getPrenom().substring(0, 1).toUpperCase()
				.concat(userDto.getPrenom().toLowerCase().substring(1, userDto.getPrenom().length())));
		
         User user = new User();
   
        
		 //userDao.add(userDto);
	}

	@Override
	public List<User> getUsers() throws Exception {
		List<User> users = userDao.getUsers();
		if (users != null)
		return users;
		return new ArrayList<User>();

	}

	@Override
	public void removeUser(User user) throws Exception {
		
		if (getUserById(user.getId()) == null) {
			throw new NullPointerException("L'utilisateur � supprimer n'existe pas !");
		}

		userDao.remove(user);
	}

	@Override
	public void updateUser (User user) throws Exception {
		if (user == null) {
			throw new NullPointerException("l'utilisateur � ajouter est NULL !");
		}
		if (user.getId() == null || user.getId() <= 0
				|| user.getNom() == null || user.getNom().trim().isEmpty() || user.getPrenom() == null
				|| user.getPrenom().trim().isEmpty() || user.getEmail() == null || user.getEmail().trim().isEmpty()
				|| user.getPassword() == null || user.getPassword().toString().trim().isEmpty()

		) {
			throw new IllegalArgumentException("tous les champs sont obligatoires");
		}
		if (userDao.getUserByEmail(user.getEmail()) == null)
			throw new NullPointerException("L'utilisateur � mettre � jour n'existe pas dans la bdd !");
		userDao.update(user);

	}

	@Override
	public User getUserById(Integer idUser) throws Exception {
		
		if (idUser == null)
			throw new NullPointerException("L'id de l'utilisateur � r�cup�rer ne doit pas �tre NULL !");
		if (idUser <= 0)
				throw new IllegalArgumentException("L'id de l'utilisateur � r�cup�rer ne doit pas �tre <= 0");
		
		//return userDao.getUserById(idUser);
		return null;
		
	}

	@Override
	public User getUserByEmail(String email) throws Exception {

		if (email == null)
			throw new NullPointerException("Le mail de l'utilisateur � r�cup�rer ne doit pas �tre NULL !");
	
		return userDao.getUserByEmail(email);
	}

}

