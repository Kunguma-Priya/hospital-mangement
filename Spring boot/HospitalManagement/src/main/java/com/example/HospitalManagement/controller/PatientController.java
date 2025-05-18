package com.example.HospitalManagement.controller;

import com.example.HospitalManagement.model.Patient;
import com.example.HospitalManagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("")
    public String navbarPage() {
        return "fragments/navbar";  // this is just fragment, you might want to redirect or show a default page
    }

    @GetMapping("/add")
    public String addPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("sexValues", Patient.Sex.values());
        model.addAttribute("typeValues", Patient.PatientType.values());
        return "patient-add";
    }

    @PostMapping("/save")
    public String savePatient(@ModelAttribute Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients/view";
    }

    @GetMapping("/view")
    public String viewPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "patient-view";
    }

    @GetMapping("/edit")
    public String editPage(Model model) {
        model.addAttribute("patientIds", patientService.getAllPatients());
        return "patient-edit-select";
    }

    @PostMapping("/edit-form")
    public String showEditForm(@RequestParam Integer patientId, Model model) {
        Patient patient = patientService.getPatientById(patientId);
        model.addAttribute("patient", patient);
        model.addAttribute("sexValues", Patient.Sex.values());
        model.addAttribute("typeValues", Patient.PatientType.values());
        return "patient-edit";
    }

    @PostMapping("/update")
    public String updatePatient(@ModelAttribute Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients/view";
    }

    @GetMapping("/delete")
    public String deletePage(Model model) {
        model.addAttribute("patientIds", patientService.getAllPatients());
        return "patient-delete-select";
    }

    @PostMapping("/delete")
    public String deletePatient(@RequestParam Integer patientId) {
        patientService.deletePatient(patientId);
        return "redirect:/patients/view";
    }
}
