package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.models.Nacionalnost;

public interface INacionalnostRepository extends JpaRepository<Nacionalnost, Integer> {

}
