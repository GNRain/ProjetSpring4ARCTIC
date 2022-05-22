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

import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.services.IFournisseurService;



@RestController 
@RequestMapping("fournisseur") 
public class FournisseurController {
	
	@Autowired
	IFournisseurService fournisseurService;
	
	@GetMapping("/show")
	@ResponseBody 
	List<Fournisseur> show(){
	return fournisseurService.retrieveFournisseur();
	}
	
	
	@GetMapping("/show/{id}")
	@ResponseBody 
	Fournisseur showByid(@PathVariable("id")Long id) {
	return fournisseurService.retrieveById(id);
	}
	
	
	@PostMapping("/add")
	@ResponseBody
	Fournisseur add(@RequestBody Fournisseur f) { 
	return fournisseurService.saveFournisseur(f);
	}
	
	@PutMapping("/update")
	@ResponseBody
	Fournisseur update(@RequestBody Fournisseur f) { 
	return fournisseurService.updateFournisseur(f);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	void delete(@PathVariable("id") Long id) {
		fournisseurService.deleteFournisseur(id);
	}

}