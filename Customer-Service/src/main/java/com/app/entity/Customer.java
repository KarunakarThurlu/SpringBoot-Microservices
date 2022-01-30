package com.app.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@NotEmpty(message="Please enter first name")
	@Pattern(regexp = "[A-Za-z]+",message = "First Name contains Alphabates Only")
	private String  firstName;
	
	@NotEmpty(message="Please enter last name")
	@Pattern(regexp = "[A-Za-z]+",message = "Last name contains Alphabates Only")
	private String  lastName;
	
	@NotNull(message = "Please enter email")
	@Column(unique = true)
	@Email
	private String  email;
	
	@NotBlank(message="Please enter password")
	private String  password;
	
	@NotNull(message="Please enter phoneNumer")
	@Pattern(regexp = "[0-9\\s]{10}",message = "Phone number contains exctaly 10 digits")
	private String  phoneNumber;
	
	
	@Past
    @DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateOfBirth;
	
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private Gender  gender;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="customerId")
	private Set<Address> address = new HashSet<>();
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name="User_Roles_Table",joinColumns = { @JoinColumn(name="customerId")},inverseJoinColumns = {@JoinColumn(name="roleId")})
	private Set<Roles> roles = new HashSet<>();


	@Override
	public String toString() {
		return "{ customerId : " + customerId + ", firstName : " + firstName + ", lastName : " + lastName + ", email : "+ email + ", password : " + password +",dateOfBirth : "+dateOfBirth+ ", phoneNumber : " + phoneNumber + ", gender : " + gender + ", address : " + address + ", roles : "+roles+" }";
	} 
}
