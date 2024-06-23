package com.example.HibernateProject.controller;

import com.example.HibernateProject.model.Employee;
import com.example.HibernateProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/department/{departmentId}")
    public List<Employee> getAllEmployeesByDepartment(@PathVariable Long departmentId) {
        return employeeService.getAllEmployeesByDepartmentId(departmentId);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/salary/{amount}")
    public List<Employee> getEmployeesBySalaryGreaterThan(@PathVariable double amount) {
        return employeeService.findEmployeesBySalary(amount);
    }

    @GetMapping("/with-more-than-five-years")
    public List<String> getEmployeesWithMoreThanFiveYears() {
        LocalDate fiveYearsAgo = LocalDate.now().minusYears(5);
        return employeeService.findEmployeesWithMoreThanFiveYears(fiveYearsAgo);
    }
}

