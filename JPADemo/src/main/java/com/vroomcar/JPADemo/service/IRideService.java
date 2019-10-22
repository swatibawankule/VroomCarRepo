package com.vroomcar.JPADemo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.vroomcar.JPADemo.Exception.RideNotPresentException;
import com.vroomcar.JPADemo.beans.Ride;

@Component
public interface IRideService {
	 List<Ride> getAllRides();
     Ride getRideById(long rideId);
     boolean addRide(Ride ride);
     void updateRide(Ride ride);
     void deleteRide(int rideId)throws RideNotPresentException;	
	
}
