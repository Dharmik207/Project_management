package com.example.Management.App.controller;

import com.example.Management.App.model.Project;
import com.example.Management.App.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/create")
    public Project addProject(@RequestBody Project project) {

        return projectService.saveProject(project);
    }

    @GetMapping("/all")
    public List<Project> getAllProjects() {

        return projectService.getAll();
    }

    @GetMapping("/all/{project_id}")
    public Project getProjectById(@PathVariable Integer project_id){

        return projectService.findById(project_id);
    }

    @DeleteMapping("/delete/{project_id}")
    public String deleteProject(@PathVariable Integer project_id) {
        return projectService.delete(project_id);
    }

}