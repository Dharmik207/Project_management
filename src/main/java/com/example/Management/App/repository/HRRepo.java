package com.example.Management.App.repository;

import com.example.Management.App.model.HR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HRRepo extends JpaRepository<HR, Integer> {
}
