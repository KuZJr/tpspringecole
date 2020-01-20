package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.bean.Trimestre;
import com.springboot.dao.DaoTrimestre;

@Service
public class ServiceTrimestre implements iServiceTrimestre {
	@Autowired
	DaoTrimestre dao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Trimestre> rechercheTrimestre() {
		return dao.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Trimestre rechercheTrimestreId(int id) {
		return dao.findById(id).get();
	}
	
	@Transactional
	@Override
	public void creerTrimestre(Trimestre pTrimestre) {
		dao.save(pTrimestre);
	}
	
	@Transactional
	@Override
	public void modifierTrimestre(Trimestre pTrimestre) {
		dao.save(pTrimestre);
	}
	
	@Transactional
	@Override
	public void supprimerTrimestre(Trimestre pTrimestre) {
		dao.deleteById(pTrimestre.getId());
	}

}
