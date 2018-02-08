package dev.sgpwebapi.entite;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** 
 * Cette classe permet de contenir les informations sur les collaborateurs
 * 
 * */

@Entity
@Table(name = "COLLABORATEUR")
public class Collaborateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "MATRICULE")
	private String matricule;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRENOM")
	private String prenom;
	@ManyToOne
	private Departement departement;
	@Embedded
	private IdentiteBancaire identiteBancaire;
	
	public Collaborateur() {

	}
	
	public Collaborateur(String matricule, String nom, String prenom, Departement departement) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.departement = departement;
	}
	
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public IdentiteBancaire getIdentiteBancaire() {
		return identiteBancaire;
	}

	public void setIdentiteBancaire(IdentiteBancaire identiteBancaire) {
		this.identiteBancaire = identiteBancaire;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
}
