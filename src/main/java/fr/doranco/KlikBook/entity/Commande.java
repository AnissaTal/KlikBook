package fr.doranco.KlikBook.entity;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "commande")
@NamedQueries({
	@NamedQuery(name = "Commande.findAll", query = "FROM User u"),
	@NamedQuery(name = "Commande.findByUser", query = "FROM User u WHERE u.nom = :nom"),
	@NamedQuery(name = "Commande.findByVille", query = "SELECT u FROM User u JOIN u.adresses a ON a.ville = :ville")	
})
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "numero", length = 10, nullable = false)
	private Integer numero;
	
	@NotNull
	@Column(name = "date_creation", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	
	@NotNull
	@Column(name = "date_livraison", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateLivraison;
	
	@NotNull
	@Column(name = "total_remise", length = 10, nullable = false)
	private float totalRemise;
	
	@NotNull
	@Column(name = "total_general", length = 10, nullable = false)
	private float totalGeneral;
	
	@NotNull
	@Column(name = "frais_expedition", length = 10, nullable = false)
	private float FraisExpedition;
	
	@OneToMany
	(cascade=CascadeType.ALL,mappedBy= "commande",fetch = FetchType.LAZY)
	private List<LigneDeCommande> ligneDeCommande;
	
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	
	public Commande() {
		ligneDeCommande = new ArrayList<LigneDeCommande>();
		user = new User();
	}


	public Commande( @NotNull Integer numero, @NotNull Date dateCreation, @NotNull Date dateLivraison,
			@NotNull float totalGeneral, User user) {
		
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.dateLivraison = dateLivraison;
		this.totalGeneral = totalGeneral;
		ligneDeCommande = new ArrayList<LigneDeCommande>();
	     user = new User();
	}

	
	
    public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public Date getDateLivraison() {
		return dateLivraison;
	}


	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}


	public float getTotalRemise() {
		return totalRemise;
	}


	public void setTotalRemise(float totalRemise) {
		this.totalRemise = totalRemise;
	}


	public float getTotalGeneral() {
		return totalGeneral;
	}


	public void setTotalGeneral(float totalGeneral) {
		this.totalGeneral = totalGeneral;
	}


	public float getFraisExpedition() {
		return FraisExpedition;
	}


	public void setFraisExpedition(float fraisExpedition) {
		FraisExpedition = fraisExpedition;
	}


	public List<LigneDeCommande> getLigneDeCommande() {
		return ligneDeCommande;
	}


	public User getUser() {
		return user;
	}


	@Override
	public String toString() {
		return "Commande [id=" + id + ", numero=" + numero + ", dateCreation=" + dateCreation + ", dateLivraison="
				+ dateLivraison + ", totalRemise=" + totalRemise + ", totalGeneral=" + totalGeneral
				+ ", FraisExpedition=" + FraisExpedition + ", ligneDeCommande=" + ligneDeCommande + ", user=" + user
				+ "]";
	}


}
