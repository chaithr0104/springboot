package com.employeeportal.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.employeeportal.ApplicationTest;
import com.employeeportal.controller.EmployeeController;
import com.employeeportal.enums.Gender;
import com.employeeportal.model.Employee;
import com.employeeportal.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest extends ApplicationTest{

	@InjectMocks
	EmployeeController controller = new EmployeeController();

	@Mock
	EmployeeService employeeService;

	Employee employee = new Employee();
	List<Employee> listEmp = new ArrayList<>();
	@Before
	public void setUp() throws ParseException {
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
		Mockito.when(employeeService.createEmployee(employee)).thenReturn(employee);
		assertNotNull(employee);
		assertEquals(employee.getFirstName(),controller.createEmployee(employee).getFirstName());
	}

	@Test
	public void createEmployeeNullTest() {
		assertNotNull(employee);
		assertNull(controller.createEmployee(null));
	}

	@Test
	public void getAllEmployeeDetailsTest() {
		Mockito.when(employeeService.getAllEmployeeDetails()).thenReturn(listEmp);
		assertNotNull(listEmp);
		assertEquals(listEmp,controller.getAllEmployeeDetails());
	}

}
