package com.springboot.controller;

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

import com.springboot.bean.Matiere;
import com.springboot.controller.form.MatiereForm;
import com.springboot.service.iServiceMatiere;

@Controller
public class MatiereController {
	@Autowired
	iServiceMatiere servicematiere;
	
	private Matiere convertForm(MatiereForm matiereform) {
		Matiere pmatiere = new Matiere();
		pmatiere.setId(matiereform.getId());
		pmatiere.setNom(matiereform.getNom());
		return pmatiere;
	}
	
	@GetMapping("/afficherCreerMatiere")
	public String getAffiche(Model pmodel) {
		List<Matiere> lmatieres = servicematiere.rechercheMatiere();
		lmatieres = servicematiere.rechercheMatiere();
		pmodel.addAttribute("listematieres", lmatieres);
		pmodel.addAttribute("action", "CreerMatiere");
		if(pmodel.containsAttribute("matiereform") == false) {
			MatiereForm matiereform = new MatiereForm();
			matiereform.setId(0);
			pmodel.addAttribute("matiereform",matiereform);
		}		
		return "matieres";
	}
	
	@PostMapping("/CreerMatiere")
	public String ajoutMatiere( 
			@Valid @ModelAttribute(name = "matiereform") MatiereForm matiereform,
			BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Matiere pmatiere = convertForm(matiereform);
				servicematiere.creerMatiere(pmatiere);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
	
	@GetMapping("/SupprimerMatiere/{id}")
	public String getSupprimer(@PathVariable final Integer id,Model pmodel) {
		Matiere pmatiere = servicematiere.rechercheMatiereId(id);
		if(pmatiere != null) {
			servicematiere.supprimerMatiere(pmatiere);;
		}
		return this.getAffiche(pmodel);
	}
	
	@GetMapping("/afficherModifierMatiere/{id}")
	public String getAfficheMod(@PathVariable final Integer id,Model pmodel) {
		Matiere pmatiere = servicematiere.rechercheMatiereId(id);
		pmodel.addAttribute("listematieres", null);
		pmodel.addAttribute("action", "ModifierMatiere");
		if(pmodel.containsAttribute("matiereform") == false) {
			MatiereForm matiereform = new MatiereForm();
			matiereform.setId(pmatiere.getId());
			matiereform.setNom(pmatiere.getNom());
			
			pmodel.addAttribute("matiereform", matiereform);
		}
		return "matieres";
	}
	
	@PostMapping("/ModifierMatiere")
	public String modifieMatiere(@Valid @ModelAttribute(name = "classeform") MatiereForm matiereform, BindingResult presult, Model pmodel) {
		if(!presult.hasErrors()) {
			try
			{
				Matiere pmatiere = convertForm(matiereform);
				servicematiere.creerMatiere(pmatiere);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
}
