package com.app.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.app.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER_TABLE")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@NotBlank(message="Please enter first name")
	@Pattern(regexp = "^[A-Za-z]",message = "First Name contains Alphabates Only")
	private String  firstName;
	
	@NotBlank(message="Please enter last name")
	@Pattern(regexp = "^[A-Za-z]",message = "Last name contains Alphabates Only")
	private String  lastName;
	
	@NotBlank(message = "Please enter email")
	@Column(unique = true)
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",message = "Please enter valid email address")
	private String  email;
	
	@NotBlank(message="Please enter password")
	private String  password;
	
	@NotBlank(message="Please enter phoneNumer")
	@Pattern(regexp = "\\d{10}$",message = "Phone number contains digits Only")
	@Size(max = 10,message = "Phone number contains exctaly 10 digits")
	private String  phoneNumber;
	
	@NotNull(message = "Please enter date of birth")
	private LocalDate dateOfBirth;
	
	
	private Gender  gender;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="customerId")
	private Set<Address> address = new HashSet<>();
	
	@Size(min=1,max=3,message = "Roles must be between 1 and 3")
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name="User_Roles_Table",joinColumns = { @JoinColumn(name="customerId")},inverseJoinColumns = {@JoinColumn(name="roleId")})
	private Set<Roles> roles = new HashSet<>();


	@Override
	public String toString() {
		return "{ customerId : " + customerId + ", firstName : " + firstName + ", lastName : " + lastName + ", email : "+ email + ", password : " + password +",dateOfBirth : "+dateOfBirth+ ", phoneNumber : " + phoneNumber + ", gender : " + gender + ", address : " + address + ", roles : "+roles+" }";
	} 
}
