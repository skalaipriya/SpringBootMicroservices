package com.example.department.controller;

import com.example.department.entity.Department;
import com.example.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("In DepartmentController - saveDeparment, calling department Service for saving department");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartment(@PathVariable("id") Long departmentId){
        log.info("In DepartmentController - getDepartment, calling department Service for getting department with ID: "+ departmentId);
        return departmentService.getDepartment(departmentId);
    }
}
