package com.infygo.booking.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreditCardDetailsDTO {

	@NotNull(message = "Card Number is mandatory")
	private String card_number;
	@NotNull(message = "APIN is mandatory")
	private String apin;
	@NotNull(message = "Card Holder Name is mandatory")
	private String card_holder_name;
	
	@NotNull(message = "CVV is mandatory")
	@Size(min = 3, max = 3)
	private String cvv;
	
	@NotNull(message = "Expiry Month is mandatory")
	@Size(min = 3, max = 3)
	private String expiry_month;
	@NotNull(message = "Expiry Year is mandatory")
	private String expiry_year;
	private Double total_bill;
	public CreditCardDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreditCardDetailsDTO(String card_number, String apin, String card_holder_name,
			@Size(min = 3, max = 3) String cvv, String expiry_month, String expiry_year, Double total_bill) {
		super();
		this.card_number = card_number;
		this.apin = apin;
		this.card_holder_name = card_holder_name;
		this.cvv = cvv;
		this.expiry_month = expiry_month;
		this.expiry_year = expiry_year;
		this.total_bill = total_bill;
	}
	public String getCard_number() {
		return card_number;
	}
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	public String getApin() {
		return apin;
	}
	public void setApin(String apin) {
		this.apin = apin;
	}
	public String getCard_holder_name() {
		return card_holder_name;
	}
	public void setCard_holder_name(String card_holder_name) {
		this.card_holder_name = card_holder_name;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getExpiry_month() {
		return expiry_month;
	}
	public void setExpiry_month(String expiry_month) {
		this.expiry_month = expiry_month;
	}
	public String getExpiry_year() {
		return expiry_year;
	}
	public void setExpiry_year(String expiry_year) {
		this.expiry_year = expiry_year;
	}
	public Double getTotal_bill() {
		return total_bill;
	}
	public void setTotal_bill(Double total_bill) {
		this.total_bill = total_bill;
	}
	
	
	
}
