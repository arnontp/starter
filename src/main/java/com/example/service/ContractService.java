package com.example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Contract;
import com.example.repository.ContractRepository;

@Service("contractService")
public class ContractService {
	
	 	
	@PersistenceContext	private EntityManager entityManager;	
	@Autowired ContractRepository contractRepository;
	 
	public List<Contract> findAll(){		
		return contractRepository.findAll();
	}
}
