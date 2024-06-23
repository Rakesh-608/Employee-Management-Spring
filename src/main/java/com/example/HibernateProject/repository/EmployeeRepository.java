package com.example.HibernateProject.repository;

import com.example.HibernateProject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public List<Employee> findEmployeesByDepartmentId(Long departmentName);

    @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
    List<Employee> findBySalaryGreaterThan(@Param("salary") double salary);

    @Query("SELECT e.name FROM Employee e WHERE e.dateOfJoining <= :fiveYearsAgo")
    List<String> findEmployeesWithMoreThanFiveYears(@Param("fiveYearsAgo") LocalDate fiveYearsAgo);

}
