package server.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import server.models.Liga;
import server.repository.ILigaRepository;

@RestController
public class LigaController {

	@Autowired
	private ILigaRepository ligaRepository;

	@GetMapping("/liga")
	public Collection<Liga> getAllLiga() {
		return ligaRepository.findAll();
	}

	@GetMapping("/liga/{id}")
	public Optional<Liga> getLigaById(@PathVariable Integer id) {
		return ligaRepository.findById(id);
	}
}
