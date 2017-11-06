package dev.paie.entite;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="periode")
public class Periode {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="date_debut")
	//@Temporal(TemporalType.DATE)
	private LocalDate dateDebut;
	
	@Column(name="date_fin")
	//@Temporal(TemporalType.DATE)
	private LocalDate dateFin;
	
	public Periode() {	}
	
	public Periode(LocalDate dateDebut, LocalDate dateFin) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	public LocalDate getDateFin() {
		return dateFin;
	}
	
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

}
