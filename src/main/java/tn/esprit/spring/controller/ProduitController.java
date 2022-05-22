package tn.esprit.spring.controller;

import java.util.Date;
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

import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.services.IProduitService;



@RestController 
@RequestMapping("produit") 
public class ProduitController {
	
	@Autowired
	IProduitService produitService;
	
	@GetMapping("/show")
	@ResponseBody 
	List<Produit> show(){
		return produitService.retrieveProduit();
	}
	
	
	@GetMapping("/show/{id}")
	@ResponseBody 
	Produit showbyid(@PathVariable("id")Long id) {
		return produitService.retrieveById(id);
	}
	
	
	@PostMapping("/add")
	@ResponseBody
	Produit add(@RequestBody Produit p,@RequestBody Long idCP, @RequestBody Long idS) {
		return produitService.saveProduit(p,idCP, idS);
	}
	
	@PutMapping("/update")
	@ResponseBody
	Produit update(@RequestBody Produit p,@RequestBody Long idCP, @RequestBody Long idS){
		return produitService.updateProduit(p,idCP, idS);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	void delete(@PathVariable("id") Long id) {
		produitService.deleteProduit(id);
	}
	
	@PostMapping("/retriveByDate")
	@ResponseBody
	List<Produit> retriveByDate(@RequestBody Date d1,@RequestBody Date d2) {
		return produitService.retriveProduitByDate(d1,d2);
	}
	
	@PostMapping("/assignTo")
	@ResponseBody
	void assignTo(@RequestBody Long idProduit,@RequestBody Long idStock) {
		produitService.assignProduitToStock(idProduit, idStock);
	}

}
