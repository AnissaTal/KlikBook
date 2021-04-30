package fr.doranco.KlikBook.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.KlikBook.Dto.AdresseDto;
import fr.doranco.KlikBook.Dto.CartePaiementDto;
import fr.doranco.KlikBook.Dto.UserDto;
import fr.doranco.KlikBook.control.IUserMetier;
import fr.doranco.KlikBook.control.UserMetier;
import fr.doranco.KlikBook.entity.User;



@ManagedBean(name = "userBean")
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
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
	
	@ManagedProperty(name = "numeroRue", value = "")
	private String numeroRue;
	
	@ManagedProperty(name ="rue" , value=" ")
	private String rue;
	
	@ManagedProperty(name ="ville" , value=" ")
	private String ville;
	
	@ManagedProperty(name ="codePostal" , value=" ")
	private String codePostal;
	
	
	@ManagedProperty(name = "numeroCarte", value = "")
	private String numeroCarte;
	
	@ManagedProperty(name = "nomProprietaire", value = "")
	private String nomProprietaire;

	@ManagedProperty(name = "prenomProprietaire", value = "")
	private String prenomProprietaire;

	@ManagedProperty(name = "cryptogramme", value = "")
	private String cryptogramme;

	@ManagedProperty(name = "dateFinValidite", value = "")
	private String dateFinValidite;

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
		userDto.setDateNaissance(dateDeNaissance);
		userDto.setTelephone(telephone);
		userDto.setPassword(password);
		
		AdresseDto adresseDto = new AdresseDto();
		adresseDto.setNumero(numeroRue);
		adresseDto.setRue(rue);
		adresseDto.setVille(ville);
		adresseDto.setCodePostal(codePostal);
		
		userDto.setAdresseDto(adresseDto);
		
		CartePaiementDto cartePaiementDto = new CartePaiementDto();
		cartePaiementDto.setNomProprietaire(nomProprietaire);
		cartePaiementDto.setPrenomProprietaire(prenomProprietaire);
		cartePaiementDto.setDateFinValidite(dateFinValidite);
		cartePaiementDto.setNumero(numeroCarte);
		cartePaiementDto.setCryptogramme(cryptogramme);
		
		userDto.setCartePaiementDto(cartePaiementDto);
	
		try {
			userMetier.addUser(userDto);
			messageSuccess = "Inscription effectuée avec succès !";
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
			messageError = "Erreur lors de la récupération des utilisateurs !\n" + e.getMessage();
		}
		return new ArrayList<User>();
	}

	public String remove() {
		try {
//			User user = userMetier.getUserById(new Integer(idUser));
//			user.setIsActif(false);
//			userMetier.updateUser(user);
		} catch (Exception e) {
			messageError = "Erreur lors de la suppression de l'utilisateur !\n" + e.getMessage();
		}
		return "";
	}

	public String modifierUser() {
		try {
			
//			idUser = String.valueOf(user.getId());
//			currentUserId = idUser;
//			prenom = user.getPrenom();
//			nom = user.getNom();
//			email = user.getEmail();
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
			messageSuccess = "la mise à jour effectuée avec succès !";
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

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	
	
	
	public String getNumeroRue() {
		return numeroRue;
	}

	public void setNumeroRue(String numeroRue) {
		this.numeroRue = numeroRue;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	public String getNomProprietaire() {
		return nomProprietaire;
	}

	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}

	public String getPrenomProprietaire() {
		return prenomProprietaire;
	}

	public void setPrenomProprietaire(String prenomProprietaire) {
		this.prenomProprietaire = prenomProprietaire;
	}

	

	public String getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(String cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public String getDateFinValidite() {
		return dateFinValidite;
	}

	public void setDateFinValidite(String dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
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
