package fr.doranco.KlikBook.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "ligne_de_commande")
public class LigneDeCommande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "quantite", nullable = false)
	private Integer quantite;

	@NotNull
	@Column(name = "prix_unitaire", nullable = false)
	private float prixUnitaire;
	
	@NotNull
	@Column(name = "remise_article", nullable = false)
	private Integer remiseArticle;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "livre_id", nullable = false)
	private Livre livre;
	
	@ManyToOne
	@JoinColumn(name="commande_id",nullable=false)
	private Commande commande;
	
	
	public LigneDeCommande() {
		livre = new Livre();
		commande = new Commande();
	}

	
	public LigneDeCommande(Integer id, @NotNull Integer quantite, @NotNull float prixUnitaire,
			@NotNull Integer remiseArticle, Livre livre, Commande commande) {
		this.id = id;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.remiseArticle = remiseArticle;
		livre = new Livre();
		commande = new Commande();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getQuantite() {
		return quantite;
	}


	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}


	public float getPrixUnitaire() {
		return prixUnitaire;
	}


	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}


	public Integer getRemiseArticle() {
		return remiseArticle;
	}


	public void setRemiseArticle(Integer remiseArticle) {
		this.remiseArticle = remiseArticle;
	}


	public Livre getLivre() {
		return livre;
	}


	public Commande getCommande() {
		return commande;
	}



	
	

}
