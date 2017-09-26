package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	
	 
	 User findByUsername(String username);
	 
	 @Query("SELECT u FROM User u join u.location loc left join u.position pos left join pos.division di ")
	 Page<User> findAll(Pageable pageRequest);
//	 Page<User> findAll(@Param("searchTerm") String searchTerm,@Param("locId") Integer locId,@Param("divId") Integer divId,Pageable pageRequest);
}
 
 
