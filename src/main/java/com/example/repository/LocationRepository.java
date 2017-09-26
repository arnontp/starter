package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Location;

public interface LocationRepository extends JpaRepository<Location,Integer>{
	List<Location> findAll();
	Location findById(int id);
}
