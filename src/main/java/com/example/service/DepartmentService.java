package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Department;
import com.example.repository.DepartmentRepository;


@Service("departmentService")
public class DepartmentService {
	 
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Department> findAll(){		
		return departmentRepository.findAll();
	}
}
