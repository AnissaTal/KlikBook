package fr.doranco.KlikBook.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "livre")
@NamedQueries({ @NamedQuery(name = "Livre.findAll", query = "FROM Livre l")
	//	@NamedQuery(name = "Livre.findByCategorie", query = "SELECT l FROM Livre l JOIN l.categorie l ON l.nom=:nom"),
	//	@NamedQuery(name = "Livre.findByAuthor", query = "SELECT l FROM Livre l JOIN l.auteur a ON "),
		//@NamedQuery(name = "Livre.findByAnnee", query = "SELECT l FROM Livre l JOIN l.auteur a ON ")
})
public class Livre implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotEmpty
	@Column(name = "titre", length = 45, nullable = false)
	private String titre;

	@NotEmpty
	@Column(name = "auteur", length = 45, nullable = false)
	private String auteur;

	@NotNull
	@Column(name = "annee", length = 4,nullable = false)
	private Integer annee;

	@NotNull
	@Column(name = "prix", nullable = false)
	private float prix;

	@NotNull
	@Column(name = "remise", nullable = false)
	private Integer remise;

	@NotNull
	@Column(name = "stock", length = 100, nullable = false)
	private Integer stock;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "livre", fetch = FetchType.LAZY)
	//@JoinColumn(name = "commentaire_id", nullable = false)
	private List<Commentaire> commentaires;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categorie_id", nullable = false)
	private Categorie categorie;

	public Livre() {
		commentaires = new ArrayList<Commentaire>();
		categorie = new Categorie();
	}

	public Livre(String titre, String auteur, Integer annee, float prix, Integer remise, Integer stock) {
		this.titre = titre;
		this.auteur = auteur;
		this.annee = annee;
		this.prix = prix;
		this.remise = remise;
		this.stock = stock;

		commentaires = new ArrayList<Commentaire>();
		categorie = new Categorie();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Integer getAnnee() {
		return annee;
	}

	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Integer getRemise() {
		return remise;
	}

	public void setRemise(Integer remise) {
		this.remise = remise;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", annee=" + annee + ", prix=" + prix
				+ ", remise=" + remise + ", stock=" + stock + ", commentaires=" + commentaires + ", categorie="
				+ categorie + "]";
	}

}
