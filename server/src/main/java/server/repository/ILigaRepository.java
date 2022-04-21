package server.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import server.models.Liga;

@Repository
public interface ILigaRepository extends JpaRepository<Liga, Integer> {

	@Query(value = "SELECT * FROM liga where id > 0", nativeQuery = true)
	Collection<Liga> findAllValid();

	Collection<Liga> findByNazivContainingIgnoreCase(String naziv);

}
