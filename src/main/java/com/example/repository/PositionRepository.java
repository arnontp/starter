package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Position;

public interface PositionRepository extends JpaRepository<Position,Integer> {
	List<Position> findAll();
	
	Position findById(int id);
  
}
