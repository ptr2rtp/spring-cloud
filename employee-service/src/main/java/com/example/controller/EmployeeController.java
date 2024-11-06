package com.example.controller;

import com.example.domain.Employee;
import com.example.domain.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@Transactional
public class EmployeeController {

    @Value("${user.role}")
    private String role;

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    @Cacheable(value = "employees", key = "#root.methodName")
    public List<Employee> employees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    @Cacheable(value = "employees", key = "#id")
    public Employee employee(@PathVariable Long id) {
        return employeeRepository.findById(id).get();
    }


    @PutMapping("/employees")
    @Cacheable(value = "employees", key = "#id")
    public void newEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    @PostMapping("/employees")
    @Cacheable(value = "employees", key = "#id")
    public void updateEmployee(@RequestBody Employee employee) {
        var res = employeeRepository.findById(employee.getId());
        res.ifPresent(r -> {
            r.setSalary(employee.getSalary());
            r.setName(employee.getName());
            r.setCommission(employee.getCommission());
            r.setJob(employee.getJob());
        });
    }

    @DeleteMapping("/employees/{id}")
    @CacheEvict(value = "employees", key = "#id")
    @Cacheable(value = "employees", key = "#id")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
