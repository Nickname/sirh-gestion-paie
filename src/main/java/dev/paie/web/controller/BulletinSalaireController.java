package dev.paie.web.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.*;

@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {
	
	@Autowired BulletinSalaireRepository repoBulletin;
	
	@Autowired PeriodeRepository repoPeriode;
	@Autowired RemunerationEmployeRepository repoRemuneration;

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
	public String postBulletin(@RequestParam("periode") int idPeriode, @RequestParam("matricule") int idEmploye, @RequestParam("prime") BigDecimal prime) {
		BulletinSalaire newBulletin = new BulletinSalaire(repoRemuneration.findOne(idEmploye), repoPeriode.findOne(idPeriode), prime);
		repoBulletin.save(newBulletin);
		
		return "redirect:/mvc/bulletins/lister";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerBulletin() {
		return null;
	} 
}
