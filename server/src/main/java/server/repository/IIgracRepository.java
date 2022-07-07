package server.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import server.models.Igrac;
import server.models.Tim;

@Repository
public interface IIgracRepository extends JpaRepository<Igrac, Integer> {

    boolean existsByBrojReg(String brojReg);

    @Query(value = "SELECT * FROM igrac where id > 0", nativeQuery = true)
    Collection<Igrac> findAllValid();

    Collection<Igrac> findByBrojReg(String brojreg);

    Collection<Igrac> findByImeContainingIgnoreCase(String ime);

    Collection<Igrac> findByTim(Optional<Tim> temp);

    @Query(value = "SELECT last_value+1" + " FROM player_code where tim = ?1", nativeQuery = true)
    Integer nextRegBroj(Integer id);

}
