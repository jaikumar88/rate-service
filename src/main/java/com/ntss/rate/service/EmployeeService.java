package com.ntss.rate.service;

import java.util.List;

import com.ntss.rate.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Long id);


	Employee saveEmployee(Employee employee);

	 void deleteEmployee(Long id);
	

}
