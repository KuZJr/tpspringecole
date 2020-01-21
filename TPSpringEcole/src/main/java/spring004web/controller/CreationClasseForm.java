package spring004web.controller;

import org.hibernate.validator.constraints.NotEmpty;

public class CreationClasseForm {
	private Integer id;
	private Integer id_prof;
	
	@NotEmpty
	private String nom;
	
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

	public Integer getId_prof() {
		return id_prof;
	}

	public void setId_prof(Integer id_prof) {
		this.id_prof = id_prof;
	}

}
