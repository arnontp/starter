package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Division;

public interface DivisionRepository extends JpaRepository<Division,Long>{
	 
	 List<Division> findAll();
}
