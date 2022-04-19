package server.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the liga database table.
 *
 */
@Entity
@NamedQuery(name = "Liga.findAll", query = "SELECT l FROM Liga l")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Liga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "LIGA_ID_GENERATOR", sequenceName = "LIGA_ID_REQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIGA_ID_GENERATOR")
	private Integer id;

	private String naziv;

	private String oznaka;

	// bi-directional many-to-one association to Tim
	@OneToMany(mappedBy = "liga")
	@JsonIgnore
	private List<Tim> tims;

	public Liga() {
	}

	public Tim addTim(Tim tim) {
		getTims().add(tim);
		tim.setLiga(this);

		return tim;
	}

	public Integer getId() {
		return this.id;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public String getOznaka() {
		return this.oznaka;
	}

	public List<Tim> getTims() {
		return this.tims;
	}

	public Tim removeTim(Tim tim) {
		getTims().remove(tim);
		tim.setLiga(null);

		return tim;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public void setTims(List<Tim> tims) {
		this.tims = tims;
	}

}