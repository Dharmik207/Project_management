package com.example.Management.App.controller;

import com.example.Management.App.model.Employee;
import com.example.Management.App.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/register")
    public Employee registerEmployee(@RequestBody Employee employee) {

        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {

        return employeeService.getAll();
    }

    @GetMapping("/all/{employee_id}")
    public Employee getEmployeeById(@PathVariable Integer employee_id) {

        return employeeService.getById(employee_id);
    }

    @PutMapping("/update/{employee_id}")
    public Employee updateById(@PathVariable Integer employee_id, @RequestBody Employee details) {
        return employeeService.updateById(employee_id, details);
    }

    @DeleteMapping("/delete/{employee_id}")
    public String delete(@PathVariable Integer employee_id) {

        return employeeService.deleteEmployee(employee_id);
    }

}
