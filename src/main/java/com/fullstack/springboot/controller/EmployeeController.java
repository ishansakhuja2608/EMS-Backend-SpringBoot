// Creating GetAllEmployee REST API

/*
 * @CrossOrigin("*")
 * Since we're running the REST API and FE on different ports, we have to use this. Passing * means any client would be 
 * able to access the REST API, be it react application or angular application
   we can also pass an origin, (origins = {"http://localhost:3000/"}) // in this way only this client would be able to
   access the REST APIs
 
 */

package com.fullstack.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.springboot.exception.ResourceNotFoundException;
import com.fullstack.springboot.model.Employee;
import com.fullstack.springboot.repository.EmployeeRepository;

@CrossOrigin("*")
@RestController // becomes spring MVC rest controller, capable to handle HTTP Requests
@RequestMapping("/api/v1/employees") // Defining a common base URL for the REST APIs
public class EmployeeController {

	@Autowired // Autowiring the EmployeeRepository dependency
	private EmployeeRepository employeeRepository;

	// We need to fetch the list of employees from the database, using the findAl()
	// method of the JPA Repository
	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

// Build create employee REST API
	@PostMapping
	// RequestBody annotation will convert the JSON object to java object
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	// Get Employee by id, ResponseEntity, used to construct the response of a rest
	// api
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
		return ResponseEntity.ok(employee);
	}

	// Update Employee Rest API
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
	    Employee updateEmployee = employeeRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
	    updateEmployee.setFirstName(employeeDetails.getFirstName());
	    updateEmployee.setLastName(employeeDetails.getLastName());
	    updateEmployee.setEmailId(employeeDetails.getEmailId());
	    
	    // Save the updated employee to the database
	    employeeRepository.save(updateEmployee);
	    
	    return ResponseEntity.ok(updateEmployee);
	}
	
	// Build Delete  Employee REST API
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
		Employee employee = employeeRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
		
		employeeRepository.delete(employee);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


}
