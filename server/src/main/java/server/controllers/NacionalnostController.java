package server.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import server.models.Nacionalnost;
import server.repository.INacionalnostRepository;

@RestController
@Api(tags = { "CRUD Operacije: NACIONALNOST" })
public class NacionalnostController {

	@Autowired
	private INacionalnostRepository nacionalnostRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@DeleteMapping("/nacionalnost/{id}")
	@ApiOperation(value = "Briše nacionalnost u odnosu na vrednost posleđene path varijable id.")
	public ResponseEntity<Nacionalnost> deleteNacionalnost(@PathVariable("id") Integer id) {
		if (nacionalnostRepository.existsById(id)) {
			nacionalnostRepository.deleteById(id);

			if (id == -100) {
				jdbcTemplate.execute("INSERT INTO nacionalnost VALUES(-100, 'Serbia',  'SRB');");
			}

			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/nacionalnost")
	@ApiOperation(value = "Vraća kolekciju svih nacionalnosti iz baze podataka.")
	public Collection<Nacionalnost> getAllNacionalnost() {
		return nacionalnostRepository.findAll();
	}

	@GetMapping("/nacionalnost/{id}")
	@ApiOperation(value = "Vraća nacionalnost u odnosu na posleđenu vrednost path varijable id.")
	public Optional<Nacionalnost> getNacionalnostById(@PathVariable Integer id) {
		return nacionalnostRepository.findById(id);
	}

	@GetMapping("/nacionalnost/naziv/{naziv}")
	@ApiOperation(value = "Vraća nacionalnost u odnosu na posleđenu vrednost path varijable naziv.")
	public Collection<Nacionalnost> getNacionalnostiByNaziv(@PathVariable("naziv") String naziv) {
		return nacionalnostRepository.findByNazivContainingIgnoreCase(naziv);
	}

	@PostMapping("/nacionalnost")
	@ApiOperation(value = "Dodaje novu nacionalnost u bazu podataka.")
	public ResponseEntity<Nacionalnost> insertNacionalnost(@RequestBody Nacionalnost nacionalnost) {
		if (nacionalnost.getId() == null) {
			nacionalnostRepository.save(nacionalnost);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@PutMapping("/nacionalnost")
	@ApiOperation(value = "Ažurira postojeću nacionalnsot.")
	public ResponseEntity<Nacionalnost> updateNacionalnost(@RequestBody Nacionalnost nacionalnost) {
		if (nacionalnostRepository.existsById(nacionalnost.getId())) {
			nacionalnostRepository.save(nacionalnost);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
