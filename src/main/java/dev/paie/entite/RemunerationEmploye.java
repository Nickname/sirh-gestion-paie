package dev.paie.entite;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="remuneration_employe")
public class RemunerationEmploye {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="matricule")
	private String matricule;
	
	@ManyToOne
	@JoinColumn(name="ent_id")
	private Entreprise entreprise;
	
	@ManyToOne
	@JoinColumn(name="profil_rem_id")
	private ProfilRemuneration profilRemuneration;
	
	@ManyToOne
	@JoinColumn(name="grade_id")
	private Grade grade;
	
	@Column(name="date_creation")
	private LocalDateTime dateCreation;
	
	public RemunerationEmploye() {	}
	
	public RemunerationEmploye(String matricule, Entreprise entreprise, ProfilRemuneration profilRemuneration, Grade grade) {
		this.matricule = matricule;
		this.entreprise = entreprise;
		this.profilRemuneration = profilRemuneration;
		this.grade = grade;
		this.dateCreation = LocalDateTime.now();
	}
	
	public String getMatricule() {
		return matricule;
	}
	
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public Entreprise getEntreprise() {
		return entreprise;
	}
	
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	
	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}
	
	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}
	
	public Grade getGrade() {
		return grade;
	}
	
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}
	
}
