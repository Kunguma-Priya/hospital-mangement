package com.example.HospitalManagement.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medicines")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicineId;

    @Column
    private String medicineName;

    @Column
    private Double cost;

    @Column(nullable = false)
    private LocalDate expiryDate;

    @Column(nullable = false)
    private Integer stock;

    // Getters and Setters
    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
