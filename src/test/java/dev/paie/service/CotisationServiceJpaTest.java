package dev.paie.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;

@ContextConfiguration(classes= { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	
	@Autowired private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		//TODO sauvegarder une nouvelle cotisation
		Cotisation newCotisation = new Cotisation("C01", "Cotisation Annuelle", new BigDecimal(5.00), new BigDecimal(10.00));
		cotisationService.sauvegarder(newCotisation);
		//TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via la méthode lister
		List<Cotisation> listCotisations = cotisationService.lister();
		//TODO modifier une cotisation
		Cotisation modifCotisation = listCotisations.get(0);
		modifCotisation.setTauxPatronal(new BigDecimal(12.00));
		cotisationService.mettreAJour(modifCotisation);
		//TODO vérifier que les modifications sont bien prises en compte via la méthode lister
		
		assertTrue("Cotisation fausse", cotisationService.lister().get(0).getTauxPatronal().equals(new BigDecimal(12.00)));
	}
	
}
