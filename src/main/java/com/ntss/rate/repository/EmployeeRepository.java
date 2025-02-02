package com.ntss.rate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntss.rate.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	

}
