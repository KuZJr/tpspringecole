package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.bean.Matiere;
import com.springboot.dao.DaoMatiere;

@Service
public class ServiceMatiere implements iServiceMatiere {
	@Autowired
	DaoMatiere dao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Matiere> rechercheMatiere() {
		return dao.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Matiere rechercheMatiereId(int id) {
		return dao.findById(id).get();
	}
	
	@Transactional
	@Override
	public void creerMatiere(Matiere pMatiere) {
		dao.save(pMatiere);
	}
	
	@Transactional
	@Override
	public void modifierMatiere(Matiere pMatiere) {
		dao.save(pMatiere);
	}
	
	@Transactional
	@Override
	public void supprimerMatiere(Matiere pMatiere) {
		dao.deleteById(pMatiere.getId());
	}

}
