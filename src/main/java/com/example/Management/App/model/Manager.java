package com.example.Management.App.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "managers")
@JsonPropertyOrder({ "project_name", "manager_id", "manager_name", "employees" })
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer manager_id;

    private String manager_name;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Project project;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "manager-employee")
    private List<Employee> employees;

    @JsonProperty("project_name")
    public String getProjectNameForJson() {
        return (project != null) ? project.getProject_name() : null;
    }
}