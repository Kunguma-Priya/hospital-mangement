package com.example.HospitalManagement.controller;

import com.example.HospitalManagement.model.Medicine;
import com.example.HospitalManagement.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class MedicineRestController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public List<Medicine> getAllMedicines() {
        return medicineService.getAllMedicines();
    }

    @GetMapping("/{id}")
    public Medicine getMedicineById(@PathVariable Integer id) {
        return medicineService.getMedicineById(id);
    }

    @PostMapping
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineService.saveMedicine(medicine);
    }

    @PutMapping("/{id}")
    public Medicine updateMedicine(@PathVariable Integer id, @RequestBody Medicine updatedMedicine) {
        Medicine existing = medicineService.getMedicineById(id);
        if (existing != null) {
            updatedMedicine.setMedicineId(id);
            return medicineService.saveMedicine(updatedMedicine);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable Integer id) {
        medicineService.deleteMedicine(id);
    }
}
