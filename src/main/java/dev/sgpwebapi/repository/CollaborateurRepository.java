package dev.sgpwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgpwebapi.entite.Collaborateur;
import dev.sgpwebapi.entite.Departement;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer>{

	List<Collaborateur> findByDepartement(Departement departement);

	Collaborateur findByMatricule(String matricule);

}
