package spring004web.dao;

import java.util.List;

import spring004web.bean.Classe;

public interface IClasseDAO {
	List<Classe> rechercherClasses();
	Classe rechercherClasseId(final Integer pId);
	void creerClasse(final Classe pClasse);
	void supprimerClasse(final Classe pClasse);
	void modifierClasse(final Classe pClasse);
}
