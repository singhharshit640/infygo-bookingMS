package com.infygo.booking.dto;




import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FlightDetailsDTO {
	
	private String flight_id;
	private String airlines;
	private String arrival_time;
	private String departure_time;
	
	@NotEmpty(message = "Please enter the destination")
	@NotNull(message = "Destination is mandatory")
	private String destination;
	private Double fare;
	@NotEmpty(message = "Please enter the journey date")
	@NotNull(message = "Journey date is mandatory")
	private Date flight_available_date;
	private Integer seat_count;
	
	@NotEmpty(message = "Please enter the origin")
	@NotNull(message = "Source is mandatory")
	private String source;

	public FlightDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightDetailsDTO(String flight_id, String airlines, String arrival_time, String departure_time,
			@NotEmpty(message = "Please enter the destination") @NotNull(message = "Destination is mandatory") String destination,
			Double fare, Date flight_available_date, Integer seat_count,
			@NotEmpty(message = "Please enter the origin") @NotNull(message = "Source is mandatory") String source) {
		super();
		this.flight_id = flight_id;
		this.airlines = airlines;
		this.arrival_time = arrival_time;
		this.departure_time = departure_time;
		this.destination = destination;
		this.fare = fare;
		this.flight_available_date = flight_available_date;
		this.seat_count = seat_count;
		this.source = source;
	}

	public String getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(String flight_id) {
		this.flight_id = flight_id;
	}

	public String getAirlines() {
		return airlines;
	}

	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}

	public String getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}

	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public Date getFlight_available_date() {
		return flight_available_date;
	}

	public void setFlight_available_date(Date flight_available_date) {
		this.flight_available_date = flight_available_date;
	}

	public Integer getSeat_count() {
		return seat_count;
	}

	public void setSeat_count(Integer seat_count) {
		this.seat_count = seat_count;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "FlightDetailsDTO [flight_id=" + flight_id + ", airlines=" + airlines + ", arrival_time=" + arrival_time
				+ ", departure_time=" + departure_time + ", destination=" + destination + ", fare=" + fare
				+ ", flight_available_date=" + flight_available_date + ", seat_count=" + seat_count + ", source="
				+ source + "]";
	}
	
	
	
	
	
}
