package spring004web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring004web.bean.Classe;
import spring004web.bean.Prof;
import spring004web.enums.Sexe;
import spring004web.service.IClasseService;
import spring004web.service.IProfService;

@Controller
public class ClasseController {
	@Autowired
	IClasseService serviceClasse;
	@Autowired
	IProfService serviceProf;
	
	@RequestMapping(value = "/afficherClasses", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		final List<Classe> lListeClasses = serviceClasse.rechercherClasses();
		pModel.addAttribute("listeClasses", lListeClasses);
		if (pModel.get("creationClasse") == null) {
			pModel.addAttribute("creationClasse", new CreationClasseForm());
			List<Prof> lProfs = serviceProf.rechercherProfs();
			pModel.addAttribute("listeProfs", lProfs);
		}
		return "creationClasse";
	}
	
	@RequestMapping(value = "/creerClasse", method = RequestMethod.POST)
	public String creer(@Valid @ModelAttribute(value = "creation") final CreationClasseForm pCreation,
			final BindingResult pBindingResult, final ModelMap pModel) {
		if (!pBindingResult.hasErrors()) {
			Prof pProf = serviceProf.rechercherProfId(pCreation.getId_prof());
			serviceClasse.creerClasse(pCreation.getNom(), pProf);
		}
		return afficher(pModel);
	}
	
	@RequestMapping(value = "/supprimerClasse", method = RequestMethod.GET)
	public String supprimer(@RequestParam(value = "idClasse") final Integer pId, final ModelMap pModel) {
		Classe classe = serviceClasse.rechercherClasseId(pId);
		serviceClasse.supprimerClasse(classe);
		return afficher(pModel);
	}
	
	@RequestMapping(value = "/modifierClasse", method = RequestMethod.GET)
	public String modifier(@RequestParam(value = "idClasse") final Integer pId, final ModelMap pModel) {
		Classe classe = serviceClasse.rechercherClasseId(pId);
		CreationClasseForm cForm = new CreationClasseForm();
		cForm.setId(pId);
		cForm.setNom(classe.getNom());
		serviceProf.rechercherProfId(classe.getProf().getId());
		pModel.addAttribute("modificationClasse", cForm);
		List<Prof> lProfs = serviceProf.rechercherProfs();
		pModel.addAttribute("listeProfs", lProfs);
		return "modificationClasse";
	}
	
	@RequestMapping(value = "/modifierClasseForm", method = RequestMethod.POST)
	public String modifier(@Valid @ModelAttribute(value = "modificationClasse") final CreationClasseForm pCreation,
			final BindingResult pBindingResult, final ModelMap pModel) {
		System.err.println(pBindingResult);
		if (!pBindingResult.hasErrors()) {
			Classe classe = new Classe();
			classe.setId(pCreation.getId());
			classe.setNom(pCreation.getNom());
			Prof prof = serviceProf.rechercherProfId(pCreation.getId_prof());
			classe.setProf(prof);
			serviceClasse.modifierClasse(classe);
		}
		return afficher(pModel);
	}

}