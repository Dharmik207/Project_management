package com.example.Management.App.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hr_department")
@JsonPropertyOrder({ "hr_id", "hr_name", "employees" })
public class HR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hr_id;

    private String hr_name;

    @OneToMany(mappedBy = "hr", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "hr-employee")
    private List<Employee> employees;

}