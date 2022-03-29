package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import server.models.Liga;

public interface ILigaRepository extends JpaRepository<Liga, Integer> {

}
