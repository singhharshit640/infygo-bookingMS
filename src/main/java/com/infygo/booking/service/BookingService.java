package com.infygo.booking.service;

import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infygo.booking.dto.CreditCardDetailsDTO;
import com.infygo.booking.dto.FlightDetailsDTO;
import com.infygo.booking.dto.PassengerDetailsDTO;
import com.infygo.booking.dto.TicketDetailsDTO;
import com.infygo.booking.dto.UserDetailsDTO;
import com.infygo.booking.entity.CreditCardDetailsEntity;
import com.infygo.booking.entity.PassengerDetailsEntity;
import com.infygo.booking.entity.TicketDetailsEntity;
import com.infygo.booking.exception.BookingMSException;
import com.infygo.booking.repository.CreditCardDetailsRepository;
import com.infygo.booking.repository.PassengerDetailsRepository;
import com.infygo.booking.repository.TicketDetailsRepository;

@Service
public class BookingService {
	
	@Autowired
	private PassengerDetailsRepository passengerRepo;
	
	@Autowired
	private TicketDetailsRepository ticketRepo;
	
	@Autowired
	private CreditCardDetailsRepository creditRepo;
	
	//for putting this final price in the Credit Card Details table
	Double finalPrice;
	
	//Logic of booking flight ticket with the passengers
	public String bookFlightTickets(FlightDetailsDTO flight_id, UserDetailsDTO user_id, List<PassengerDetailsDTO> passengers) throws BookingMSException {
		Integer passengerCount = passengers.size();
		if(passengerCount>flight_id.getSeat_count()) {
			Integer currentSeats = flight_id.getSeat_count();	
			throw new BookingMSException("Only "+ currentSeats+ " left");	
		}
		else if(passengers.isEmpty()) {
			throw new BookingMSException("Please provide passengers details!");
		}
		else {
			
			TicketDetailsDTO ticket = new TicketDetailsDTO();
			Double price = flight_id.getFare();
			finalPrice = passengerCount*price;
			TicketDetailsEntity ticketEntity = new TicketDetailsEntity();
			ticketEntity.setBooking_date(new Date());
			ticketEntity.setUser_id(user_id.getUser_id());
			ticketEntity.setDeparture_date(flight_id.getFlight_available_date());
			ticketEntity.setDeparture_time(flight_id.getDeparture_time());
			ticketEntity.setFlight_id(flight_id.getFlight_id());
			ticketEntity.setNo_of_seats(passengerCount);
			
			
			
			int pnr = (int) (Math.random() * 1858955);
			//This contains the Passenger entities that needs to be added in the Passenger_details table
			List<PassengerDetailsEntity> passengerEntity = new ArrayList<>();
			for(PassengerDetailsDTO d: passengers) {
				PassengerDetailsEntity e = new PassengerDetailsEntity();
				e.setPassenger_id(d.getPassenger_id());
				e.setPassenger_name(d.getPassenger_name());
				e.setPassenger_age(d.getPassenger_age());
				e.setPassenger_gender(d.getPassenger_gender());
				e.setTicket_pnr(pnr);
				passengerEntity.add(e);
			}
			//Saving the passenger details to the passenger_details table
			
			ticketEntity.setPnr(pnr);
			ticketEntity.setTotal_fare(finalPrice);
			
			
			passengerRepo.saveAllAndFlush(passengerEntity);
			ticketRepo.save(ticketEntity);
		}
			
		return "Ticket booked successfully!"; 
	}
	
	//Logic for payment endpoint
	public String payment(CreditCardDetailsDTO cardDetails) throws BookingMSException{
		CreditCardDetailsEntity cardEntity = new CreditCardDetailsEntity();
		String yearEntered = cardDetails.getExpiry_year();
		Year y = Year.now();
		String currentYear = y.toString();
		if(yearEntered.contentEquals(currentYear)) {
			throw new BookingMSException("Please check your expiry year");
		}
		else {
			cardEntity.setCard_holder_name(cardDetails.getCard_holder_name());
			cardEntity.setApin(cardDetails.getApin());
			cardEntity.setCard_number(cardDetails.getCard_number());
			cardEntity.setCvv(cardDetails.getCvv());
			cardEntity.setExpiry_month(cardDetails.getExpiry_month());
			cardEntity.setExpiry_year(cardDetails.getExpiry_year());
			cardEntity.setTotal_bill(finalPrice);	
			creditRepo.save(cardEntity);
		}
		
		return "Payment Successfull!";
		
		
			
	}

}
