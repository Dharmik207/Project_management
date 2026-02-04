package com.example.Management.App.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;

    private String employee_name;

    @ManyToOne
    @JoinColumn(name = "hr_id")
    @JsonBackReference(value = "hr-employee")
    private HR hr;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    @JsonBackReference(value = "manager-employee")
    private Manager manager;

//    public Employee(Integer employee_id, String employee_name) {
//        this.employee_id = employee_id;
//        this.employee_name = employee_name;
//    }

}