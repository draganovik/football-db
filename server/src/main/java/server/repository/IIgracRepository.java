package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import server.models.Igrac;

public interface IIgracRepository extends JpaRepository<Igrac, Integer> {

}
