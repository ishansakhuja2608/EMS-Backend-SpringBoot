// Creating Spring Data JPA Repository  

package com.fullstack.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.springboot.model.Employee;

// No need to ad @Repository cause spring boot already adds that to JpaRepository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	// All CRUD database methods to interact with the database

}
