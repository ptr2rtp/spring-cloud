package com.example.controller;

import com.example.domain.Employee;
import com.example.domain.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GreetingController {

    private final EmployeeRepository employeeRepository;

    public GreetingController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        List<Employee> all = employeeRepository.findAll();
        model.addAttribute("name", name);
        return "greeting";
    }
}
