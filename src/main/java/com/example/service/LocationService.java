package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Location;
import com.example.repository.LocationRepository;

@Service("locationService")
public class LocationService {
	 @Autowired LocationRepository locationRepository;
	 public List<Location> findAll(){		
		return locationRepository.findAll();
	 }
	 
	 public Location findById(int id) {
		 return locationRepository.findById(id);
	 }
}
