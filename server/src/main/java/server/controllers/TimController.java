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
import server.models.Tim;
import server.repository.ITimRepository;

@RestController
@Api(tags = { "CRUD Operacije: TIM" })
public class TimController {

	@Autowired
	private ITimRepository timRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@DeleteMapping("/tim/{id}")
	@ApiOperation(value = "Briše tim u odnosu na vrednost posleđene path varijable id.")
	public ResponseEntity<Tim> deleteTim(@PathVariable("id") Integer id) {
		if (timRepository.existsById(id)) {
			timRepository.deleteById(id);

			if (id == -100) {
				jdbcTemplate.execute(
						"INSERT INTO tim VALUES(-100, 'Radnički', to_date('1914', 'yyyy'), 'Sremska Mitrovica', 'Super Liga');");
			}

			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/tim")
	@ApiOperation(value = "Vraća kolekciju svih timova iz baze podataka.")
	public Collection<Tim> getAllTim() {
		return timRepository.findAll();
	}

	@GetMapping("/tim/{id}")
	@ApiOperation(value = "Vraća tim u odnosu na posleđenu vrednost path varijable id.")
	public Optional<Tim> getTimById(@PathVariable Integer id) {
		return timRepository.findById(id);
	}

	@GetMapping("/tim/naziv/{naziv}")
	@ApiOperation(value = "Vraća tim u odnosu na posleđenu vrednost path varijable naziv.")
	public Collection<Tim> getTimByNaziv(@PathVariable("naziv") String naziv) {
		return timRepository.findByNazivContainingIgnoreCase(naziv);
	}

	@PostMapping("/tim")
	@ApiOperation(value = "Dodaje novi tim u bazu podataka.")
	public ResponseEntity<Tim> insertTim(@RequestBody Tim tim) {
		if (tim.getId() == null) {
			timRepository.save(tim);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@PutMapping("/tim")
	@ApiOperation(value = "Ažurira postojeći tim.")
	public ResponseEntity<Tim> updateTim(@RequestBody Tim tim) {
		if (timRepository.existsById(tim.getId())) {
			timRepository.save(tim);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
