package server.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import server.models.Igrac;

@Repository
public interface IIgracRepository extends JpaRepository<Igrac, Integer> {

	Collection<Igrac> findByImeContainingIgnoreCase(String ime);

}
