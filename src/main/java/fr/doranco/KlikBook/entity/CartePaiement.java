package fr.doranco.KlikBook.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.sun.istack.Nullable;


@Entity
@Table(name = "carte_paiement")public class CartePaiement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Nullable
	@Column(name = "nom_proprietaire", nullable = true)
	private String nomProprietaire;
	@Nullable
	@Column(name = "prenom_proprietaire", nullable = true)
	private String prenomProprietaire;
	
	
	@Nullable
	@Column(name = "numero", nullable = true)
	private byte[] numero;
	
	@Nullable
	@Column(name = "cryptogramme", nullable = true)
	private byte[] cryptogramme;
	
	@Nullable
	@Column(name = "date_fin_validite", nullable = true)
	private Date dateFinValidite;
	
	@Nullable
	@Column(name = "cle_cryptage", nullable = true)
	private byte[] cleCryptage;
	
	@ManyToOne(cascade =CascadeType.ALL ) 
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	
	public CartePaiement() {
		user= new User();
	}

	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public byte[] getNumero() {
		return numero;
	}


	public void setNumero(byte[] numero) {
		this.numero = numero;
	}


	public byte[] getCryptogramme() {
		return cryptogramme;
	}


	public void setCryptogramme(byte[] cryptogramme) {
		this.cryptogramme = cryptogramme;
	}


	public Date getDateFinValidite() {
		return dateFinValidite;
	}


	public void setDateFinValidite(Date dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}

	public User getUser() {
		return user;
	}

	

	public void setUser(User user) {
		this.user = user;
	}


	
	
	public byte[] getCleCryptage() {
		return cleCryptage;
	}




	public void setCleCryptage(byte[] cleCryptage) {
		this.cleCryptage = cleCryptage;
	}




	@Override
	public String toString() {
		return "CartePaiement [id=" + id + ", nomProprietaire=" + nomProprietaire + ", prenomProprietaire="
				+ prenomProprietaire + ", numero=" + Arrays.toString(numero) + ", cryptogramme="
				+ Arrays.toString(cryptogramme) + ", dateFinValidite=" + dateFinValidite + ", user=" + user + "]";
	}






}
