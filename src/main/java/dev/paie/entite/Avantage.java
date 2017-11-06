package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name="avantage")
public class Avantage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="montant")
	private BigDecimal montant;
	
	@ManyToOne
	@JoinColumn(name="profil_remuneration_id")
	private ProfilRemuneration profilRemuneration;
	
	public Avantage() {	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
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
