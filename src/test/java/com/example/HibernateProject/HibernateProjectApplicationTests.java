package com.example.HibernateProject;

import com.example.HibernateProject.model.Employee;
import com.example.HibernateProject.repository.EmployeeRepository;
import com.example.HibernateProject.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class HibernateProjectApplicationTests {

	@InjectMocks
	private EmployeeService employeeService;

	@Mock
	private EmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testFindAllEmployeesByDepartment() {
		Long departmentId = 1L;
		List<Employee> employees = Arrays.asList(new Employee(), new Employee());

		when(employeeRepository.findEmployeesByDepartmentId(departmentId)).thenReturn(employees);

		List<Employee> result = employeeService.getAllEmployeesByDepartmentId(departmentId);

		assertEquals(2, result.size());
		verify(employeeRepository, times(1)).findEmployeesByDepartmentId(departmentId);

	}

	@Test
	void testDeleteEmployee() {
		Long employeeId = 1L;
		doNothing().when(employeeRepository).deleteById(employeeId);

		employeeService.deleteEmployee(employeeId);

		verify(employeeRepository, times(1)).deleteById(employeeId);
	}

	@Test
	void testFindEmployeesBySalaryGreaterThan() {
		double salary = 50000;
		List<Employee> employees = Arrays.asList(new Employee(), new Employee());

		when(employeeRepository.findBySalaryGreaterThan(salary)).thenReturn(employees);

		List<Employee> result = employeeService.findEmployeesBySalary(salary);

		assertEquals(2, result.size());
		verify(employeeRepository, times(1)).findBySalaryGreaterThan(salary);
	}

	@Test
	void contextLoads() {
	}
}
