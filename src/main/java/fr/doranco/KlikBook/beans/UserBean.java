package fr.doranco.KlikBook.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import fr.doranco.KlikBook.Dto.UserDto;
import fr.doranco.KlikBook.control.IUserMetier;
import fr.doranco.KlikBook.control.UserMetier;
import fr.doranco.KlikBook.entity.User;


@ManagedBean(name = "userBean")
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final UserDto userDto = new UserDto();
	private final IUserMetier userMetier = new UserMetier();

	@ManagedProperty(name = "idUser", value = "")
	private String idUser;

	@ManagedProperty(name = "nom", value = "")
	private String nom;

	@ManagedProperty(name = "prenom", value = "")
	private String prenom;

	@ManagedProperty(name = "dateDeNaissance", value = "")
	private String dateDeNaissance;
	
	@ManagedProperty(name = "email", value = "")
	private String email;

	@ManagedProperty(name = "password", value = "")
	private String password;

	

	@ManagedProperty(name = "telephone", value = "")
	private String telephone;
	

	@ManagedProperty(name = "messageSuccess", value = "")
	private static String messageSuccess;

	@ManagedProperty(name = "messageError", value = "")
	private static String messageError;

	@ManagedProperty(name = "currentUserId", value = "")
	private String currentUserId;
	
	
	static {
		messageSuccess = "";
		messageError = "";
	}

	public UserBean() {
	}

	public String addUser() {

		
		UserDto userDto = new UserDto();
		userDto.setNom(nom);
		userDto.setPrenom(prenom);
		userDto.setEmail(email);
		userDto.setPassword(password);
		try {
			userMetier.addUser(userDto);
			messageSuccess = "Inscription effectu�e avec succ�s !";
		} catch (Exception e) {
			System.out.println(e);
			messageError = "Erreur lors de l'inscription de l'utilisateur !\n" + e.getMessage();
		}
		return "";
	}

	public List<User> getUsers() {
		try {
			return userMetier.getUsers();
		} catch (Exception e) {
			messageError = "Erreur lors de la r�cup�ration des utilisateurs !\n" + e.getMessage();
		}
		return new ArrayList<User>();
	}

	public String remove(User user) {
		try {
			userMetier.removeUser(userDto);
		} catch (Exception e) {
			messageError = "Erreur lors de la suppression de l'utilisateur !\n" + e.getMessage();
		}
		return "";
	}

	public String modifierUser(User user) {
		try {
			
			idUser = String.valueOf(user.getId());
			currentUserId = idUser;
			prenom = user.getPrenom();
			nom = user.getNom();
			email = user.getEmail();
		} catch (Exception e) {
			messageError = "Erreur lors de la modififcatoin  de l'utilisateur !\n" + e.getMessage();
		}
		return "";
	}

	public String updateUser() {
		try {
			

			User user = userMetier.getUserById(Integer.parseInt(currentUserId));
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setEmail(email);
			//user.setPassword(password);

			//userMetier.updateUser(user);
			messageSuccess = "la mise � jour effectu�e avec succ�s !";
		} catch (Exception e) {
			System.out.println(e);
			messageError = "Erreur lors de la mise a jour  de l'utilisateur !\n" + e.getMessage();
		}
		return "";
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
	}


	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		UserBean.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		UserBean.messageError = messageError;
	}

}
