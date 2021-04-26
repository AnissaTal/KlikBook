package fr.doranco.jsf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;


@Entity
@Table(name = "lignedecommande")
public class LigneDeCommande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "quantite", nullable = false)
	private Integer quantite;

	@NotNull
	@Column(name = "prix", nullable = false)
	private float prix;

	@NotNull
	@Column(name = "article", nullable = false)
	private String article;
	
	@ManyToOne
	@JoinColumn(name="commande_id",nullable=false)
	private Commande commande;
	
	
	public LigneDeCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Commande getCommande() {
		return commande;
	}



	public void setCommande(Commande commande) {
		this.commande = commande;
	}



	public LigneDeCommande(Integer quantite, float prix, String article, Commande commande) {
		super();
		this.quantite = quantite;
		this.prix = prix;
		this.article = article;
		this.commande = commande;
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

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	
	

}
