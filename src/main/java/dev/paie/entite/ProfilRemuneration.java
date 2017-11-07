package dev.paie.entite;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="profil_remuneration")
public class ProfilRemuneration {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="code")
	private String code;
	
	@OneToMany(mappedBy="profilRemuneration")
	private List<Cotisation> cotisationsNonImposables;
	
	@OneToMany(mappedBy="profilRemuneration")
	private List<Cotisation> cotisationsImposables;
	
	@OneToMany(mappedBy="profilRemuneration")
	private List<Avantage> avantages;
	
	@OneToMany(mappedBy="profilRemuneration")
	private List<RemunerationEmploye> remunerationEmploye;
	
	public ProfilRemuneration() {	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

	public List<RemunerationEmploye> getRemunerationEmploye() {
		return remunerationEmploye;
	}

	public void setRemunerationEmploye(List<RemunerationEmploye> remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}
	
	public String toString() {
		return this.code;
	}

}
