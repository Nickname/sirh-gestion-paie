package dev.paie.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Grade;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {
	
	@Autowired private PaieUtils paieUtils;
	
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		String salaireBase = paieUtils.formaterBigDecimal(bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply((bulletin.getRemunerationEmploye().getGrade().getTauxBase())));
		String salaireBrut = paieUtils.formaterBigDecimal((new BigDecimal(salaireBase)).add(bulletin.getPrimeExceptionnelle()));
		
		String totalRetenueSalarial = paieUtils.formaterBigDecimal(
				bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()
																.stream()
																.filter(c -> c.getTauxSalarial() != null)
																.map(c -> c.getTauxSalarial().multiply(new BigDecimal(salaireBrut)))
																.reduce((c , c1) -> c.add(c1))
																.get());
		
		String totalCotisationsPatronales = paieUtils.formaterBigDecimal(
				bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()
																.stream()
																.filter(c -> c.getTauxPatronal() != null)
																.map(c -> c.getTauxPatronal().multiply(new BigDecimal(salaireBrut)))
																.reduce((c , c1) -> c.add(c1))
																.get());
		
		String netImposable = paieUtils.formaterBigDecimal((new BigDecimal(salaireBrut).subtract(new BigDecimal(totalRetenueSalarial))));
		
		String netAPayer = paieUtils.formaterBigDecimal((new BigDecimal(netImposable)).subtract(
									bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables()
																.stream()
																.filter(c -> c.getTauxSalarial() != null)
																.map(c -> c.getTauxSalarial().multiply(new BigDecimal(salaireBrut)))
																.reduce((c , c1) -> c.add(c1))
																.get()));
		
		ResultatCalculRemuneration resultat = new ResultatCalculRemuneration();
		
		resultat.setSalaireDeBase(salaireBase);
		resultat.setSalaireBrut(salaireBrut);
		resultat.setTotalRetenueSalarial(totalRetenueSalarial);
		resultat.setTotalCotisationsPatronales(totalCotisationsPatronales);
		resultat.setNetImposable(netImposable);
		resultat.setNetAPayer(netAPayer);
		
		return resultat;
	}

}
