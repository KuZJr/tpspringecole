package spring004web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring004web.bean.Prof;
import spring004web.dao.IProfDAO;
import spring004web.enums.Sexe;

@Service
public class ProfService implements IProfService {
	@Autowired
	private IProfDAO dao;
	
	@Transactional(readOnly = true)
	public List<Prof> rechercherProfs() {
		return dao.rechercherProfs();
	}
	
	@Transactional
	public void creerProf(final String pNom, final String pPrenom, final Date pDateNaissance, final String pAdresse, final Sexe pSexe) {
		final Prof pProf = new Prof();
		pProf.setNom(pNom);
		pProf.setPrenom(pPrenom);
		pProf.setDate_naissance(pDateNaissance);
		pProf.setAdresse(pAdresse);
		pProf.setSexe(pSexe);
		
		dao.creerProf(pProf);
	}
	
	@Transactional
	public void supprimerProf(final Prof pProf) {
		dao.supprimerProf(pProf);
	}
	
	@Transactional
	public void modifierProf(Prof pProf) {
		dao.modifierProf(pProf);
	}
	
	@Transactional
	public Prof rechercherProfId(Integer pId) {
		return dao.rechercherProfId(pId);
	}

}
