package com.infygo.booking.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsDTO {
	
	@NotNull(message = "User ID is mandatory")
	private String user_id;
	
	@NotNull(message = "City is mandatory")
	private String city;
	
	@NotNull(message = "Email must not be blank")
	@Email
	private String email;
	
	@NotNull(message = "Name must not be blank.")
	@Size(min = 3, max = 15, message = "Name must be between 4 to 15 characters")
	private String name;
	
	@NotNull(message = "Password field should not be empty")
//	@Min(value = 9)
//	@Max(value = 20)
	//@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{9,20}$", message = "Password should contain atleast 9 characters with one lower and upper ")
	@Size(min = 9, max = 20, message = "Password must be between 9 to 20 characters")
	private String password;
	
	@NotNull(message = "PhoneNumber must not be blank")
	@Size(min = 10, max = 10, message = "Phone Number should be of 10 digits")
	private String phone;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public UserDetailsDTO(String user_id, String city, String email, String name, String password, String phone) {
		super();
		this.user_id = user_id;
		this.city = city;
		this.email = email;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}
	public UserDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserDetailsDTO [user_id=" + user_id + ", city=" + city + ", email=" + email + ", name=" + name
				+ ", password=" + password + ", phone=" + phone + "]";
	}
	
	

}
