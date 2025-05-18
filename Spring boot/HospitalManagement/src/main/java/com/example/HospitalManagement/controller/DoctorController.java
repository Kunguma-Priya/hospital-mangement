package com.example.HospitalManagement.controller;

import com.example.HospitalManagement.model.Doctor;
import com.example.HospitalManagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Navbar landing page (optional, or redirect to view)
    @GetMapping({"", "/"})
    public String home() {
        return "redirect:/doctors/view";
    }

    // View all doctors
    @GetMapping("/view")
    public String viewDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctor-view";
    }

    // Show add doctor form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctor-add";
    }

    // Save new doctor
    @PostMapping("/save")
    public String saveDoctor(@ModelAttribute Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors/view";
    }

    // Show edit select page (dropdown)
    @GetMapping("/edit")
    public String showEditSelectPage(Model model) {
        model.addAttribute("doctorIds", doctorService.getAllDoctors());
        return "doctor-edit-select";
    }

    // Process selected doctorId to show edit form
    @PostMapping("/edit-form")
    public String showEditForm(@RequestParam Long doctorId, Model model) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        model.addAttribute("doctor", doctor);
        return "doctor-edit";
    }

    // Update doctor details
    @PostMapping("/update")
    public String updateDoctor(@ModelAttribute Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors/view";
    }

    // Show delete select page (dropdown)
    @GetMapping("/delete")
    public String showDeleteSelectPage(Model model) {
        model.addAttribute("doctorIds", doctorService.getAllDoctors());
        return "doctor-delete-select";
    }

    // Delete selected doctor
    @PostMapping("/delete")
    public String deleteDoctor(@RequestParam Long doctorId) {
        doctorService.deleteDoctor(doctorId);
        return "redirect:/doctors/view";
    }
}
