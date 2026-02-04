package com.example.Management.App.controller;

import com.example.Management.App.model.Manager;
import com.example.Management.App.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project/managers")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping("/add")
    public Manager addManager(@RequestBody Manager manager) {

        return managerService.save(manager);
    }

    @GetMapping("/all")
    public List<Manager> getAllManagers() {

        return managerService.getAll();
    }

    @GetMapping("/all/{manager_id}")
    public Manager getManagerById(@PathVariable Integer manager_id) {

        return managerService.findById(manager_id);
    }

    @DeleteMapping("/delete/{manager_id}")
    public String deleteManager(@PathVariable Integer manager_id) {

        return managerService.delete(manager_id);
    }
}
