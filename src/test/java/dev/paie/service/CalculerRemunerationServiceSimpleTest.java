package dev.paie.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.JeuDeDonneesConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;

@ContextConfiguration(classes= { ServicesConfig.class, JeuDeDonneesConfig.class })
@RunWith(SpringRunner.class)
public class CalculerRemunerationServiceSimpleTest {

	@Autowired
	private CalculerRemunerationService remunerationService;

	@Autowired
	private BulletinSalaire bulletin;

	@Test
	public void test_calculer() {
	ResultatCalculRemuneration resultat = remunerationService.calculer(bulletin);
	assertThat(resultat.getSalaireBrut(), equalTo("2683.30"));
	assertThat(resultat.getTotalRetenueSalarial(), equalTo("517.08"));
	assertThat(resultat.getTotalCotisationsPatronales(), equalTo("1096.13"));
	assertThat(resultat.getNetImposable(), equalTo("2166.22"));
	assertThat(resultat.getNetAPayer(), equalTo("2088.41"));
	}
}
