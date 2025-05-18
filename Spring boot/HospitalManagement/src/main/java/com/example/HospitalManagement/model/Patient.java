package com.example.HospitalManagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

    public enum Sex {
        M, F
    }

    public enum PatientType {
        Inpatient, Outpatient
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patient_id;

    @Column(nullable = false, length = 100)
    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    @Column(length = 1)
    private Sex sex;

    @Column(length = 255)
    private String disease;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private PatientType type;

    // --- Getters and Setters ---

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public PatientType getType() {
        return type;
    }

    public void setType(PatientType type) {
        this.type = type;
    }
}
