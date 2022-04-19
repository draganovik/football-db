package server.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the igrac database table.
 *
 */
@Entity
@NamedQuery(name = "Igrac.findAll", query = "SELECT i FROM Igrac i")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Igrac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "IGRAC_ID_GENERATOR", sequenceName = "IGRAC_ID_REQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IGRAC_ID_GENERATOR")
	@AttributeOverride(name = "id", column = @Column(name = "ID"))
	private Integer id;

	@Column(name = "broj_reg")
	private String brojReg;

	@Temporal(TemporalType.DATE)
	@Column(name = "datum_rodjenja")
	private Date datumRodjenja;

	private String ime;

	private String prezime;

	// bi-directional many-to-one association to Nacionalnost
	@ManyToOne
	@JoinColumn(name = "nacionalnost")
	private Nacionalnost nacionalnost;

	// bi-directional many-to-one association to Tim
	@ManyToOne
	@JoinColumn(name = "tim")
	private Tim tim;

	public Igrac() {
	}

	public String getBrojReg() {
		return this.brojReg;
	}

	public Date getDatumRodjenja() {
		return this.datumRodjenja;
	}

	public Integer getId() {
		return this.id;
	}

	public String getIme() {
		return this.ime;
	}

	public Nacionalnost getNacionalnost() {
		return this.nacionalnost;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public Tim getTim() {
		return this.tim;
	}

	public void setBrojReg(String brojReg) {
		this.brojReg = brojReg;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setNacionalnost(Nacionalnost nacionalnost) {
		this.nacionalnost = nacionalnost;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setTim(Tim tim) {
		this.tim = tim;
	}

}