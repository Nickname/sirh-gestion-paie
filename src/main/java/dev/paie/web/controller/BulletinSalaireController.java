package dev.paie.web.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.*;
import dev.paie.service.CalculerRemunerationServiceSimple;

@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {
	
	@Autowired BulletinSalaireRepository repoBulletin;
	
	@Autowired PeriodeRepository repoPeriode;
	@Autowired RemunerationEmployeRepository repoRemuneration;
	
	@Autowired CalculerRemunerationServiceSimple calculRemuneration;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		
		mv.addObject("bulletins", repoBulletin.findAll());
		mv.addObject("employes", repoRemuneration.findAll());
		mv.addObject("periodes", repoPeriode.findAll());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public String postBulletin(@RequestParam("periode") int idPeriode, @RequestParam("matricule") int idEmploye, @RequestParam("prime") String prime) {
		BulletinSalaire newBulletin = new BulletinSalaire(repoRemuneration.findOne(idEmploye), repoPeriode.findOne(idPeriode), new BigDecimal(prime));
		repoBulletin.save(newBulletin);
		
		return "redirect:/mvc/bulletins/lister";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	@Transactional
	public ModelAndView listerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletin");
		
		Map<BulletinSalaire, ResultatCalculRemuneration> bulletinsCalcul = new HashMap<>();
		
		repoBulletin.findAll().forEach(bulletin -> bulletinsCalcul.put(bulletin, calculRemuneration.calculer(bulletin)));
		
		mv.addObject("bulletins", bulletinsCalcul);
		
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, path = "/detail/{id}")
	@Transactional
	public ModelAndView visualiserBulletin(@PathVariable Integer id){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/detailBulletin");

		BulletinSalaire bulletin = repoBulletin.findOne(id);

		ResultatCalculRemuneration resultatCalculRemuneration = calculRemuneration.calculer(bulletin);

		List<Cotisation> cotisationsNonImposables = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables();
		
		List<Cotisation> cotisationsImposables = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables();
		
		mv.addObject("titre", "Bulletin de salaire");
	
		mv.addObject("bulletin", bulletin);
		mv.addObject("resultatCalculRemuneration", resultatCalculRemuneration);
		mv.addObject("cotisationsNonImposables", cotisationsNonImposables);
		mv.addObject("cotisationsImposables", cotisationsImposables);

		return mv;
}
}
