package fr.doranco.KlikBook.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "adresse")
@NamedQueries({
	@NamedQuery(name = "Adresse.findAll", query = "FROM Adresse a"),
	//@NamedQuery(name = "Adresse.findByuserId", query = "SELECT a FROM Adresse a JOIN a.users u ON u.userId = :userId")	
})

public class Adresse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "numero", nullable = false)
	private Integer numero;

	@NotEmpty
	@Column(name = "rue", length = 45, nullable = false)
	private String rue;

	@NotEmpty
	@Column(name = "ville", length = 25, nullable = false)
	private String ville;

	@NotEmpty
	@Column(name = "code_postal", length = 5, nullable = false)
	private String codePostal;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Adresse() {

	}

	public Adresse(@NotNull Integer numero, String rue, String ville, String codePostal) {
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
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

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public User getUser() {
		return user;
	}

	
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", numero=" + numero + ", rue=" + rue + ", codePostal=" + codePostal + ", ville="
				+ ville + "]";
	}

	
}
