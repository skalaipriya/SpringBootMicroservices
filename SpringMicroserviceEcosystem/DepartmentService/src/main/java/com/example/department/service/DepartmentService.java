package com.example.department.service;

import com.example.department.entity.Department;
import com.example.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department){
        log.info("In department Service - saveDepartment method, Saving department... ");
        return departmentRepository.save(department);
    }

    public Optional<Department> getDepartment(Long id){
        log.info("In department Service - getDepartment method, getting department for id ... "+ id);
        return departmentRepository.findById(id);
    }
}
