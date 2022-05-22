package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.SecteurActivite;
import tn.esprit.spring.services.ISecteurActiviteService;



@RestController 
@RequestMapping("activite") 
public class SecteurActiviteController {
	
	@Autowired
	ISecteurActiviteService secteurActiviteService;
	
	@GetMapping("/show")
	@ResponseBody 
	List<SecteurActivite> afficherSecteurActivites(){
		return secteurActiviteService.retrieveSecteurActivite();
	}
	
	
	@GetMapping("/showByid/{id}")
	@ResponseBody 
	SecteurActivite afficherstock(@PathVariable("id")Long id) {
		return secteurActiviteService.retrieveById(id);
	}
	
	
	@PostMapping("/add")
	@ResponseBody
	SecteurActivite add(@RequestBody SecteurActivite p) {
		return secteurActiviteService.saveSecteurActivite(p);
	}
	
	@PutMapping("/update")
	@ResponseBody
	SecteurActivite update(@RequestBody SecteurActivite p) {
		return secteurActiviteService.updateSecteurActivite(p);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	void delete(@PathVariable("id") Long id) {
		secteurActiviteService.deleteSecteurActivite(id);
	}
	
	@PostMapping("/assignToFournisseur")
	@ResponseBody
	void assignToFournisseur(@RequestBody Long fournisseurId,@RequestBody Long
			secteurActiviteId) {
		secteurActiviteService.assignSecteurActiviteToFournisseur(fournisseurId, secteurActiviteId);
	}

}
