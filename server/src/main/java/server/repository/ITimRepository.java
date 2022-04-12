package server.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import server.models.Tim;

@Repository
public interface ITimRepository extends JpaRepository<Tim, Integer> {

	Collection<Tim> findByNazivContainingIgnoreCase(String naziv);

}
