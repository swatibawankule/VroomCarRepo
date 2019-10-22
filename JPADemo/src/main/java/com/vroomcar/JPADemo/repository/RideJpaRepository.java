package com.vroomcar.JPADemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.vroomcar.JPADemo.beans.Ride;

@Component
public interface RideJpaRepository extends JpaRepository<Ride, Long> {
	
  public  Ride findByriderName(String riderName);
  
 public List<Ride> findByRideidAndRiderName(Integer rideid,String riderName);
 
 public Ride findByrideid(Integer id);
 
	
}
