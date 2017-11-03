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
import dev.paie.entite.Grade;

@ContextConfiguration(classes= { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired private GradeService gradeService;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
	// TODO sauvegarder un nouveau grade
	Grade newGrade = new Grade(0, "G01", new BigDecimal(10.50), new BigDecimal(5.00));
	gradeService.sauvegarder(newGrade);
	// TODO vérifier qu'il est possible de récupérer le nouveau grade via la méthode lister
	List<Grade> listGrade = gradeService.lister();
	// TODO modifier un grade
	Grade modifGrade = listGrade.get(0);
	modifGrade.setNbHeuresBase(new BigDecimal(7.00));
	modifGrade.setTauxBase(new BigDecimal(5.25));
	gradeService.mettreAJour(modifGrade);
	// TODO vérifier que les modifications sont bien prises en compte via la méthode lister
	List<Grade> listModifGrade = gradeService.lister();
	assertTrue("le nb d'heure est faux", listModifGrade.get(0).getNbHeuresBase().equals(new BigDecimal(7.00)));
	assertTrue("le taux est faux" , listModifGrade.get(0).getTauxBase().equals(new BigDecimal(5.25)));
	}

}
