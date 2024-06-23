package com.example.HibernateProject.service;

import com.example.HibernateProject.model.Department;
import com.example.HibernateProject.model.Employee;
import com.example.HibernateProject.repository.DepartmentRepository;
import com.example.HibernateProject.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Transactional
    public String deleteDepartment(Long id) {
        List<Employee> employees = employeeRepository.findEmployeesByDepartmentId(id);
        for(Employee emp : employees){
            employeeRepository.delete(emp);
        }
        departmentRepository.deleteById(id);
        return "Department removed !! " + id;
    }
}
