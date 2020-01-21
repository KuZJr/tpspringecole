package spring004web.service;

import java.util.List;

import spring004web.bean.Classe;
import spring004web.bean.Prof;

public interface IClasseService {
	List<Classe> rechercherClasses();
	Classe rechercherClasseId(final Integer pId);
	void creerClasse(final String pNom, final Prof pProf);
	void supprimerClasse(final Classe pClasse);
	void modifierClasse(final Classe pClasse);
}
