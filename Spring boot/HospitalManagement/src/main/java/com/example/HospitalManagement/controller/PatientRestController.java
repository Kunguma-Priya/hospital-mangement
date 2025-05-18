package com.example.HospitalManagement.controller;

import com.example.HospitalManagement.model.Patient;
import com.example.HospitalManagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*")
public class PatientRestController {

    @Autowired
    private PatientService patientService;

    @GetMapping("")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Integer id) {
        return patientService.getPatientById(id);
    }

    @PostMapping("")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Integer id, @RequestBody Patient patient) {
        patient.setPatient_id(id);
        return patientService.savePatient(patient);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Integer id) {
        patientService.deletePatient(id);
        return "Patient with ID " + id + " deleted successfully.";
    }
}
