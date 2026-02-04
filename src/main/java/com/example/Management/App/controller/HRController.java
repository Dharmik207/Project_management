package com.example.Management.App.controller;

import com.example.Management.App.model.HR;
import com.example.Management.App.service.HRService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project/hr")
@RequiredArgsConstructor
public class HRController {


    private final HRService hrService;

    @PostMapping("/add")
    public HR createHRDepartment(@RequestBody HR hr) {

        return hrService.save(hr);
    }

    @GetMapping("/all")
    public List<HR> getAllHR() {

        return hrService.getAll();
    }

    @GetMapping("/all/{hr_id}")
    public HR getHRById(@PathVariable Integer hr_id) {

        return hrService.findById(hr_id);
    }

    @DeleteMapping("/delete/{hr_id}")
    public String deleteHR(@PathVariable Integer hr_id) {
        return hrService.delete(hr_id);
    }
}
