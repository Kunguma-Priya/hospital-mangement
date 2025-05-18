package com.example.HospitalManagement.controller;

import com.example.HospitalManagement.model.Medicine;
import com.example.HospitalManagement.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("")
    public String navbarPage() {
        return "fragments/navbar";
    }

    @GetMapping("/add")
    public String addMedicineForm(Model model) {
        model.addAttribute("medicine", new Medicine());
        return "medicine-add";
    }

    @PostMapping("/save")
    public String saveMedicine(@ModelAttribute Medicine medicine) {
        medicineService.saveMedicine(medicine);
        return "redirect:/medicines/view";
    }

    @GetMapping("/view")
    public String viewMedicines(Model model) {
        model.addAttribute("medicines", medicineService.getAllMedicines());
        return "medicine-view";
    }

    @GetMapping("/edit")
    public String editPage(Model model) {
        model.addAttribute("medicineIds", medicineService.getAllMedicines());
        return "medicine-edit-select";
    }

    @PostMapping("/edit-form")
    public String showEditForm(@RequestParam Integer medicineId, Model model) {
        model.addAttribute("medicine", medicineService.getMedicineById(medicineId));
        return "medicine-edit";
    }

    @PostMapping("/update")
    public String updateMedicine(@ModelAttribute Medicine medicine) {
        medicineService.saveMedicine(medicine);
        return "redirect:/medicines/view";
    }

    @GetMapping("/delete")
    public String deletePage(Model model) {
        model.addAttribute("medicineIds", medicineService.getAllMedicines());
        return "medicine-delete-select";
    }

    @PostMapping("/delete")
    public String deleteMedicine(@RequestParam Integer medicineId) {
        medicineService.deleteMedicine(medicineId);
        return "redirect:/medicines/view";
    }
}
