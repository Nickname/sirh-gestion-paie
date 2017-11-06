package dev.paie.service;

import java.util.List;

import dev.paie.entite.*;

public interface RemunerationEmployeService {
	void sauvegarder(RemunerationEmploye remEmploye);
	void mettreAJour(RemunerationEmploye remEmploye);
	List<RemunerationEmploye> lister();
}
