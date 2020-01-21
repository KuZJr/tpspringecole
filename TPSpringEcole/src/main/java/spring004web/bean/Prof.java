package spring004web.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import spring004web.enums.Sexe;

@Entity
@Table(name = "t_prof")
public class Prof {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom", length = 100, nullable = false)
	private String nom;
	
	@Column(name = "prenom", length = 100, nullable = true)
	private String prenom;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_naissance", nullable = false)
	private Date date_naissance;
	
	@Column(name = "adresse", length = 250, nullable = true)
	private String adresse;
	
	@Column(name = "sexe", nullable = false, columnDefinition = "enum('HOMME','FEMME')")
	@Enumerated(EnumType.STRING)
	private Sexe sexe;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Sexe getSexe() {
		return sexe;
	}
	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}
	
	
}
