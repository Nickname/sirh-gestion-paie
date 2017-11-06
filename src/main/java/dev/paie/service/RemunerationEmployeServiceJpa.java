package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.RemunerationEmployeRepository;

@Repository
@Transactional
public class RemunerationEmployeServiceJpa implements RemunerationEmployeService {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired RemunerationEmployeRepository repo;
	
	@Override
	@Transactional
	public void sauvegarder(RemunerationEmploye remEmploye) {
		em.persist(remEmploye);
	}

	@Override
	public void mettreAJour(RemunerationEmploye remEmploye) {
		em.merge(remEmploye);
		
	}

	@Override
	public List<RemunerationEmploye> lister() {
		return repo.findAll();
	}

}
