package com.example.HibernateProject.controller;


import com.example.HibernateProject.model.Department;
import com.example.HibernateProject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        return departmentService.deleteDepartment(id);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @GetMapping
    public Iterable<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
}

