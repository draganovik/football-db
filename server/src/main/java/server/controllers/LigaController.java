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

import server.models.Liga;
import server.repository.ILigaRepository;

@RestController
public class LigaController {

	@Autowired
	private ILigaRepository ligaRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/liga")
	public Collection<Liga> getAllLiga() {
		return ligaRepository.findAll();
	}

	@GetMapping("/liga/{id}")
	public Optional<Liga> getLigaById(@PathVariable Integer id) {
		return ligaRepository.findById(id);
	}

	@GetMapping("/liga/naziv/{naziv}")
	public Collection<Liga> getLigaiByNaziv(@PathVariable("naziv") String naziv) {
		return ligaRepository.findByNazivContainingIgnoreCase(naziv);
	}

	@PostMapping("/liga")
	public ResponseEntity<Liga> insertLiga(@RequestBody Liga Liga) {
		if (!ligaRepository.existsById(Liga.getId())) {
			ligaRepository.save(Liga);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@PutMapping("/liga")
	public ResponseEntity<Liga> updateLiga(@RequestBody Liga Liga) {
		if (ligaRepository.existsById(Liga.getId())) {
			ligaRepository.save(Liga);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@DeleteMapping("/liga/{id}")
	public ResponseEntity<Liga> deleteLiga(@PathVariable("id") Integer id) {
		if (ligaRepository.existsById(id)) {
			ligaRepository.deleteById(id);

			if (id == -100) {
				jdbcTemplate.execute("INSERT INTO liga VALUES(-100, 'Super Loga', 'SRB');");
			}

			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
