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

import tn.esprit.spring.entities.CategorieProduit;
import tn.esprit.spring.services.ICategorieProduitService;

@RestController 
@RequestMapping("categorie") 
public class CategorieProduitController {
	
	@Autowired
	ICategorieProduitService categorieProduitService;  
	
	@GetMapping("/show")
	@ResponseBody 
	List<CategorieProduit> show(){
	return categorieProduitService.retrieveCategorieProduit();
	}
	
	
	@GetMapping("/show/{id}")
	@ResponseBody 
	CategorieProduit showByid(@PathVariable("id")Long idCategorieProduit) {
	return categorieProduitService.retrieveById(idCategorieProduit);
	}
	
	@PostMapping("/add")
	@ResponseBody
	CategorieProduit add(@RequestBody CategorieProduit c) { 
	return categorieProduitService.saveCategorieProduit(c);
	}
	
	@PutMapping("/update")
	@ResponseBody
	CategorieProduit update(@RequestBody CategorieProduit c) { 
	return categorieProduitService.updateCategorieProduit(c);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	void delete(@PathVariable("id") Long id) {
		categorieProduitService.deleteCategorieProduit(id);
	}

}
