package com.springboot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.bean.Classe;
import com.springboot.bean.Eleve;
import com.springboot.bean.Matiere;
import com.springboot.bean.Note;
import com.springboot.bean.Professeur;
import com.springboot.bean.Trimestre;
import com.springboot.controller.form.NoteForm;
import com.springboot.service.iServiceClasse;
import com.springboot.service.iServiceEleve;
import com.springboot.service.iServiceMatiere;
import com.springboot.service.iServiceNote;
import com.springboot.service.iServiceProfesseur;
import com.springboot.service.iServiceTrimestre;

@Controller
public class NoteController {
	@Autowired
	iServiceNote servicenote;
	@Autowired
	iServiceEleve serviceeleve;
	@Autowired
	iServiceClasse serviceclasse;
	@Autowired
	iServiceMatiere servicematiere;
	@Autowired
	iServiceProfesseur serviceprofesseur;
	@Autowired
	iServiceTrimestre servicetrimestre;
	
	private Note convertForm(NoteForm noteform) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date madate = null;
		try {
			madate = sdf.parse(noteform.getDate_saisie());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Note pnote = new Note();
		pnote.setId(noteform.getId());
		pnote.setDate_saisie(madate);
		Eleve peleve = serviceeleve.rechercheEleveId(noteform.getIdeleve());
		pnote.setIdeleve(peleve);
		Classe pclasse = serviceclasse.rechercheClasseId(noteform.getIdclasse());
		pnote.setIdclasse(pclasse);
		Matiere pmatiere = servicematiere.rechercheMatiereId(noteform.getIdmatiere());
		pnote.setIdmatiere(pmatiere);
		Professeur pprof = serviceprofesseur.rechercheProfId(noteform.getIdprof());
		pnote.setIdprof(pprof);
		Trimestre ptrimestre = servicetrimestre.rechercheTrimestreId(noteform.getIdtrimestre());
		pnote.setIdtrimestre(ptrimestre);
		pnote.setNote(noteform.getNote());
		pnote.setAvis(noteform.getAvis());
		pnote.setAvancement(noteform.getAvancement());
		return pnote;
	}
	
	@GetMapping("/afficherCreerNote")
	public String getAffiche(Model pmodel) {
		List<Note> lnotes = servicenote.rechercheNote();
		List<Eleve> leleves = serviceeleve.rechercheEleve();
		List<Classe> lclasses = serviceclasse.rechercheClasse();
		List<Matiere> lmatieres = servicematiere.rechercheMatiere();
		List<Professeur> lprofs = serviceprofesseur.rechercheProf();
		List<Trimestre> ltrimestres = servicetrimestre.rechercheTrimestre();
		lnotes = servicenote.rechercheNote();
		pmodel.addAttribute("listenotes", lnotes);
		pmodel.addAttribute("listeeleves", leleves);
		pmodel.addAttribute("listeclasses", lclasses);
		pmodel.addAttribute("listematieres", lmatieres);
		pmodel.addAttribute("listeprofs", lprofs);
		pmodel.addAttribute("listetrimestres", ltrimestres);
		pmodel.addAttribute("action", "CreerNote");
		if(pmodel.containsAttribute("noteform") == false) {
			NoteForm noteform = new NoteForm();
			noteform.setId(0);
			pmodel.addAttribute("noteform",noteform);
		}		
		return "notes";
	}
	
	@PostMapping("/CreerNote")
	public String ajoutNote( 
			@Valid @ModelAttribute(name = "noteform") NoteForm noteform,
			BindingResult presult,
			Model pmodel)
	{
		System.err.println(presult);
		if(!presult.hasErrors()) {
			try
			{
				Note pnote = convertForm(noteform);
				servicenote.creerNote(pnote);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
	
	@GetMapping("/SupprimerNote/{id}")
	public String getSupprimer(@PathVariable final Integer id,Model pmodel) {
		Note pnote = servicenote.rechercheNoteId(id);
		if(pnote != null) {
			servicenote.supprimerNote(pnote);;
		}
		return this.getAffiche(pmodel);
	}
	
	@GetMapping("/afficherModifierNote/{id}")
	public String getAfficheMod(@PathVariable final Integer id,Model pmodel) {
		Note pnote = servicenote.rechercheNoteId(id);
		List<Eleve> leleves = serviceeleve.rechercheEleve();
		List<Classe> lclasses = serviceclasse.rechercheClasse();
		List<Matiere> lmatieres = servicematiere.rechercheMatiere();
		List<Professeur> lprofs = serviceprofesseur.rechercheProf();
		List<Trimestre> ltrimestres = servicetrimestre.rechercheTrimestre();
		pmodel.addAttribute("listeeleves", leleves);
		pmodel.addAttribute("listeclasses", lclasses);
		pmodel.addAttribute("listematieres", lmatieres);
		pmodel.addAttribute("listeprofs", lprofs);
		pmodel.addAttribute("listetrimestres", ltrimestres);
		pmodel.addAttribute("listenotes", null);
		pmodel.addAttribute("action", "ModifierNote");
		if(pmodel.containsAttribute("noteform") == false) {
			NoteForm noteform = new NoteForm();
			noteform.setId(pnote.getId());
			noteform.setDate_saisie(new SimpleDateFormat("yyyy-MM-dd").format(pnote.getDate_saisie()));
			noteform.setIdeleve(Integer.valueOf(pnote.getIdeleve().getId()));
			noteform.setIdclasse(Integer.valueOf(pnote.getIdclasse().getId()));
			noteform.setIdmatiere(Integer.valueOf(pnote.getIdmatiere().getId()));
			noteform.setIdprof(Integer.valueOf(pnote.getIdprof().getId()));
			noteform.setIdtrimestre(Integer.valueOf(pnote.getIdtrimestre().getId()));
			noteform.setNote(Integer.valueOf(pnote.getNote()));
			noteform.setAvis(pnote.getAvis());
			noteform.setAvancement(Float.valueOf(pnote.getAvancement()));
			pmodel.addAttribute("noteform", noteform);
		}
		return "notes";
	}
	
	@PostMapping("/ModifierNote")
	public String modifieNote(@Valid @ModelAttribute(name = "Noteform") NoteForm noteform, BindingResult presult, Model pmodel) {
		if(!presult.hasErrors()) {
			try
			{
				Note pnote = convertForm(noteform);
				servicenote.creerNote(pnote);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
}
