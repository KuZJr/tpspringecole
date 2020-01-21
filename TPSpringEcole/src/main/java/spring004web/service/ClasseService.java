package spring004web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring004web.bean.Classe;
import spring004web.bean.Prof;
import spring004web.dao.IClasseDAO;

@Service
public class ClasseService implements IClasseService {
	@Autowired
	IClasseDAO dao;
	
	@Transactional(readOnly = true)
	public List<Classe> rechercherClasses() {
		return dao.rechercherClasses();
	}

	@Transactional
	public Classe rechercherClasseId(Integer pId) {
		return dao.rechercherClasseId(pId);
	}

	@Transactional
	public void creerClasse(String pNom, Prof pProf) {
		final Classe classe = new Classe();
		classe.setNom(pNom);
		classe.setProf(pProf);
		dao.creerClasse(classe);
	}

	@Transactional
	public void supprimerClasse(Classe pClasse) {
		dao.supprimerClasse(pClasse);		
	}

	@Transactional
	public void modifierClasse(Classe pClasse) {
		dao.modifierClasse(pClasse);
	}

}
