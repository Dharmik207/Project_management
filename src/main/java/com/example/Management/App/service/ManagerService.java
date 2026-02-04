package com.example.Management.App.service;

import com.example.Management.App.model.Manager;
import com.example.Management.App.repository.ManagerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ManagerRepo repository;

    public Manager save(Manager manager) {
        return repository.save(manager); }

    public List<Manager> getAll() {
        return repository.findAll();
    }

    public Manager findById(Integer manager_id) {
        return repository.findById(manager_id).orElse(null);
    }

    public String delete(Integer manager_id) {
        if (repository.existsById(manager_id)) {
            repository.deleteById(manager_id);
            return "Manager deleted successfully.";
        }
        return "Manager not found.";
    }
}