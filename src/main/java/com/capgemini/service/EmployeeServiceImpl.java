package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Employee;
import com.capgemini.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee create(Employee employee) {

		employeeRepository.save(employee);
		
		return employee;
	}

	@Override
	public Employee findById(int id) {
		
		Employee employee =  employeeRepository.findById(id).get();
		
		return employee;
	}

}
