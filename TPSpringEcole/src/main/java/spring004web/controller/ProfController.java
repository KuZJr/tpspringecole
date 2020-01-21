package spring004web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring004web.bean.Prof;
import spring004web.enums.Sexe;
import spring004web.service.IProfService;

@Controller
public class ProfController {
	@Autowired
	private IProfService service;

	@RequestMapping(value = "/afficherProfs", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		final List<Prof> lListeProfs = service.rechercherProfs();
		pModel.addAttribute("listeProfs", lListeProfs);
		if (pModel.get("creationProf") == null) {
			pModel.addAttribute("creationProf", new CreationProfForm());
			
		}
		return "creationProf";
	}

	@RequestMapping(value = "/creerProf", method = RequestMethod.POST)
	public String creer(@Valid @ModelAttribute(value = "creation") final CreationProfForm pCreation,
			final BindingResult pBindingResult, final ModelMap pModel) {
		if (!pBindingResult.hasErrors()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date madate = null;
			try {
				madate = sdf.parse(pCreation.getDate_naissance());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			service.creerProf(pCreation.getNom(), pCreation.getPrenom(), madate, pCreation.getAdresse(), Sexe.valueOf(pCreation.getSexe()));
		}
		return afficher(pModel);
	}
	
	@RequestMapping(value = "/supprimerProf", method = RequestMethod.GET)
	public String supprimer(@RequestParam(value = "idProf") final Integer pId, final ModelMap pModel) {
		Prof prof = service.rechercherProfId(pId);
		service.supprimerProf(prof);
		return afficher(pModel);
	}
	
	@RequestMapping(value = "/modifierProf", method = RequestMethod.GET)
	public String modifier(@RequestParam(value = "idProf") final Integer pId, final ModelMap pModel) {
		Prof prof = service.rechercherProfId(pId);
		CreationProfForm cForm = new CreationProfForm();
		cForm.setId(pId);
		cForm.setNom(prof.getNom());
		cForm.setPrenom(prof.getPrenom());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String madate = sdf.format(prof.getDate_naissance());
		cForm.setDate_naissance(madate);
		cForm.setAdresse(prof.getAdresse());
		cForm.setSexe(prof.getSexe().name());
		pModel.addAttribute("modification", cForm);
		return "modificationProf";
	}
	
	@RequestMapping(value = "/modifierProfForm", method = RequestMethod.POST)
	public String modifier(@Valid @ModelAttribute(value = "modification") final CreationProfForm pCreation,
			final BindingResult pBindingResult, final ModelMap pModel) {
		System.err.println(pBindingResult);
		if (!pBindingResult.hasErrors()) {
			Prof prof = new Prof();
			prof.setId(pCreation.getId());
			prof.setNom(pCreation.getNom());
			prof.setPrenom(pCreation.getPrenom());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date madate = null;
			try {
				madate = sdf.parse(pCreation.getDate_naissance());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			prof.setDate_naissance(madate);
			prof.setAdresse(pCreation.getAdresse());
			prof.setSexe(Sexe.valueOf(pCreation.getSexe()));
			service.modifierProf(prof);
		}
		return afficher(pModel);
	}
}
