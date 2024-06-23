package com.example.HibernateProject.service;

import com.example.HibernateProject.model.Employee;
import com.example.HibernateProject.repository.DepartmentRepository;
import com.example.HibernateProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "Employee removed !! " + id;
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setSalary(employee.getSalary());
            return employeeRepository.save(existingEmployee);
        } else {
            return null;
        }
    }

    public List<Employee> getAllEmployeesByDepartmentId(Long departmentId) {
        return employeeRepository.findEmployeesByDepartmentId(departmentId);
    }

    public List<String> findEmployeesWithMoreThanFiveYears(LocalDate fiveYearsAgo){
        fiveYearsAgo = LocalDate.now().minusYears(5);
        return employeeRepository.findEmployeesWithMoreThanFiveYears(fiveYearsAgo);
    }

    public List<Employee> findEmployeesBySalary(double salary) {
        return employeeRepository.findBySalaryGreaterThan(salary);
    }


}
