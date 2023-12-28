package com.example.SpringCrudApp.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringCrudApp.Dao.Patient;
import com.example.SpringCrudApp.Service.*;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin("http://localhost:5173/")
@Tag(name = "Patient Details")
public class PatientController {
	private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

	@PostMapping("/createPatients")
	public ResponseEntity<String> createPatient(@RequestBody Patient patient)
	{
		try {
			patientService.createPatients(patient);
			return ResponseEntity.ok("Patient addedd successfully");
		} catch(IllegalArgumentException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@PutMapping("/updatePatient/{insuranceId}")
    public ResponseEntity<String> updatePatient(@PathVariable int insuranceId, @RequestBody Patient patient) {
        try {
            patientService.updatePatient(insuranceId, patient);
            return ResponseEntity.ok("Patient updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
