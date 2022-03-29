package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import server.models.Tim;

public interface ITimRepository extends JpaRepository<Tim, Integer> {

}
