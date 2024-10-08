package server.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
 * The persistent class for the nacionalnost database table.
 */
@Entity
@NamedQuery(name = "Nacionalnost.findAll", query = "SELECT n FROM Nacionalnost n")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Nacionalnost implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "NACIONALNOST_ID_GENERATOR", sequenceName = "NACIONALNOST_ID_REQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NACIONALNOST_ID_GENERATOR")
    private Integer id;

    private String naziv;

    private String skracenica;

    // bi-directional many-to-one association to Igrac
    @OneToMany(mappedBy = "nacionalnost", cascade = {CascadeType.DETACH, CascadeType.REMOVE})
    @JsonIgnore
    private List<Igrac> igracs;

    public Nacionalnost() {
    }

    public Igrac addIgrac(Igrac igrac) {
        getIgracs().add(igrac);
        igrac.setNacionalnost(this);

        return igrac;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Igrac> getIgracs() {
        return this.igracs;
    }

    public void setIgracs(List<Igrac> igracs) {
        this.igracs = igracs;
    }

    public String getNaziv() {
        return this.naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSkracenica() {
        return this.skracenica;
    }

    public void setSkracenica(String skracenica) {
        this.skracenica = skracenica;
    }

    public Igrac removeIgrac(Igrac igrac) {
        getIgracs().remove(igrac);
        igrac.setNacionalnost(null);

        return igrac;
    }

}