package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.*;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	
	@Autowired RemunerationEmployeRepository repoEmploye;
	
	@Autowired EntrepriseRepository repoEntreprise;
	@Autowired ProfilRemunerationRepository repoProfil;
	@Autowired GradeRepository repoGrade;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		
		mv.addObject("entreprises", repoEntreprise.findAll());
		mv.addObject("profils", repoProfil.findAll());
		mv.addObject("grades", repoGrade.findAll());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public String creerEmploye(@RequestParam("matricule") String matricule, @RequestParam("entreprise") int idEntreprise, @RequestParam("profil") int idProfil,@RequestParam("grade") int idGrade) {
		RemunerationEmploye newEmploye = new RemunerationEmploye(matricule, repoEntreprise.findOne(idEntreprise), repoProfil.findOne(idProfil), repoGrade.findOne(idGrade));
		repoEmploye.save(newEmploye);
		
		return "redirect:/mvc/employes/lister";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");
		
		mv.addObject("employes", repoEmploye.findAll());
		
		return mv;
	}
}
