package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Contestant;



@Repository
public interface ContestantRepository extends JpaRepository<Contestant, Long>{

	void deleteById(int id);


}
