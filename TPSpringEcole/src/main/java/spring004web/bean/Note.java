package spring004web.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_notes")
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idnotes")
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_saisie", nullable = false)
	private Date date_saisie;
	
	@ManyToOne
	@JoinColumn(name = "ideleve", nullable = false)
	private Eleve ideleve;
	
	@ManyToOne
	@JoinColumn(name = "idclasse", nullable = false)
	private Classe idclasse;
	
	@ManyToOne
	@JoinColumn(name = "idmatiere", nullable = false)
	private Matiere idmatiere;
	
	@ManyToOne
	@JoinColumn(name = "idprof", nullable = false)
	private Prof idprof;
	
	@ManyToOne
	@JoinColumn(name = "idtrimestre", nullable = false)
	private Trimestre idtrimestre;
	
	@Column(name = "note", nullable = false)
	private Integer note;
	
	@Column(name = "avis", length = 500, nullable = false)
	private String avis;
	
	@Column(name = "avancement", nullable = false)
	private Float avancement;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate_saisie() {
		return date_saisie;
	}
	public void setDate_saisie(Date date_saisie) {
		this.date_saisie = date_saisie;
	}
	public Eleve getIdeleve() {
		return ideleve;
	}
	public void setIdeleve(Eleve ideleve) {
		this.ideleve = ideleve;
	}
	public Classe getIdclasse() {
		return idclasse;
	}
	public void setIdclasse(Classe idclasse) {
		this.idclasse = idclasse;
	}
	public Matiere getIdmatiere() {
		return idmatiere;
	}
	public void setIdmatiere(Matiere idmatiere) {
		this.idmatiere = idmatiere;
	}
	public Prof getIdprof() {
		return idprof;
	}
	public void setIdprof(Prof idprof) {
		this.idprof = idprof;
	}
	public Trimestre getIdtrimestre() {
		return idtrimestre;
	}
	public void setIdtrimestre(Trimestre idtrimestre) {
		this.idtrimestre = idtrimestre;
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
