package com.ntss.rate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntss.rate.model.Employee;
import com.ntss.rate.repository.EmployeeRepository;
import com.ntss.rate.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	


	 @Autowired
	    private EmployeeRepository repository;

	    public List<Employee> getAllEmployees() {
	        return repository.findAll();
	    }

	    public Employee getEmployeeById(Long id) {
	        return repository.findById(id).orElse(null);
	    }

	    public Employee saveEmployee(Employee employee) {
	        return repository.save(employee);
	    }

	    public void deleteEmployee(Long id) {
	        repository.deleteById(id);
	    }

		
	

}
