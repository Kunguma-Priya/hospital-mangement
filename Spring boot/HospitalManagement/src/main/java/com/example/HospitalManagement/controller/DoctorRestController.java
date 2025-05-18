package com.example.HospitalManagement.controller;

import com.example.HospitalManagement.model.Doctor;
import com.example.HospitalManagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorRestController {

    @Autowired
    private DoctorService doctorService;

    // GET all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // GET doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(doctor);
    }

    // POST create new doctor
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return doctor;
    }

    // PUT update doctor by ID
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor updatedDoctor) {
        Doctor existing = doctorService.getDoctorById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        updatedDoctor.setDoctorId(id);
        doctorService.saveDoctor(updatedDoctor);
        return ResponseEntity.ok(updatedDoctor);
    }

    // DELETE doctor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        Doctor existing = doctorService.getDoctorById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
