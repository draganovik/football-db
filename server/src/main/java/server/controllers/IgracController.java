package server.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import server.models.Igrac;
import server.models.Tim;
import server.repository.IIgracRepository;
import server.repository.ITimRepository;

@CrossOrigin
@RestController
@Api(tags = {"CRUD Operacije: IGRAC"})
public class IgracController {

    @Autowired
    private IIgracRepository igracRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ITimRepository timRepository;

    @DeleteMapping("/igrac/{id}")
    @ApiOperation(value = "Briše igraca u odnosu na vrednost posleđene path varijable id.")
    public ResponseEntity<Igrac> deleteIgrac(@PathVariable("id") Integer id) {
        if (igracRepository.existsById(id)) {
            igracRepository.deleteById(id);

            if (id == -100) {
                jdbcTemplate.execute(
                        "INSERT INTO igrac VALUES(-100, 'Nemanja', 'Matic', '1', to_date('1.8.1988', 'dd.MM.yyyy'), -99, -99)");
            }

            return new ResponseEntity<>(HttpStatus.OK);
        }
        System.out.print(igracRepository.getOne(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/igrac")
    @ApiOperation(value = "Vraća kolekciju svih igraca iz baze podataka.")
    public Collection<Igrac> getAllIgrac() {
        return igracRepository.findAllValid();
    }

    @GetMapping("/igrac/brojreg/{brojreg}")
    @ApiOperation(value = "Vraća igraca u odnosu na posleđenu vrednost path varijable brojreg.")
    public Collection<Igrac> getIgracByBrojReg(@PathVariable("brojreg") String brojreg) {
        return igracRepository.findByBrojReg(brojreg);
    }

    @GetMapping("/igrac/{id}")
    @ApiOperation(value = "Vraća igraca u odnosu na posleđenu vrednost path varijable id.")
    public Optional<Igrac> getIgracById(@PathVariable Integer id) {
        return igracRepository.findById(id);
    }

    @GetMapping("/igrac/ime/{ime}")
    @ApiOperation(value = "Vraća igraca u odnosu na posleđenu vrednost path varijable ime.")
    public Collection<Igrac> getIgracByIme(@PathVariable("ime") String ime) {
        return igracRepository.findByImeContainingIgnoreCase(ime);
    }

    @GetMapping("/igrac/tim/{tim}")
    @ApiOperation(value = "Vraća igraca u odnosu na posleđenu vrednost path varijable tim.")
    public ResponseEntity<Collection<Igrac>> getIgracByTimId(@PathVariable("tim") Integer timid) {
        if (!timRepository.existsById(timid)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Optional<Tim> temp = timRepository.findById(timid);
        return new ResponseEntity<>(igracRepository.findByTim(temp), HttpStatus.OK);
    }

    @PostMapping("/igrac")
    @ApiOperation(value = "Dodaje novg igraca u bazu podataka.")
    public ResponseEntity<Igrac> insertIgrac(@RequestBody Igrac igrac) {
        boolean isTest = igrac.getId() == -100;
        if (((igrac.getId() == null || igrac.getId() == 0) && !igracRepository.existsByBrojReg(igrac.getBrojReg()))
                || isTest) {
            igrac.setId(null);
            Igrac temp = igracRepository.save(igrac);
            if (isTest) {
                jdbcTemplate.execute("DELETE FROM igrac WHERE id=" + temp.getId());
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

    @PutMapping("/igrac")
    @ApiOperation(value = "Ažurira postojećeg igraca.")
    public ResponseEntity<Igrac> updateIgrac(@RequestBody Igrac igrac) {
        if (igracRepository.existsById(igrac.getId())) {
            igracRepository.save(igrac);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
