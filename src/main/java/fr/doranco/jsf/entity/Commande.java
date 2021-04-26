package fr.doranco.jsf.entity;

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
	@Column(name = "total_general", length = 10, nullable = false)
	private float totalGeneral;
	
	
	@OneToMany
	(cascade=CascadeType.ALL,mappedBy= "commande",fetch = FetchType.LAZY)
	private List<LigneDeCommande> ligneDeCommande;
	
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	
	public Commande() {
		ligneDeCommande = new ArrayList<LigneDeCommande>();
	}


	


	public User getUser() {
		return user;
	}





	public void setUser(User user) {
		this.user = user;
	}





	public Commande( @NotNull Integer numero, @NotNull Date dateCreation, @NotNull Date dateLivraison,
			@NotNull float totalGeneral, User user) {
		
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.dateLivraison = dateLivraison;
		this.totalGeneral = totalGeneral;
		ligneDeCommande = new ArrayList<LigneDeCommande>();
		this.user = user;
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


	public float getTotalGeneral() {
		return totalGeneral;
	}


	public void setTotalGeneral(float totalGeneral) {
		this.totalGeneral = totalGeneral;
	}


	public List<LigneDeCommande> getLigneDeCommande() {
		return ligneDeCommande;
	}


	public void setLigneDeCommande(List<LigneDeCommande> ligneDeCommande) {
		this.ligneDeCommande = ligneDeCommande;
	}


	@Override
	public String toString() {
		return "Commande [id=" + id + ", numero=" + numero + ", dateCreation=" + dateCreation + ", dateLivraison="
				+ dateLivraison + ", totalGeneral=" + totalGeneral + ", ligneDeCommande=" + ligneDeCommande + "]";
	}

}
