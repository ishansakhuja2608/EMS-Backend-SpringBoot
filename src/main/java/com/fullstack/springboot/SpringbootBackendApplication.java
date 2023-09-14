package com.fullstack.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fullstack.springboot.model.Employee;
import com.fullstack.springboot.repository.EmployeeRepository;

@SpringBootApplication
// Implementing CommandlineRunner interface, will provide a run method
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	
	// It executes whenever out spring boot application starts for the first time
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// Dummy data has been added to the database
//		Employee employee = new Employee();
//		employee.setFirstName("Ishan");
//		employee.setLastName("Sakhuja");
//		employee.setEmailId("ishansakhuja26@gmail.com");
//		employeeRepository.save(employee);
//		
//		Employee employee1 = new Employee();
//		employee1.setFirstName("Puerile");
//		employee1.setLastName("Plays");
//		employee1.setEmailId("iishaaaaaaan.yt@gmail.com");
//		employeeRepository.save(employee1);
		
	}

}
