package dev.paie.entite;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="entreprise")
public class Entreprise {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="siret")
	private String siret;
	
	@Column(name="denomination")
	private String denomination;
	
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="urssaf")
	private String urssaf;
	
	@Column(name="codeNaf")
	private String codeNaf;
	
	@OneToMany(mappedBy="profilRemuneration")
	private List<RemunerationEmploye> remunerationEmploye;
	
	public String getDenomination() {
		return denomination;
	}
	
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getSiret() {
		return siret;
	}
	
	public void setSiret(String siret) {
		this.siret = siret;
	}
	
	public String getUrssaf() {
		return urssaf;
	}
	
	public void setUrssaf(String urssaf) {
		this.urssaf = urssaf;
	}
	
	public String getCodeNaf() {
		return codeNaf;
	}
	
	public void setCodeNaf(String codeNaf) {
		this.codeNaf = codeNaf;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public List<RemunerationEmploye> getRemunerationEmploye() {
		return remunerationEmploye;
	}

	public void setRemunerationEmploye(List<RemunerationEmploye> remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}
	
	public String toString() {
		return this.denomination;
	}
	
}
