package com.springboot.controller.form;

import javax.validation.constraints.NotEmpty;

public class NoteForm {
	private Integer id;
	private Integer ideleve;
	private Integer idclasse;
	private Integer idmatiere;
	private Integer idprof;
	private Integer idtrimestre;
	
	@NotEmpty
	private String date_saisie;
	
	private Integer note;
	
	@NotEmpty
	private String avis;
	
	private Float avancement;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdeleve() {
		return ideleve;
	}

	public void setIdeleve(Integer ideleve) {
		this.ideleve = ideleve;
	}

	public Integer getIdclasse() {
		return idclasse;
	}

	public void setIdclasse(Integer idclasse) {
		this.idclasse = idclasse;
	}

	public Integer getIdmatiere() {
		return idmatiere;
	}

	public void setIdmatiere(Integer idmatiere) {
		this.idmatiere = idmatiere;
	}

	public Integer getIdprof() {
		return idprof;
	}

	public void setIdprof(Integer idprof) {
		this.idprof = idprof;
	}

	public Integer getIdtrimestre() {
		return idtrimestre;
	}

	public void setIdtrimestre(Integer idtrimestre) {
		this.idtrimestre = idtrimestre;
	}

	public String getDate_saisie() {
		return date_saisie;
	}

	public void setDate_saisie(String date_saisie) {
		this.date_saisie = date_saisie;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public Float getAvancement() {
		return avancement;
	}

	public void setAvancement(Float avancement) {
		this.avancement = avancement;
	}
	
	
}
