package com.example.HospitalManagement.repositories;

import com.example.HospitalManagement.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
}
