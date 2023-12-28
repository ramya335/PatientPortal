package com.example.SpringCrudApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.SpringCrudApp.Dao.*;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	
	@Modifying
	@Query("INSERT INTO Patient p " +
            "(p.insuranceId,p.firstName,p.middleName, p.lastName, p.ssn, p.email, p.dateOfBirth, p.address1, p.address2, p.address3, " +
            "p.zipcode, p.gender, p.state, p.countryCode, p.phoneNumber) " +
            "VALUES (:insuranceId, :firstName, :middleName, :lastName, :ssn, :email, :dateOfBirth, :address1, :address2, :address3, " +
            ":zipcode, :gender, :state, :countryCode, :phoneNumber)")
    void insertPatient(
    		@Param("insuranceId") int insuranceId,
            @Param("firstName") String firstName,
            @Param("middleName") String middleName,
            @Param("lastName") String lastName,
            @Param("ssn") String ssn,
            @Param("email") String email,
            @Param("dateOfBirth") String dateOfBirth,
            @Param("address1") String address1,
            @Param("address2") String address2,
            @Param("address3") String address3,
            @Param("zipcode") int zipcode,
            @Param("gender") String gender,
            @Param("state") String state,
            @Param("countryCode") String countryCode,
            @Param("phoneNumber") String phoneNumber
    );	
	
	@Modifying
    @Query("UPDATE Patient p SET p.firstName = :firstName, p.lastName = :lastName, p.ssn = :ssn, p.email = :email, " +
            "p.dateOfBirth = :dateOfBirth, p.address1 = :address1, p.address2 = :address2, p.address3 = :address3, " +
            "p.zipcode = :zipcode, p.gender = :gender, p.state = :state, p.countryCode = :countryCode, " +
            "p.phoneNumber = :phoneNumber WHERE p.insuranceId = :insuranceId")
    void updatePatientDetails(@Param("insuranceId") int insuranceId,
                              @Param("firstName") String firstName,
                              @Param("firstName") String middleName,
                              @Param("lastName") String lastName,
                              @Param("ssn") String ssn,
                              @Param("email") String email,
                              @Param("dateOfBirth") String dateOfBirth,
                              @Param("address1") String address1,
                              @Param("address2") String address2,
                              @Param("address3") String address3,
                              @Param("zipcode") int zipcode,
                              @Param("gender") String gender,
                              @Param("state") String state,
                              @Param("countryCode") String countryCode,
                              @Param("phoneNumber") String phoneNumber);
}
