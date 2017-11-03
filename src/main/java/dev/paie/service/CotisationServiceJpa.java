package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

@Repository
@Transactional
public class CotisationServiceJpa implements CotisationService {
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);
	}

	@Override
	@Transactional
	public void mettreAJour(Cotisation cotisation) {
		em.merge(cotisation);
	}

	@Override
	@Transactional
	public List<Cotisation> lister() {
		TypedQuery<Cotisation> cotisations = em.createNamedQuery("cotisation.findAll", Cotisation.class);
		return cotisations.getResultList();
	}
}
