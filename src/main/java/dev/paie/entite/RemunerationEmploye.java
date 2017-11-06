package dev.paie.entite;

import java.util.List;

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

	@OneToMany(mappedBy="remunerationEmploye")
	private List<BulletinSalaire> bulletins;
	
	public RemunerationEmploye() {	}
	
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
	
	public List<BulletinSalaire> getBulletins() {
		return bulletins;
	}

	public void setBulletins(List<BulletinSalaire> bulletins) {
		this.bulletins = bulletins;
	}
	
}
