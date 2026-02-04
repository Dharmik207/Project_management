package com.example.Management.App.service;

import com.example.Management.App.model.Employee;
import com.example.Management.App.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo repository;

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getById(Integer employee_id) {
        return repository.findById(employee_id).orElse(new Employee(0, null, null, null));
    }

    public Employee updateById(Integer employee_id, Employee details) {
        Employee existing = repository.getById(employee_id);

        if (existing != null) {
            existing.setEmployee_name(details.getEmployee_name());
            existing.setManager(details.getManager());
            existing.setHr(details.getHr());
            return repository.save(existing);
        }
        return null;
    }

    public String deleteEmployee(Integer employee_id) {
         if(repository.existsById(employee_id)) {
            repository.deleteById(employee_id);
            return "Employee deleted successfully.";
        }
        return "Employee not found.";
    }

}