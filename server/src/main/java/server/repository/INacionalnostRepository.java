package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import server.models.Nacionalnost;

@Repository
public interface INacionalnostRepository extends JpaRepository<Nacionalnost, Integer> {

	// Collection<Nacionalnost> findByNazivContainingIgnoreCase(String naziv);

}
