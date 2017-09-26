package com.example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.configuration.BaseService;
import com.example.model.Shop;


 
@Transactional
@Repository

@Service("shopService")
public class ShopService  extends BaseService{
	
	@PersistenceContext	private EntityManager entityManager;
	
	 
	@SuppressWarnings("unchecked")
	public List<Shop> listShopByUserId(int userId){		 
	
		List<Shop> shop =  entityManager.createQuery("select id as id,name as name from Shop ").getResultList();	
		System.out.println("LOG : "+shop.get(0).getId());
		return shop;
		
//		List<ShopBean> results = query.getResultList();	
//		return results;
	}
   
	
 
}
