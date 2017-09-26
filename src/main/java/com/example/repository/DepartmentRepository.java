package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long>{
	List<Department> findAll();
}
