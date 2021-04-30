package fr.doranco.KlikBook.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.KlikBook.Dto.AdresseDto;
import fr.doranco.KlikBook.control.AdresseMetier;
import fr.doranco.KlikBook.control.IAdresseMetier;

@ManagedBean(name= "adresseBean")
public class AdresseBean implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private final IAdresseMetier adresseMetier = new AdresseMetier(); 
	
	
	@ManagedProperty(name ="idAdresse" , value=" ")
	private String idAdresse;
	@ManagedProperty(name ="numero" , value=" ")
	private String numero;
	@ManagedProperty(name ="rue" , value=" ")
	private String rue;
	@ManagedProperty(name ="ville" , value=" ")
	private String ville;
	@ManagedProperty(name ="codePostale" , value=" ")
	private String codePostale;
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private static String messageSuccess;

	@ManagedProperty(name = "messageError", value = "")
	private static String messageError;

	@ManagedProperty(name = "currentAdresseId", value = "")
	private String currentAdresseId;
	

	static {
		messageSuccess = "";
		messageError = "";
	}
	
	public AdresseBean() {
		
	}
	
	public String addAdresse() {
		
		AdresseDto adresseDto = new AdresseDto();
		adresseDto.setNumero(numero);
		adresseDto.setRue(rue);
		adresseDto.setVille(ville);
		adresseDto.setCodePostal(codePostale);
		
		try {
			adresseMetier.addAdresse(adresseDto);;
			messageSuccess = "l'adresse est ajoutée  avec succès !";
		} catch (Exception e) {
			System.out.println(e);
			messageError = "Erreur lors de l'ajout de l'adresse !\n" + e.getMessage();
		}
		return "";
		
	}
	
	
	
	
}
