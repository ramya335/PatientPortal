package com.example.SpringCrudApp.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.SpringCrudApp.Dao.Patient;
import com.example.SpringCrudApp.Repository.PatientRepository;

import jakarta.persistence.Column;


@Service
public class PatientService {
	@Autowired
	public PatientRepository patientRepository;
	
	@Transactional
	public void createPatients(Patient patient) {
		
		validateData(patient);
	
		 int insuranceId = patient.getInsuranceId();
		 String firstName = patient.getFirstName();
		 String middleName = patient.getMiddleName();
		 String lastName = patient.getLastName();
		 String ssn = patient.getSsn();
		 String email = patient.getEmail();
		 String dateOfBirth = patient.getDateOfBirth();
		 String address1 = patient.getAddress1();
		 String address2 = patient.getAddress2();
		 String address3 = patient.getAddress3();
		 int zipcode = patient.getZipcode();
		 String gender = patient.getGender();
		 String state = patient.getState();
		 String countryCode = patient.getCountryCode();
		 String phoneNumber = patient.getPhoneNumber();
		 
		 
		 patientRepository.insertPatient(insuranceId,firstName,middleName,lastName,ssn,email,dateOfBirth,address1,address2,address3,
				 zipcode,gender,state,countryCode,phoneNumber);
	}
	
	@Transactional
    public void updatePatient(int insuranceId, Patient updatedPatient) {
        // Validate the provided patient details
		validateData(updatedPatient);
		

		 int insuranceId1 = updatedPatient.getInsuranceId();
		 String firstName = updatedPatient.getFirstName();
		 String middleName = updatedPatient.getMiddleName();
		 String lastName = updatedPatient.getLastName();
		 String ssn = updatedPatient.getSsn();
		 String email = updatedPatient.getEmail();
		 String dateOfBirth = updatedPatient.getDateOfBirth();
		 String address1 = updatedPatient.getAddress1();
		 String address2 = updatedPatient.getAddress2();
		 String address3 = updatedPatient.getAddress3();
		 int zipcode = updatedPatient.getZipcode();
		 String gender = updatedPatient.getGender();
		 String state = updatedPatient.getState();
		 String countryCode = updatedPatient.getCountryCode();
		 String phoneNumber = updatedPatient.getPhoneNumber();
		 

		 patientRepository.updatePatientDetails(insuranceId1,firstName,middleName,lastName,ssn,email,dateOfBirth,address1,address2,address3,
				 zipcode,gender,state,countryCode,phoneNumber);


    }

	private void validateData(Patient patient)
	{
		validateFirstName(patient.getFirstName());
		validateMiddleName(patient.getMiddleName());
		validateLastName(patient.getLastName());
		validateSsn(patient.getSsn());
		validateEmail(patient.getEmail());
		//validateDateofBirth(patient.getDateOfBirth());
		validateAddress1(patient.getAddress1());
		validateAddress2(patient.getAddress2());
		validateAddress3(patient.getAddress3());
		validateZipcode(patient.getZipcode());
		validateGender(patient.getGender());
		validateCountryCode(patient.getCountryCode());
		validatePhoneNumber(patient.getPhoneNumber());
		
	}
	
	private void validateFirstName(String firstName)
	{
		if(!firstName.matches("[a-zA-Z]+"))
		{
			throw new IllegalArgumentException("First name must contain only letters");
		}
	}
	private void validateMiddleName(String middleName)
	{
		if(!middleName.matches("[a-zA-Z]+"))
		{
			throw new IllegalArgumentException("Middle name must contains only letters");
		}
	}
	private void validateLastName(String lastName)
	{
		if(!lastName.matches("[a-zA-Z]+"))
		{
			throw new IllegalArgumentException("Last name must contains only letters");
		}
	}
	private void validateSsn(String ssn)
	{
		if(!ssn.matches("\\d{3}-\\d{2}-\\d{4}"))
		{
			throw new IllegalArgumentException("Invalid SSN Format");
		}
		String numericCheck = ssn.replaceAll("-", "");
		if(!numericCheck.matches("\\d+"))
		{
			throw new IllegalArgumentException("SSN must contain only numeric digits");
		}
	}
	private void validateEmail(String email)
	{
		if(!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"))
		{
			throw new IllegalArgumentException("Invalid email format");
		}
	}
	private void validateDateofBirth(String dateOfBirth)
	{
		if (dateOfBirth != null) {
            LocalDate currentDate = LocalDate.now();
            LocalDate dateOfBirth1 = LocalDate.parse(dateOfBirth);

            if (dateOfBirth1.isAfter(currentDate)) {
                throw new IllegalArgumentException("Date of birth cannot be in the future");
            }
        }
	}
	private void validateAddress1(String address1) {
	    if (address1 == null || address1.trim().isEmpty()) {
	        throw new IllegalArgumentException("Address1 cannot be null or empty");
	    }

	}

	private void validateAddress2(String address2) {
	    if (address2 != null && address2.trim().isEmpty()) {
	        throw new IllegalArgumentException("Address2 cannot be empty");
	    }

	}

	private void validateAddress3(String address3) {
	    if (address3 != null && address3.trim().isEmpty()) {
	        throw new IllegalArgumentException("Address3 cannot be empty");
	    }
	}

    private void validateZipcode(int zipcode) {
        if (!String.valueOf(zipcode).matches("^\\d{5}$")) {
            throw new IllegalArgumentException("Invalid zipcode format. It must be a 5-digit number.");
        }
    }

    private void validateGender(String gender) {
        if (!gender.matches("^(Male|Female|Other)$")) {
            throw new IllegalArgumentException("Invalid gender. Allowed values are Male, Female, Other.");
        }
    }

    private void validateCountryCode(String countryCode) {
        if (!countryCode.matches("^[A-Za-z]{2}$")) {
            throw new IllegalArgumentException("Invalid countryCode format. It must be a 2-letter code.");
        }
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("^[0-9]{10}$")) {
            throw new IllegalArgumentException("Invalid phoneNumber format. It must contain only digits.");
        }
    }
}