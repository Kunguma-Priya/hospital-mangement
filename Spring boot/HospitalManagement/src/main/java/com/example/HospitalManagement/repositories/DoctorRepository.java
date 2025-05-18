package com.example.HospitalManagement.repositories;

import com.example.HospitalManagement.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}