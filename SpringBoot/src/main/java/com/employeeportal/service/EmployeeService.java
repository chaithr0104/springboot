package com.employeeportal.service;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employeeportal.model.Employee;
import com.employeeportal.repository.EmployeeRepository;
@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;
	
	public List<Employee> getAllEmployeeDetails() {
		List<Employee> employeeList = employeeRepo.findAll();
		employeeList.sort(Comparator.comparing(Employee::getFirstName));
		return employeeList;
	}

	
	public Employee createEmployee(Employee emp) {
		Employee employee =  null;
		if(Optional.ofNullable(emp).isPresent()) {
			employee = employeeRepo.save(emp);
		}
		return employee;
		
	}

}
