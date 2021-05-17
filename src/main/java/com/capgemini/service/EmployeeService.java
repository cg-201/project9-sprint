package com.capgemini.service;

import com.capgemini.entities.Employee;

public interface EmployeeService {
	
	public Employee create(Employee employee);
	public Employee findById(int id);

}
