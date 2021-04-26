package fr.doranco.jsf.control;

import java.util.ArrayList;
import java.util.List;

import fr.doranco.jsf.entity.User;
import fr.doranco.jsf.model.IUserDao;
import fr.doranco.jsf.model.UserDao;

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
	public User addUser(User user) throws Exception {

		if (user == null) {
			throw new NullPointerException("l'utilisateur à ajouter est NULL !");
		}
		if (user.getNom() == null || user.getNom().trim().isEmpty() || user.getPrenom() == null
				|| user.getPrenom().trim().isEmpty() || user.getEmail() == null || user.getEmail().trim().isEmpty()
				|| user.getPassword() == null || user.getPassword().trim().isEmpty()

		) {
			throw new IllegalArgumentException("tous les champs sont obligatoires");
		}
		User userInDb = userDao.getUserByEmail(user.getEmail());
		if (userInDb != null) {
			throw new IllegalArgumentException("Vilation de contrainte ! L'email de l'utilisateur à ajouter existe déjà.");
		}
		
		user.setNom(user.getNom().toUpperCase());
		user.setPrenom(user.getPrenom().substring(0, 1).toUpperCase()
				.concat(user.getPrenom().toLowerCase().substring(1, user.getPrenom().length())));

		userDao.addUser(user);
		return user;
	}

	@Override
	public List<User> getUsers() throws Exception {
		List<User> users = userDao.getUsers();
		if (users != null)
			return users;
		return new ArrayList<User>();
	}

	@Override
	public void removeUser(Integer id) throws Exception {
		
		if (getUserById(id) == null) {
			throw new NullPointerException("L'utilisateur à supprimer n'existe pas !");
		}

		//userDao.removeUser(id);
	}

	@Override
	public void updateUser(User user) throws Exception {
		if (user == null) {
			throw new NullPointerException("l'utilisateur à ajouter est NULL !");
		}
		if (user.getId() == null || user.getId() <= 0
				|| user.getNom() == null || user.getNom().trim().isEmpty() || user.getPrenom() == null
				|| user.getPrenom().trim().isEmpty() || user.getEmail() == null || user.getEmail().trim().isEmpty()
				|| user.getPassword() == null || user.getPassword().trim().isEmpty()

		) {
			throw new IllegalArgumentException("tous les champs sont obligatoires");
		}
		//if (userDao.getUserById(user.getId()) == null)
			//throw new NullPointerException("L'utilisateur à mettre à jour n'existe pas dans la bdd !");
		userDao.updateUser(user);

	}

	@Override
	public User getUserById(Integer idUser) throws Exception {
		
		if (idUser == null)
			throw new NullPointerException("L'id de l'utilisateur à récupérer ne doit pas être NULL !");
		if (idUser <= 0)
				throw new IllegalArgumentException("L'id de l'utilisateur à récupérer ne doit pas être <= 0");
		
		//return userDao.getUserById(idUser);
		return null;
		
	}

	@Override
	public User getUserByEmail(String email) throws Exception {
		return userDao.getUserByEmail(email);
	}

}

