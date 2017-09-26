package com.example.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.configuration.BaseService;
import com.example.model.Role;
import com.example.model.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;

@Transactional
@Repository

@Service("userService")
public class UserService extends BaseService{

	
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @PersistenceContext	
	private EntityManager entityManager;
    
     
    
	public User findUserByUsername(String email) {
		return userRepository.findByUsername(email);
	}

	public void saveOrUpdateUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));       
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	
	public Page<User> findAll(Optional<Integer> pageSize,Optional<Integer> page){
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);	 
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;	
		return userRepository.findAll(new PageRequest(evalPage, evalPageSize));
	}
	
	public User findByUserId(int userId) {
		String hql = "from User where user_id = :userId  ";
		return (User)entityManager.createQuery(hql).setParameter("userId", userId).getSingleResult();
	}
	
	public void active(int userId,int active) {
		User user = findByUserId(userId);
		user.setActive(active);
		userRepository.save(user);
	}
	
	
	
	
	
	
	 
	
	

}
