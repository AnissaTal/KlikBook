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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "carte_paiement")public class CartePaiement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@NotNull
	@Column(name = "nom_proprietaire", nullable = false)
	private String nomProprietaire;
	@NotNull
	@Column(name = "prenom_proprietaire", nullable = false)
	private String prenomProprietaire;
	
	
	@NotNull
	@Column(name = "numero", nullable = false)
	private byte[] numero;
	
	@NotNull
	@Column(name = "cryptogramme", nullable = false)
	private byte[] cryptogramme;
	
	@NotNull
	@Column(name = "date_fin_validite", nullable = false)
	private Date dateFinValidite;
	
	@ManyToOne(cascade =CascadeType.ALL ) 
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	
	public CartePaiement() {
		user= new User();
	}

	
	public CartePaiement(@NotNull String nomProprietaire, @NotNull String prenomProprietaire, @NotNull byte[] numero,
			@NotNull byte[] cryptogramme, @NotNull Date dateFinValidite, User user) {
	
		this.nomProprietaire = nomProprietaire;
		this.prenomProprietaire = prenomProprietaire;
		this.numero = numero;
		this.cryptogramme = cryptogramme;
		this.dateFinValidite = dateFinValidite;
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


	@Override
	public String toString() {
		return "CartePaiement [id=" + id + ", nomProprietaire=" + nomProprietaire + ", prenomProprietaire="
				+ prenomProprietaire + ", numero=" + Arrays.toString(numero) + ", cryptogramme="
				+ Arrays.toString(cryptogramme) + ", dateFinValidite=" + dateFinValidite + ", user=" + user + "]";
	}






}
