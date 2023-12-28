package com.example.SpringCrudApp.Dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insurance_id")
    private int insuranceId;

    @Column(name = "first_name")
    private String firstName;
    

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "ssn")
    private String ssn;
    @Column(name = "email")
    private String email;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "address1")
    private String address1;
    
    @Column(name = "address2")
    private String address2;
    
    @Column(name = "address3")
    private String address3;
    
    @Column(name = "zipcode")
    private int zipcode;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "state")
    private String state;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "phone_number")
    private String phoneNumber;
    
    public Patient() {
    }

    public Patient(String firstName,String middleName, String lastName, String ssn, String email,
                   String dateOfBirth, String address1, String address2, String address3,
                   int zipcode, String gender, String state, String countryCode, String phoneNumber) {
        this.firstName = firstName;
        this.middleName=middleName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.zipcode = zipcode;
        this.gender = gender;
        this.state = state;
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
    }
    
    public int getInsuranceId() {
		return insuranceId;
	}
    public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}
    public String getFirstName() {
		return firstName;
	}
    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
    public String getMiddleName() {
		return middleName;
	}
    public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
    public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    public String getLastName() {
		return lastName;
	}
    public void setSsn(String ssn) {
		this.ssn = ssn;
	}
    public String getSsn() {
		return ssn;
	}
    public void setEmail(String email) {
		this.email = email;
	}
    public String getEmail() {
		return email;
	}
    public String getDateOfBirth() {
		return dateOfBirth;
	}
    public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
    public String getAddress1() {
		return address1;
	}
    public void setAddress1(String address1) {
		this.address1 = address1;
	}
    public String getAddress2() {
		return address2;
	}
    public void setAddress2(String address2) {
		this.address2 = address2;
	}
    public String getAddress3() {
		return address3;
	}
    public void setAddress3(String address3) {
		this.address3 = address3;
	}
    public int getZipcode() {
		return zipcode;
	}
    public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
    public String getGender() {
		return gender;
	}
    public void setGender(String gender) {
		this.gender = gender;
	}
    public String getState() {
		return state;
	}
    public void setState(String state) {
		this.state = state;
	}
    public String getCountryCode() {
		return countryCode;
	}
    public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
    public String getPhoneNumber() {
		return phoneNumber;
	}
    public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
