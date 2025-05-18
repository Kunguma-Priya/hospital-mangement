package com.example.HospitalManagement.service;

import com.example.HospitalManagement.model.Doctor;
import com.example.HospitalManagement.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
