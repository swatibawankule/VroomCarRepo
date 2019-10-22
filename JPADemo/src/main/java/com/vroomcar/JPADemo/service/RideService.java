package com.vroomcar.JPADemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.vroomcar.JPADemo.Exception.RideNotPresentException;
import com.vroomcar.JPADemo.beans.Ride;
import com.vroomcar.JPADemo.repository.RideJpaRepository;

@Component
public class RideService implements IRideService {

	@Autowired
	RideJpaRepository rideJPARepository;	

	@Override
	public List<Ride> getAllRides() {
		List<Ride> list = new ArrayList<>();
		rideJPARepository.findAll().forEach(e -> list.add(e));
		return list;
		
	}

	@Override
	public Ride getRideById(long rideId) {
		
		Ride obj = rideJPARepository.findById(rideId).get();
		return obj;
	}
	
	
	public Ride getRideByRiderName(String name) {
		
		 Ride ride = rideJPARepository.findByriderName(name); 
		 
		 return ride;
		
	}

	@Override
	public synchronized boolean addRide(Ride ride) {
		
		        Ride rideexisiting = rideJPARepository.findByriderName(ride.getRiderName()); 
		        
	                  if (null!= rideexisiting) {
	                	  System.out.println("more than one elements");
	    	          return false;
	                } else {
	                	rideJPARepository.save(ride);
	    	          return true;
	                }
		}
	

	@Override
	public void updateRide(Ride ride) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRide(int rideId) throws RideNotPresentException {
		 Ride rideTobeDeleted = rideJPARepository.findByrideid(rideId);
		if(null ==  rideTobeDeleted) {
			throw new RideNotPresentException();
			
		}
		else
		
		rideJPARepository.delete(rideTobeDeleted);
		
		
		
	}

}
