package com.capgemini.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.capgemini.entities.Employee;
import com.capgemini.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
	
	@MockBean
	private EmployeeService employeeService;

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void cretaeEmployeeTest() throws Exception {
		
		Employee e = new Employee();
		e.setName("rohit");
		e.setEmail("rohit@gmail.com");
		e.setMobile("1122334455");
		
		when(employeeService.create(e)).thenReturn(e);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/employee/")
				.content(new ObjectMapper().writeValueAsString(e))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("rohit"));
		
	}
	
	
	@Test
	void findByIdTest() throws Exception{
		Employee e = new Employee();
		e.setName("rohit");
		e.setEmail("rohit@gmail.com");
		e.setMobile("1122334455");
		
		when(employeeService.findById(Mockito.anyInt())).thenReturn(e);
		
		mockMvc.perform(get("/api/employee/1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("rohit"));
		
	}
	
	
	
	

}
