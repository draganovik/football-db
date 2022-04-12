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

import server.models.Igrac;
import server.repository.IIgracRepository;

@RestController
public class IgracController {
	@Autowired
	private IIgracRepository igracRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/igrac")
	public Collection<Igrac> getAllIgrac() {
		return igracRepository.findAll();
	}

	@GetMapping("/igrac/{id}")
	public Optional<Igrac> getIgracById(@PathVariable Integer id) {
		return igracRepository.findById(id);
	}

	@GetMapping("/igrac/ime/{ime}")
	public Collection<Igrac> getIgraciByNaziv(@PathVariable("ime") String ime) {
		return igracRepository.findByImeContainingIgnoreCase(ime);
	}

	@PostMapping("/igrac")
	public ResponseEntity<Igrac> insertIgrac(@RequestBody Igrac Igrac) {
		if (!igracRepository.existsById(Igrac.getId())) {
			igracRepository.save(Igrac);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@PutMapping("/igrac")
	public ResponseEntity<Igrac> updateIgrac(@RequestBody Igrac Igrac) {
		if (igracRepository.existsById(Igrac.getId())) {
			igracRepository.save(Igrac);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@DeleteMapping("/igrac/{id}")
	public ResponseEntity<Igrac> deleteIgrac(@PathVariable("id") Integer id) {
		if (igracRepository.existsById(id)) {
			igracRepository.deleteById(id);

			if (id == -100) {
				jdbcTemplate.execute(
						"INSERT INTO igrac VALUES(-100, 'Nemanja', 'Matic', 666, to_date('1.8.1988', 'dd.MM.yyyy'), 168, 'Radnički' );");
			}

			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
