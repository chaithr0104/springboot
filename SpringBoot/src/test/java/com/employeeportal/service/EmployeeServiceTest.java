package com.employeeportal.service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.jupiter.api.Test;

import com.employeeportal.ApplicationTest;
import com.employeeportal.enums.Gender;
import com.employeeportal.model.Employee;
import com.employeeportal.repository.EmployeeRepository;
import com.employeeportal.service.EmployeeService;
//import io.cucumber.java.Before;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest extends ApplicationTest{
	
	@InjectMocks
	EmployeeService service = new EmployeeService();

	@Mock
	EmployeeRepository employeeRepo;

	Employee employee = new Employee();
	List<Employee> listEmp = new ArrayList<>();
	@Before
	public void init() throws ParseException {
		MockitoAnnotations.initMocks(this);
		employee.setFirstName("Chaithra");
		employee.setLastName("Gangaraj");	
		employee.setGender(Gender.FEMALE);
		employee.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("12-02-1995"));
		employee.setDepartment("CSE");
		listEmp.add(employee);
		
	}
	
	@Test
	public void createEmployeeTest() {
		Mockito.when(employeeRepo.save(employee)).thenReturn(employee);
		assertNotNull(employee);
		assertNotNull(service.createEmployee(employee));
		assertEquals("Gangaraj", service.createEmployee(employee).getLastName());
	}

	@Test
	public void getAllEmployeeDetailsTest() {
		Mockito.when(employeeRepo.findAll()).thenReturn(listEmp);
		assertNotNull(listEmp);
		assertEquals(listEmp,service.getAllEmployeeDetails());
	}
}
