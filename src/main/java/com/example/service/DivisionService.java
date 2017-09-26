package com.example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.example.model.Division;

 

@Service("divisionService")
public class DivisionService {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	Session session ;
	
	@SuppressWarnings("unchecked")
	public List<Division> findAll() {
		String hql = "from Division";
		return (List<Division>) entityManager.createQuery(hql).getResultList();
	}
	
	 
}
