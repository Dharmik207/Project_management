package com.example.Management.App.service;

import com.example.Management.App.model.Project;
import com.example.Management.App.repository.ProjectRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepo repository;

    public Project saveProject(Project project) {
        return repository.save(project);
    }

    public List<Project> getAll() {
        return repository.findAll();
    }

    public Project findById(Integer project_id) {
        return repository.findById(project_id).orElse(null);
    }

    public String delete(Integer project_id){
        if(repository.existsById(project_id)){
            repository.deleteById(project_id);
            return "Project deleted successfully.";
        }
        return "Project not found.";
    }
}
