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

import tn.esprit.spring.entities.DetailFournisseur;
import tn.esprit.spring.services.IDetailFournisseurService;

@RestController
@RequestMapping("detailfournisseur")
public class DetailFournisseurController {
	@Autowired
	IDetailFournisseurService detailFournisseurService;

	@GetMapping("/show")
	@ResponseBody
	List<DetailFournisseur> show() {
		return detailFournisseurService.retrieveDetailFournisseurs();
	}

	@GetMapping("/show/{id}")
	@ResponseBody
	DetailFournisseur showByid(@PathVariable("id") Long iddf) {
		return detailFournisseurService.retrieveById(iddf);
	}

	@PostMapping("/add")
	@ResponseBody
	DetailFournisseur add(@RequestBody DetailFournisseur df) {
		return detailFournisseurService.saveDetailFournisseur(df);
	}

	@PutMapping("/update")
	@ResponseBody
	DetailFournisseur update(@RequestBody DetailFournisseur df) {
		return detailFournisseurService.updateDetailFournisseur(df);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseBody
	void delete(@PathVariable("id") Long id) {
		detailFournisseurService.deleteDetailFournisseur(id);
	}

}
