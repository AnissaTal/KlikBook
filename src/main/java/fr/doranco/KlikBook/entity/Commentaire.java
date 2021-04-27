package fr.doranco.KlikBook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "commentaire")
public class Commentaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "texte", nullable = true)
	private String texte;
	
	@NotNull
	@Column(name = "note", nullable = true)
	private Integer note;
	
	@ManyToOne
	@JoinColumn(name="livre_id",nullable=false)
	private Livre livre;

	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private User user;

	public Commentaire() {
		livre = new Livre();
		user= new User();
	}

	
	public Commentaire(@NotNull String texte, @NotNull Integer note, Livre livre, User user) {
		this.texte = texte;
		this.note = note;
		livre = new Livre();
		user= new User();
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTexte() {
		return texte;
	}


	public void setTexte(String texte) {
		this.texte = texte;
	}


	public Integer getNote() {
		return note;
	}


	public void setNote(Integer note) {
		this.note = note;
	}


	public Livre getLivre() {
		return livre;
	}


	public User getUser() {
		return user;
	}


	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", texte=" + texte + ", note=" + note + ", livre=" + livre + ", user=" + user
				+ "]";
	}


	
	
	
}
