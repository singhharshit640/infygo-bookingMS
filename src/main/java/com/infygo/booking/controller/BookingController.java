package com.infygo.booking.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infygo.booking.dto.CreditCardDetailsDTO;
import com.infygo.booking.dto.FlightDetailsDTO;
import com.infygo.booking.dto.PassengerDetailsDTO;
import com.infygo.booking.dto.UserDetailsDTO;
import com.infygo.booking.exception.BookingMSException;
import com.infygo.booking.service.BookingService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/InfyGoBoot2")
public class BookingController {

	@Autowired
	private BookingService service;
	
	@Autowired
	private RestTemplate template;
	
	Logger logger = Logger.getLogger(BookingController.class.getName());
	
	
	//Requirement-6
	@PostMapping("/book/{FlightId}/{UserId}")
	@CircuitBreaker(name = "service", fallbackMethod = "fallMethod")
	public ResponseEntity<String> bookTickets(@PathVariable("FlightId") String flight_id, @PathVariable("UserId") String user_id,
			@RequestBody List<PassengerDetailsDTO> passengers) throws BookingMSException {
		logger.info("=======In bookTickets Method=======");
		int size = passengers.size();
		FlightDetailsDTO flightDto = template.getForObject("http://FlightMS/InfyGoBoot1/flights/"+flight_id, FlightDetailsDTO.class);
		UserDetailsDTO userDto = template.getForObject("http://UserMS/InfyGoBoot/userId/"+user_id, UserDetailsDTO.class);
		
		String response = service.bookFlightTickets(flightDto, userDto, passengers);
		//For updating the seat count in FlightTable
		FlightDetailsDTO object = template.getForObject("http://FlightMS/InfyGoBoot1/flights/"+flight_id+"/seat/"+size, FlightDetailsDTO.class);
		logger.info("Seat Count Updated!");
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	//Requirement-7
	@PostMapping("/payment")
	@CircuitBreaker(name = "service", fallbackMethod = "fallMethod")
	public ResponseEntity<String> payment(@Valid @RequestBody CreditCardDetailsDTO cardDetails) throws BookingMSException{
		logger.info("=====In Payment method=====");
		String status = service.payment(cardDetails);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
	//FallBack Method for BookTickets controller method
	public ResponseEntity<String> fallMethod(String flight_id, String user_id, List<PassengerDetailsDTO> passengers, Throwable throwable){
		logger.info("=======In FallBack Method======");
		return new ResponseEntity<String>("Unexpected error occured in flight booking", HttpStatus.OK);
	}
	
	//FallBack Method for Payment controller method
	public ResponseEntity<String> fallMethod(CreditCardDetailsDTO cardDetails, Throwable throwable){
		logger.info("======In FallBack Method======");
		return new ResponseEntity<String>("Unexpected error occurred in Payment, please try again!", HttpStatus.OK);
	}
	
}
