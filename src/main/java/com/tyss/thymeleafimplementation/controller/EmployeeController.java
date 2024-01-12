package com.tyss.thymeleafimplementation.controller;

import com.tyss.thymeleafimplementation.entity.Employee;
import com.tyss.thymeleafimplementation.repository.EmployeeRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    private EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeRepo.save(employee);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String newEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "form";
    }

    @GetMapping("/")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeRepo.findAll());
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeRepo.findById(id).orElse(null));
        return "form";
    }
    @GetMapping("/delete/{id}")
    public String removeEmployee(@PathVariable int id) {
        employeeRepo.deleteById(id);
        return "redirect:/";
    }
}
