package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@NamedQueries({
@NamedQuery(name="cotisation.findAll", query="from Cotisation"),
@NamedQuery(name="cotisation.findByCode", query="from Cotisation where code=:code")
})
@Table(name="cotisation")
public class Cotisation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="libelle")
	private String libelle;
	
	@Column(name="taux_salarial")
	private BigDecimal tauxSalarial;
	
	@Column(name="taux_pational")
	private BigDecimal tauxPatronal;
	
	@ManyToOne
	@JoinColumn(name="profil_remuneration_id")
	private ProfilRemuneration profilRemuneration;
	
	public Cotisation() {	}
	
	public Cotisation(String code, String libelle, BigDecimal tauxSalarial, BigDecimal tauxPatronal) {
		this.code = code;
		this.libelle = libelle;
		this.tauxSalarial = tauxSalarial;
		this.tauxPatronal = tauxPatronal;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}
	
	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}
	
	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}
	
	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}

	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}

}
