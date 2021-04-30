package fr.doranco.KlikBook.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.Nullable;


@Entity
@Table(name = "user")
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "FROM User u"),
	@NamedQuery(name = "User.findByEmail", query = "FROM User u WHERE u.email = :email"),
	@NamedQuery(name = "User.findByVille", query = "SELECT u FROM User u JOIN u.adresses a ON a.ville = :ville")	
	
})

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	
	@NotEmpty
	@Column(name = "nom", length = 45, nullable = false)
	private String nom;
	
	@NotEmpty
	@Column(name = "prenom", length = 45, nullable = false)
	private String prenom;
	
	@Nullable
	@Column(name = "date_naissance", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@Nullable
	@Column(name = "actif", length = 1, nullable = true)
	private Boolean isActif;

	@Nullable
	@Column(name = "profil", length = 10, nullable = true)
	private String profil;
	
	@NotEmpty
	@Column(name = "email", nullable = false,unique=true)
	@Size(message = "Le Email doit être compris entre 5 et 20 caractères")
	private String email;
	
	@Nullable
	@Column(name = "password", nullable = true)
	@Size(min = 2, max = 15, message = "Le mot de passe doit être compris entre 2 et 15 caractères")
	private byte[] password;
	
	@Nullable
	@Column(name = "telephone", length = 13, nullable = true)
	private Integer telephone;

	@Nullable
	@Column(name = "adresse_facturation_id", length = 10, nullable = true)
	private Integer adresseFacturationId;
	
	@Nullable
	@Column(name = "adresse_livraison_id", length = 10, nullable = true)
	private Integer adresseLivraisonId;
	
	@Nullable
	@Column(name = "carte_paiement_id", length = 10, nullable = true)
	private Integer cartePaiementId;
	
	@Nullable
	@Column(name = "cle_cryptage", nullable = true)
	private byte[] cleCryptage;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Adresse> adresses;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Commande> commandes;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<CartePaiement> cartesPaiement;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Commentaire> commentaires;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<ArticlePanier> panier;
	
	
	
	public User() {
		adresses = new ArrayList<Adresse>();
		commandes = new ArrayList<Commande>();
		cartesPaiement = new ArrayList<CartePaiement>();
		commentaires = new ArrayList<Commentaire>();
		panier = new ArrayList<ArticlePanier>();
	}

	
	public User(String nom, String prenom, @NotNull Date dateNaissance, @NotNull Boolean isActif,
			@NotNull String profil,
			@Size(min = 5, max = 20, message = "Le Email doit être compris entre 5 et 20 caractères") String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.isActif = isActif;
		this.profil = profil;
		this.email = email;
			
		adresses = new ArrayList<Adresse>();
		commandes = new ArrayList<Commande>();
		cartesPaiement = new ArrayList<CartePaiement>();
		commentaires = new ArrayList<Commentaire>();
		panier = new ArrayList<ArticlePanier>();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public Date getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public Boolean getIsActif() {
		return isActif;
	}


	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}


	public String getProfil() {
		return profil;
	}


	public void setProfil(String profil) {
		this.profil = profil;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public byte[] getPassword() {
		return password;
	}


	public void setPassword(byte[] password) {
		this.password = password;
	}


	public Integer getTelephone() {
		return telephone;
	}


	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}


	public Integer getAdresseFacturationId() {
		return adresseFacturationId;
	}


	public void setAdresseFacturationId(Integer adresseFacturationId) {
		this.adresseFacturationId = adresseFacturationId;
	}


	public Integer getAdresseLivraisonId() {
		return adresseLivraisonId;
	}


	public void setAdresseLivraisonId(Integer adresseLivraisonId) {
		this.adresseLivraisonId = adresseLivraisonId;
	}


	public byte[] getCleCryptage() {
		return cleCryptage;
	}


	public void setCleCryptage(byte[] cleCryptage) {
		this.cleCryptage = cleCryptage;
	}


	public List<ArticlePanier> getPanier() {
		return panier;
	}


	public Integer getCartePaiementId() {
		return cartePaiementId;
	}


	public List<Adresse> getAdresses() {
		return adresses;
	}


	public List<Commande> getCommandes() {
		return commandes;
	}


	public List<CartePaiement> getCartesPaiement() {
		return cartesPaiement;
	}


	public List<Commentaire> getCommentaires() {
		return commentaires;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", isActif=" + isActif + ", profil=" + profil + ", email=" + email + ", password="
				+ Arrays.toString(password) + ", telephone=" + telephone + ", adresseFacturationId="
				+ adresseFacturationId + ", adresseLivraisonId=" + adresseLivraisonId + ", cartePaiementId="
				+ cartePaiementId + ", cleCryptage=" + Arrays.toString(cleCryptage) + ", adresses=" + adresses
				+ ", commandes=" + commandes + ", cartesPaiement=" + cartesPaiement + ", commentaires=" + commentaires
				+ ", panier=" + panier + "]";
	}


}
