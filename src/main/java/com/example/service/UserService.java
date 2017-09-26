package com.example.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Location;
import com.example.model.Permission;
import com.example.model.Position;
import com.example.model.Role;
import com.example.model.User;
import com.example.repository.LocationRepository;
import com.example.repository.PositionRepository;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;



@Transactional
@Repository

@Service("userService")
public class UserService implements UserDetailsService{

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired private UserRepository userRepository;
	@Autowired private RoleRepository roleRepository;
	@Autowired private PositionRepository positionRepository;
	@Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired private LocationRepository locationRepository;
    
    @PersistenceContext	
	private EntityManager entityManager;
    
    
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	
    
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public void saveOrUpdate(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        
        // role
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        
        // location
        Location location = locationRepository.findById(user.getLocation().getId());
        user.setLocation(location);
        
        
        Position position = positionRepository.findById(user.getPosition().getId());
        user.setPosition(position);
      
		userRepository.save(user);
	}

	
	public Page<User> findAll(Optional<Integer> pageSize,Optional<Integer> page,String keyword,Integer locId,Integer divId){
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);	 
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;	
//		Page<User> user = userRepository.findAll(keyword,locId,divId, new PageRequest(evalPage, evalPageSize,Sort.Direction.DESC,"id"));
		Page<User> user = userRepository.findAll(new PageRequest(evalPage, evalPageSize,Sort.Direction.DESC,"id"));
		return user;
		
	}
	
	public User findByUserId(Integer userId) {	 
		String hql = "from User where user_id = :userId  ";
		User user = (User)entityManager.createQuery(hql).setParameter("userId", userId).getSingleResult();
		return user;
	}
	
	public void active(int userId,int active) {
		User user = findByUserId(userId);
		user.setActive(active);
		userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
            User user = userRepository.findByUsername(username);
            if (user == null) {
                LOGGER.debug("user not found with the provided username");
                return null;
            }
            LOGGER.debug(" user from username " + user.toString());
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
        }
        catch (Exception e){
            throw new UsernameNotFoundException("User not found");
        }
	}
	
 
	private Set<GrantedAuthority> getAuthorities(User user){
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for(Permission permission : user.getPosition().getPermission()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getCode());
            authorities.add(grantedAuthority);
        }
//        LOGGER.debug("user authorities are " + authorities.toString());
        return authorities;
    }
	 

	 
	
	
	
	
	
	 
	
	

}
