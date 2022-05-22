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

import tn.esprit.spring.entities.Operateur;
import tn.esprit.spring.services.IOperateurService;



@RestController 
@RequestMapping("operateur") 
public class OperateurController {
	
	@Autowired
	IOperateurService operateurService;
	
	@GetMapping("/show")
	@ResponseBody 
	List<Operateur> show(){
	return operateurService.retrieveOperateur();
	}
	
	
	@GetMapping("/show/{id}")
	@ResponseBody 
	Operateur showByid(@PathVariable("id")Long id) {
	return operateurService.retrieveById(id);
	}
	
	
	@PostMapping("/add")
	@ResponseBody
	Operateur add(@RequestBody Operateur d) {
	return operateurService.saveOperateur(d);
	}
	
	@PutMapping("/update")
	@ResponseBody
	Operateur update(@RequestBody Operateur d) {
	return operateurService.updateOperateur(d);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	void delete(@PathVariable("id") Long id) {
		operateurService.deleteOperateur(id);
	}

}
