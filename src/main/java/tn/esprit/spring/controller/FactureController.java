package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Reglement;
import tn.esprit.spring.services.IFactureService;



@RestController 
@RequestMapping("facture") 
public class FactureController {
	
	@Autowired
	IFactureService factureService;
	
	@GetMapping("/show")
	@ResponseBody 
	List<Facture> show(){
	return factureService.retrieveAllFactures();
	}
	
	
	@GetMapping("/show/{id}")
	@ResponseBody 
	Facture showByid(@PathVariable("id")Long id) {
		return factureService.retrieveFacture(id);
	}
	
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	void delete(@PathVariable("id") Long id) {
		factureService.cancelFacture(id);
	}
	

	@GetMapping("/getByFournisseur/{id}")
	@ResponseBody 
	List<Facture> getByFournisseur(@PathVariable("id")Long idFournisseur) {
		return factureService.getFacturesByFournisseur(idFournisseur);
	}
	
	@GetMapping("/retrieveReglementByFacture/{id}")
	@ResponseBody 
	List<Reglement> retrieveReglementByFacture(@PathVariable("id")Long idFacture) {
		return factureService.retrieveReglementByFacture(idFacture);
	}

	@PostMapping("/add")
	@ResponseBody
	Facture addFacture(@RequestBody Facture f,@RequestBody Long idFournisseur) {
		return factureService.addFacture(f, idFournisseur);
	}
	
	@PostMapping("/add/Reglement")
	@ResponseBody
	Reglement addReglement(@RequestBody Reglement r,@RequestBody Long idFacture){
		return factureService.addReglement(r, idFacture);
	}
	
	@PostMapping("/getChiffreAffaireEntreDeuxDate")
	@ResponseBody
	float getChiffreAffaireEntreDeuxDate(@RequestBody Date startDate,@RequestBody Date endDate){
		return factureService.getChiffreAffaireEntreDeuxDate(startDate, endDate);
	}
	
	@PostMapping("/pourcentageRecouvrement")
	@ResponseBody
	float pourcentageRecouvrement(@RequestBody Date startDate,@RequestBody Date endDate){
		return factureService.pourcentageRecouvrement(startDate, endDate);
	}
}
