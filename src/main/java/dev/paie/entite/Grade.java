package dev.paie.entite;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="grade")
public class Grade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="nb_heures_base")
	private BigDecimal nbHeuresBase;
	
	@Column(name="taux_base")
	private BigDecimal tauxBase;
	
	@OneToMany(mappedBy="profilRemuneration")
	private List<RemunerationEmploye> remunerationEmploye;
	
	public Grade() {	}
	
	public Grade(int id, String code, BigDecimal nbHeuresBase, BigDecimal tauxBase) {
		this.id = id;
		this.code = code;
		this.nbHeuresBase = nbHeuresBase;
		this.tauxBase = tauxBase;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public BigDecimal getNbHeuresBase() {
		return nbHeuresBase;
	}
	
	public void setNbHeuresBase(BigDecimal nbHeuresBase) {
		this.nbHeuresBase = nbHeuresBase;
	}
	
	public BigDecimal getTauxBase() {
		return tauxBase;
	}
	
	public void setTauxBase(BigDecimal tauxBase) {
		this.tauxBase = tauxBase;
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
		return this.code + " - " + (this.nbHeuresBase.multiply(this.tauxBase).multiply(new BigDecimal(12))).setScale(0, BigDecimal.ROUND_DOWN) + " € / an";
	}
	
}
