package server.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import server.models.Nacionalnost;

@Repository
public interface INacionalnostRepository extends JpaRepository<Nacionalnost, Integer> {

    @Query(value = "SELECT * FROM nacionalnost where id > 0", nativeQuery = true)
    Collection<Nacionalnost> findAllValid();

    Collection<Nacionalnost> findByNazivContainingIgnoreCase(String naziv);

}
