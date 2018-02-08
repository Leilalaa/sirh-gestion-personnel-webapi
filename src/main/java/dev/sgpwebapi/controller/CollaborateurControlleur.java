package dev.sgpwebapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.sgpwebapi.entite.Collaborateur;
import dev.sgpwebapi.entite.IdentiteBancaire;
import dev.sgpwebapi.repository.CollaborateurRepository;
import dev.sgpwebapi.repository.DepartementRepository;


@Controller
public class CollaborateurControlleur {

	@Autowired
	private CollaborateurRepository cr;
	@Autowired
	private DepartementRepository dr;


	@RequestMapping(method = RequestMethod.GET, path = "/api/collaborateurs")
	@ResponseBody
	public List<Collaborateur> afficheParDepartement(
			@RequestParam(value = "departement") Optional<Integer> departementId) {
		if (departementId.isPresent()) {
			return this.cr.findByDepartement(dr.findOne(departementId.get()));
		}
		return cr.findAll();
	}
	
	
	 @RequestMapping(method = RequestMethod.GET, path="/api/collaborateurs/{matricule}")
	 @ResponseBody
	 public Collaborateur afficheParMatricule(@PathVariable String matricule) {
	
		 return this.cr.findByMatricule(matricule);
	 }
	 
	 @RequestMapping(method = RequestMethod.PUT, path="/api/collaborateurs/{matricule}")
	 @ResponseBody
	 public Collaborateur updateParMatricule(@PathVariable String matricule, @RequestBody Collaborateur collaborateur) {
		 Collaborateur collabBDDD = cr.findByMatricule(matricule);
		if(collabBDDD != null){
			collaborateur.setId(collabBDDD.getId());
			 cr.save(collaborateur);
		 }
		 return collaborateur;
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, path="/api/collaborateurs/{matricule}/banque")
	 @ResponseBody
	 public IdentiteBancaire afficheBanque(@PathVariable String matricule) {
	
		 return this.cr.findByMatricule(matricule).getIdentiteBancaire();
	 }
	 
	 @RequestMapping(method = RequestMethod.PUT, path="/api/collaborateurs/{matricule}/banque")
	 @ResponseBody
	 public IdentiteBancaire modifierBanque(@PathVariable String matricule, @RequestBody Collaborateur collaborateur) {
		
		 if(cr.findByMatricule(matricule) != null){
			 cr.save(collaborateur);
		 }
		 
		 return collaborateur.getIdentiteBancaire();
	 }
}

