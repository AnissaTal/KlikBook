package fr.doranco.KlikBook.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import fr.doranco.KlikBook.Dto.CartePaiementDto;
import fr.doranco.KlikBook.control.CartePaiementMetier;
import fr.doranco.KlikBook.control.ICartePaiementMetier;


@ManagedBean(name = "cartePaiementBeans")
public class CartePaiementBeans implements Serializable {

	private static final long serialVersionUID = 1L;

	private final CartePaiementDto cartePaiementDto = new CartePaiementDto();
	private final ICartePaiementMetier cartePaiementMetier = new CartePaiementMetier();

	@ManagedProperty(name = "idCartePaiement", value = "")
	private String idCartePaiement;

	@ManagedProperty(name = "nom_proprietaire", value = "")
	private String nomProprietaire;

	@ManagedProperty(name = "prenom_proprietaire", value = "")
	private String prenomProprietaire;

	@ManagedProperty(name = "numero", value = "")
	private String numero;

	@ManagedProperty(name = "cryptogramme", value = "")
	private String cryptogramme;

	@ManagedProperty(name = "date_fin_validite", value = "")
	private String dateFinValidite;

	@ManagedProperty(name = "messageSuccess", value = "")
	private static String messageSuccess;

	@ManagedProperty(name = "messageError", value = "")
	private static String messageError;

	
	@ManagedProperty(name = "user_id", value = "")
	private String user_id;
	
	static {
		messageSuccess = "";
		messageError = "";
	}

	public CartePaiementBeans() {
	}
	
	public String addCartePaiement() {
		CartePaiementDto cartePaiementDto= new CartePaiementDto();
		cartePaiementDto.setNomProprietaire(nomProprietaire);
		cartePaiementDto.setPrenomProprietaire(prenomProprietaire);
		cartePaiementDto.setNumero(numero);
		cartePaiementDto.setDateFinValidite(dateFinValidite);
		
		try {
			cartePaiementMetier.addCartePaiement(cartePaiementDto);
			messageSuccess = "Ajout de carte de paiement effectuée avec succès !";
		} catch (Exception e) {
			System.out.println(e);
			messageError = "Erreur lors de l'ajout de la carte de paiement !\n" + e.getMessage();
		}
				return"";
	}

	public String getIdCartePaiement() {
		return idCartePaiement;
	}

	public void setIdCartePaiement(String idCartePaiement) {
		this.idCartePaiement = idCartePaiement;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public static String getMessageSuccess() {
		return messageSuccess;
	}

	public static void setMessageSuccess(String messageSuccess) {
		CartePaiementBeans.messageSuccess = messageSuccess;
	}

	public static String getMessageError() {
		return messageError;
	}

	public static void setMessageError(String messageError) {
		CartePaiementBeans.messageError = messageError;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public CartePaiementDto getCartePaiementDto() {
		return cartePaiementDto;
	}	

}