package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import server.models.Liga;

@Repository
public interface ILigaRepository extends JpaRepository<Liga, Integer> {

	// Collection<Liga> findByNazivContainingIgnoreCase(String naziv);

}
