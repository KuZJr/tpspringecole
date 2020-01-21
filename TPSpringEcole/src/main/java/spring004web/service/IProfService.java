package spring004web.service;

import java.util.Date;
import java.util.List;

import spring004web.bean.Prof;
import spring004web.enums.Sexe;

public interface IProfService {
	List<Prof> rechercherProfs();
	Prof rechercherProfId(final Integer pId);
	void creerProf(final String pNom, final String pPrenom, final Date pDateNaissance, final String pAdresse, final Sexe pSexe);
	void supprimerProf(final Prof pProf);
	void modifierProf(final Prof pProf);
}
