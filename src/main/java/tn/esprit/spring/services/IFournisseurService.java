package tn.esprit.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Fournisseur;

@Service
public interface IFournisseurService {

	List<Fournisseur> retrieveFournisseur();
	Fournisseur retrieveById(Long id);
	Fournisseur saveFournisseur(Fournisseur f);
	Fournisseur updateFournisseur(Fournisseur f);
	void deleteFournisseur(Long id);
}
