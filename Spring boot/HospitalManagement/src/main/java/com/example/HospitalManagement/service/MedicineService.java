package com.example.HospitalManagement.service;

import com.example.HospitalManagement.model.Medicine;
import com.example.HospitalManagement.repositories.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public Medicine saveMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public Medicine getMedicineById(Integer id) {
        return medicineRepository.findById(id).orElse(null);
    }

    public void deleteMedicine(Integer id) {
        medicineRepository.deleteById(id);
    }
}
