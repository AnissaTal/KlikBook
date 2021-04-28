package fr.doranco.KlikBook.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categorie")
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "remise", nullable = false)
	private Integer remise;
	
	@NotNull
	@Column(name = "nom", nullable = false)
	private String nom;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Livre> livres;

	
	public Categorie() {
		livres = new ArrayList<Livre>();
	}

	public Categorie(@NotNull Integer remise, @NotNull String nom, List<Livre> livres) {
		super();
		this.remise = remise;
		this.nom = nom;
		livres = new ArrayList<Livre>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRemise() {
		return remise;
	}

	public void setRemise(Integer remise) {
		this.remise = remise;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", remise=" + remise + ", nom=" + nom + ", livres=" + livres + "]";
	}


	
	
	
}
