package server.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import server.models.Igrac;
import server.models.Tim;

@Repository
public interface IIgracRepository extends JpaRepository<Igrac, Integer> {

	boolean existsByBrojReg(String brojReg);

	Collection<Igrac> findByBrojReg(String brojreg);

	Collection<Igrac> findByImeContainingIgnoreCase(String ime);

	Collection<Igrac> findByTim(Tim tim);

	@Query(value = "SELECT last_value+1" + " FROM player_code where tim = ?1", nativeQuery = true)
	Integer nextRegBroj(Integer id);

}
