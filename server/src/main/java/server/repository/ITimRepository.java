package server.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import server.models.Tim;

@Repository
public interface ITimRepository extends JpaRepository<Tim, Integer> {

	@Query(value = "SELECT * FROM tim where id > 0", nativeQuery = true)
	Collection<Tim> findAllValid();

	Collection<Tim> findByNazivContainingIgnoreCase(String naziv);

}
