package fr.doranco.KlikBook.Dto;

import fr.doranco.KlikBook.control.IUserMetier;
import fr.doranco.KlikBook.control.UserMetier;

public class UserDto {

	IUserMetier userMetier = new UserMetier();

	private String nom;
	private String prenom;
	private String dateNaissance;
	private String email;
	private String password;
	private String telephone;
	private AdresseDto adresseDto;
	private CartePaiementDto cartePaiementDto;

	public UserDto() {
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

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public AdresseDto getAdresseDto() {
		return adresseDto;
	}

	public void setAdresseDto(AdresseDto adresseDto) {
		this.adresseDto = adresseDto;
	}

	public CartePaiementDto getCartePaiementDto() {
		return cartePaiementDto;
	}

	public void setCartePaiementDto(CartePaiementDto cartePaiementDto) {
		this.cartePaiementDto = cartePaiementDto;
	}

}
