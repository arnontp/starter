package com.example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.example.model.Position;
@Service("positionService")
public class PositionService {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Position> findAll() {
		String hql = "from Position ";
		return (List<Position>) entityManager.createQuery(hql).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Position> findByDivId(int id) {
		String hql = "from Position where div_id = :divId  ";
		return (List<Position>) entityManager.createQuery(hql).setParameter("divId", id).getResultList();
	}
}
