package com.vroomcar.JPADemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.vroomcar.JPADemo.beans.Ride;
import com.vroomcar.JPADemo.repository.RideJpaRepository;

import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RideJPARepositoryIntegrationTest {

	 
	    @Autowired
	    private TestEntityManager entityManager;
	 
	    @Autowired
	    private RideJpaRepository employeeRepository;
	 
	    // write test cases here
	    
	    @Test
	    public void whenFindByName_thenReturnRide() {
	        // given
	        Ride ride = new Ride();
	        Ride ride1 = new Ride();
	        ride1.setRiderName("Neha");
	        
	        ride.setRiderName("swati");
	        entityManager.persist(ride);
	        entityManager.flush();
	     
	        // when
	        Ride found = employeeRepository.findByriderName(ride.getRiderName());
	     
	        // then
	        assertThat(found.getRiderName())
	          .isEqualTo(ride.getRiderName());
	    }
	 
	}

