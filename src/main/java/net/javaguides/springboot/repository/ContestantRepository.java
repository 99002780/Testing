package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Contestant;

@Repository
public interface ContestantRepository extends JpaRepository<Contestant, Long>{

}
