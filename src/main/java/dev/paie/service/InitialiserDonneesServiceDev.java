package dev.paie.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.*;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {
	
	@PersistenceContext EntityManager em;

	@Override
	@Transactional
	public void initialiser() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:entreprises.xml", 
																		"classpath:grades.xml",
																		"classpath:profils-remuneration.xml",
																		"classpath:cotisations-imposables.xml",
																		"classpath:cotisations-non-imposables.xml");
		
		Stream.of(Entreprise.class, Grade.class, ProfilRemuneration.class, Cotisation.class)
				.forEach(classe -> context.getBeansOfType(classe)
											.values().stream()
											.forEach(o -> em.persist(o)));
		
		List<Periode> periodes = new ArrayList<>();
		
		periodes.add(new Periode(LocalDate.of(2017, 1, 1), LocalDate.of(2017, 1, 31)));
		periodes.add(new Periode(LocalDate.of(2017, 2, 1), LocalDate.of(2017, 2, 28)));
		periodes.add(new Periode(LocalDate.of(2017, 3, 1), LocalDate.of(2017, 3, 31)));
		periodes.add(new Periode(LocalDate.of(2017, 4, 1), LocalDate.of(2017, 4, 30)));
		periodes.add(new Periode(LocalDate.of(2017, 5, 1), LocalDate.of(2017, 5, 31)));
		periodes.add(new Periode(LocalDate.of(2017, 6, 1), LocalDate.of(2017, 6, 30)));
		periodes.add(new Periode(LocalDate.of(2017, 7, 1), LocalDate.of(2017, 7, 31)));
		periodes.add(new Periode(LocalDate.of(2017, 8, 1), LocalDate.of(2017, 8, 31)));
		periodes.add(new Periode(LocalDate.of(2017, 9, 1), LocalDate.of(2017, 9, 30)));
		periodes.add(new Periode(LocalDate.of(2017, 10, 1), LocalDate.of(2017, 10, 31)));
		periodes.add(new Periode(LocalDate.of(2017, 11, 1), LocalDate.of(2017, 11, 30)));
		periodes.add(new Periode(LocalDate.of(2017, 12, 1), LocalDate.of(2017, 12, 31)));
		periodes.stream().forEach(periode -> em.persist(periode));
		
		context.close();
	}

}
