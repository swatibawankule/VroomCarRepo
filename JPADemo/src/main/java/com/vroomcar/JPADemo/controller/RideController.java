package com.vroomcar.JPADemo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vroomcar.JPADemo.Exception.ConfictException;
import com.vroomcar.JPADemo.Exception.RideNotPresentException;
import com.vroomcar.JPADemo.beans.Ride;
import com.vroomcar.JPADemo.repository.RideJpaRepository;
import com.vroomcar.JPADemo.service.IRideService;
import com.vroomcar.JPADemo.service.RideService;
import com.vroomcar.utils.SMSApi;

@RestController
@RequestMapping("Rest/VroomCar")
@CrossOrigin(origins = {"http://localhost:4200"})
public class RideController {
	
	@Autowired
	RideJpaRepository rideJPARepository;
	
	@Autowired
	IRideService rideService;
	
	
	//@RequestMapping(value = "/allRides", method =RequestMethod.GET)
	/*
	 * @GetMapping("/allRides") public String findAll(){
	 * 
	 * return "Hello Rest API"; //return rideJPARepository.findAll(); }
	 */
	
	@GetMapping(value ="/allRides", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Ride>> findAll(){
		
		
		List<Ride> list =  rideService.getAllRides();
		
		return new ResponseEntity<List<Ride>>(list, HttpStatus.CREATED);
		
	}
	
	
	  @PostMapping("/loadRide") 
	  
	  public ResponseEntity<Ride> load(@RequestBody final Ride ride) {
	  
	  boolean flag = rideService.addRide(ride);
      if (flag == false) {
	   //return new ResponseEntity<Ride>(HttpStatus.CONFLICT).;
    	
              throw new ConfictException();
          
      }
	  Ride obj= rideJPARepository.findByriderName(ride.getRiderName());
	  
	 // URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getRideid());
			  
      return new ResponseEntity<Ride>(obj, HttpStatus.CREATED);
	  
	  }
	  
		//Deletes article by id
		@DeleteMapping("Ride/{id}")
		public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) throws RideNotPresentException {
			
			rideService.deleteRide(id);
			
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		
		@GetMapping("sendSMS/{mobile}")
		
		public void sendSMSByMobileNumber(@PathVariable("mobile") String mobile) {
			
			SMSApi  smsApi = new SMSApi();
														smsApi.senSMS(mobile);
		//	return Response.ok().entity(result).build();
			//  http://smshorizon.co.in/api/sendsms.php?user=Learnwell&apikey=0LUTPTQ7Gy2IgB01zhLU&mobile=xxyy&message=xxyy&senderid=xxyy&type=txt;
		
		}
	  
	  
	 
//	  @PutMapping("/updateRide")
//	  public Ride updateRide(@RequestBody final Ride ride) {
//		  
//		  
//		  
//  }
	
}
