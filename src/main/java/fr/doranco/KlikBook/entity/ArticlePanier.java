package fr.doranco.KlikBook.entity;

import java.io.Serializable;
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
@Table(name = "article_panier")
public class ArticlePanier implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Integer id;
	
	@NotNull
	@Column(name = "quantite", nullable = false)
	private Integer quantite;
	
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "livre")
	@Column(name = "livre_id", nullable = false)
	private Livre livre;
	
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private User user;

	
	public ArticlePanier() {

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


	public Livre getLivre() {
		return livre;
	}


	public User getUser() {
		return user;
	}


	@Override
	public String toString() {
		return "ArticlePanier [id=" + id + ", livre=" + livre + ", quantite=" + quantite + ", user=" + user + "]";
	}
	
	
	
	

}
