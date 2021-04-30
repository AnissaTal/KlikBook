package fr.doranco.KlikBook.Dto;

import fr.doranco.KlikBook.control.AdresseMetier;
import fr.doranco.KlikBook.control.IAdresseMetier;


public class AdresseDto {

	IAdresseMetier  adresseMetier= new AdresseMetier();
	
	private String numero;
	private String rue;
	private String ville;
	private String codePostal;

	public AdresseDto() {
	}

	public AdresseDto(String numero, String rue, String ville, String codePostal) {
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	
	


	
}
