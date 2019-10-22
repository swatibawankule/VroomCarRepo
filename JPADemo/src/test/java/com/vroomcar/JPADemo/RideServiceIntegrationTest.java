package com.vroomcar.JPADemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.vroomcar.JPADemo.beans.Ride;
import com.vroomcar.JPADemo.repository.RideJpaRepository;
import com.vroomcar.JPADemo.service.RideService;

@RunWith(SpringRunner.class)
public class RideServiceIntegrationTest {

	 
	    @TestConfiguration
	    static class EmployeeServiceImplTestContextConfiguration {
	  
	        @Bean
	        public RideService rideService() {
	            return new RideService();
	        }
	    }
	 
	    @Autowired
	    private RideService rideService;
	 
	    @MockBean
	    private RideJpaRepository rideRepository;
	   
	    @Before
	    public void setUp() {
	    	Ride ride = new Ride();
	    	ride.setRiderName("swati");
	    	
	        Mockito.when(rideRepository.findByriderName( ride.getRiderName()))
	          .thenReturn(ride);
	    }
	    
	     
	    @Test
	    public void whenValidName_thenRideShouldbeFound() {
	        String name = "swati";
	        Ride found = rideService.getRideByRiderName(name);
	      
	         assertThat(found.getRiderName())
	          .isEqualTo(name);
	     }
	    
	    
	    
	}

