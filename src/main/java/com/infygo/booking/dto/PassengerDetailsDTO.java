package com.infygo.booking.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PassengerDetailsDTO {

	//@NotNull(message = "Passenger ID is mandatory")
	private Integer passenger_id;
	private String passenger_age;
	private String passenger_gender;
	@NotNull(message = "Passenger name is mandatory")
	@NotEmpty
	private String passenger_name;
	private Integer ticket_pnr;
	public PassengerDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PassengerDetailsDTO(@NotNull(message = "Passenger ID is mandatory") Integer passenger_id,
			String passenger_age, String passenger_gender,
			@NotNull(message = "Passenger name is mandatory") @NotEmpty String passenger_name, Integer ticket_pnr) {
		super();
		this.passenger_id = passenger_id;
		this.passenger_age = passenger_age;
		this.passenger_gender = passenger_gender;
		this.passenger_name = passenger_name;
		this.ticket_pnr = ticket_pnr;
	}
	public Integer getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(Integer passenger_id) {
		this.passenger_id = passenger_id;
	}
	public String getPassenger_age() {
		return passenger_age;
	}
	public void setPassenger_age(String passenger_age) {
		this.passenger_age = passenger_age;
	}
	public String getPassenger_gender() {
		return passenger_gender;
	}
	public void setPassenger_gender(String passenger_gender) {
		this.passenger_gender = passenger_gender;
	}
	public String getPassenger_name() {
		return passenger_name;
	}
	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}
	public Integer getTicket_pnr() {
		return ticket_pnr;
	}
	public void setTicket_pnr(Integer ticket_pnr) {
		this.ticket_pnr = ticket_pnr;
	}
	
	
	
	
}
