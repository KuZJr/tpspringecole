package spring004web.dao;

import java.util.List;

import spring004web.bean.Prof;

public interface IProfDAO {
	List<Prof> rechercherProfs();
	Prof rechercherProfId(final Integer pId);
	void creerProf(final Prof pProf);
	void supprimerProf(final Prof pProf);
	void modifierProf(final Prof pProf);
}
