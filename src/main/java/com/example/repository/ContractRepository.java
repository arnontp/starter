package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Contract;

public interface ContractRepository extends JpaRepository<Contract,Integer>{
	List<Contract> findAll();
}
