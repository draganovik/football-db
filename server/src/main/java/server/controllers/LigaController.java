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
import server.models.Liga;
import server.repository.ILigaRepository;

@CrossOrigin
@RestController
@Api(tags = { "CRUD Operacije: LIGA" })
public class LigaController {

	@Autowired
	private ILigaRepository ligaRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@DeleteMapping("/liga/{id}")
	@ApiOperation(value = "Briše ligu u odnosu na vrednost posleđene path varijable id.")
	public ResponseEntity<Liga> deleteLiga(@PathVariable("id") Integer id) {
		if (ligaRepository.existsById(id)) {
			ligaRepository.deleteById(id);
			if (id == -100) {
				jdbcTemplate.execute("INSERT INTO liga VALUES(-100, 'Super Liga', 'SRB')");
			}

			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/liga")
	@ApiOperation(value = "Vraća kolekciju svih liga iz baze podataka.")
	public Collection<Liga> getAllLiga() {
		return ligaRepository.findAllValid();
	}

	@GetMapping("/liga/{id}")
	@ApiOperation(value = "Vraća ligu u odnosu na posleđenu vrednost path varijable id.")
	public Optional<Liga> getLigaById(@PathVariable Integer id) {
		return ligaRepository.findById(id);
	}

	@GetMapping("/liga/naziv/{naziv}")
	@ApiOperation(value = "Vraća ligu u odnosu na posleđenu vrednost path varijable naziv.")
	public Collection<Liga> getLigaiByNaziv(@PathVariable("naziv") String naziv) {
		return ligaRepository.findByNazivContainingIgnoreCase(naziv);
	}

	@PostMapping("/liga")
	@ApiOperation(value = "Dodaje novu ligu u bazu podataka.")
	public ResponseEntity<Liga> insertLiga(@RequestBody Liga liga) {
		if (liga.getId() == null) {
			Liga temp = ligaRepository.save(liga);
			return new ResponseEntity<>(temp, HttpStatus.CREATED);
		}
		if (liga.getId() == -100) {
			liga.setId(null);
			Liga temp = ligaRepository.save(liga);
			jdbcTemplate.execute("DELETE FROM liga WHERE id=" + temp.getId());
			return new ResponseEntity<>(temp, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@PutMapping("/liga")
	@ApiOperation(value = "Ažurira postojeću ligu.")
	public ResponseEntity<Liga> updateLiga(@RequestBody Liga liga) {
		if (ligaRepository.existsById(liga.getId())) {
			ligaRepository.save(liga);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
