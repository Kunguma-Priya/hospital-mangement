package com.example.HospitalManagement.service;

import com.example.HospitalManagement.model.Patient;
import com.example.HospitalManagement.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Integer id) {
        return patientRepository.findById(id).orElse(null);
    }

    public void deletePatient(Integer id) {
        patientRepository.deleteById(id);
    }
}
