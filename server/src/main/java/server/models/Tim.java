package server.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the tim database table.
 *
 */
@Entity
@NamedQuery(name = "Tim.findAll", query = "SELECT t FROM Tim t")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Tim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "TIM_ID_GENERATOR", sequenceName = "TIM_ID_REQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIM_ID_GENERATOR")
	private Integer id;

	private String naziv;

	@Temporal(TemporalType.DATE)
	private Date osnovan;

	private String sediste;

	// bi-directional many-to-one association to Igrac
	@OneToMany(mappedBy = "tim", cascade = { CascadeType.DETACH, CascadeType.REMOVE })
	@JsonIgnore
	private List<Igrac> igracs;

	// bi-directional many-to-one association to Liga
	@ManyToOne
	@JoinColumn(name = "liga")
	private Liga liga;

	public Tim() {
	}

	public Igrac addIgrac(Igrac igrac) {
		getIgracs().add(igrac);
		igrac.setTim(this);

		return igrac;
	}

	public Integer getId() {
		return this.id;
	}

	public List<Igrac> getIgracs() {
		return this.igracs;
	}

	public Liga getLiga() {
		return this.liga;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public Date getOsnovan() {
		return this.osnovan;
	}

	public String getSediste() {
		return this.sediste;
	}

	public Igrac removeIgrac(Igrac igrac) {
		getIgracs().remove(igrac);
		igrac.setTim(null);

		return igrac;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIgracs(List<Igrac> igracs) {
		this.igracs = igracs;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void setOsnovan(Date osnovan) {
		this.osnovan = osnovan;
	}

	public void setSediste(String sediste) {
		this.sediste = sediste;
	}

}