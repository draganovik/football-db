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

import server.models.Tim;
import server.repository.ITimRepository;

@RestController
public class TimController {
	@Autowired
	private ITimRepository timRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/tim")
	public Collection<Tim> getAllTim() {
		return timRepository.findAll();
	}

	@GetMapping("/tim/{id}")
	public Optional<Tim> getTimById(@PathVariable Integer id) {
		return timRepository.findById(id);
	}

	/*
	 * @GetMapping("timNaziv/{naziv}") public Collection<Tim>
	 * getTimiByNaziv(@PathVariable("naziv") String naziv) { return
	 * timRepository.findByNazivContainingIgnoreCase(naziv); }
	 */
	@PostMapping("Tim")
	public ResponseEntity<Tim> insertTim(@RequestBody Tim Tim) {
		if (!timRepository.existsById(Tim.getId())) {
			timRepository.save(Tim);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@PutMapping("Tim")
	public ResponseEntity<Tim> updateTim(@RequestBody Tim Tim) {
		if (timRepository.existsById(Tim.getId())) {
			timRepository.save(Tim);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@DeleteMapping("Tim/{id}")
	public ResponseEntity<Tim> deleteTim(@PathVariable("id") Integer id) {
		if (timRepository.existsById(id)) {
			timRepository.deleteById(id);

			if (id == -100) {
				jdbcTemplate.execute(
						"INSERT INTO tim VALUES(-100, 'Radnički', to_date('1914', 'yyyy'), 'Sremska Mitrovica', 'Super Liga' );");
			}

			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
