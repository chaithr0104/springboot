package com.employeeportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.employeeportal.model.Employee;
import com.employeeportal.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public List<Employee> getAllEmployeeDetails() {
		return employeeService.getAllEmployeeDetails();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Employee createEmployee(@RequestBody Employee employee) {
		Employee emp = null;
		if(Optional.ofNullable(employee).isPresent()) {
			emp = employeeService.createEmployee(employee);
		}
		return emp;
	}
}
