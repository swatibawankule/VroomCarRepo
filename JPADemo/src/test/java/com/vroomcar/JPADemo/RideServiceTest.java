package com.vroomcar.JPADemo;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vroomcar.JPADemo.Exception.ConfictException;
import com.vroomcar.JPADemo.beans.Ride;
import com.vroomcar.JPADemo.controller.RideController;
import com.vroomcar.JPADemo.repository.RideJpaRepository;
import com.vroomcar.JPADemo.service.RideService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RideServiceTest {


	   @Mock
	    private RideJpaRepository rideRepository;
	   

	    //@Spy
	    @InjectMocks 
	    private RideService  rideservice = new RideService();
	    
	   
	
	@Test
	public void saveRideTest() {
		Ride r = new Ride();
		
		r.setRiderName("Swati");
		
		boolean flag = rideservice.addRide(r);
		
		assertEquals(true ,flag);
	}
	
	@Test
	public void checkExceptionRideTest() {
         Ride r = new Ride();
		RideController rideController = new RideController();

		r.setRiderName("Swati");
		
		rideController.load(r);
		
		when(rideservice.addRide(r)).thenThrow(ConfictException.class);
	}


}
