package com.example.Management.App.service;

import com.example.Management.App.model.HR;
import com.example.Management.App.repository.HRRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HRService {

    private final HRRepo repository;

    public HR save(HR hr) {
        return repository.save(hr);
    }

    public List<HR> getAll() {
        return repository.findAll();
    }

    public HR findById(Integer hr_id) {

        return repository.findById(hr_id).orElse(null);
    }

    public String delete(Integer hr_id) {
        if (repository.existsById(hr_id)) {
            repository.deleteById(hr_id);
            return "HR deleted successfully.";
        }
        return "HR not found.";
    }

}
