package com.example;

import com.example.domain.Employee;
import com.example.domain.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {
	private final EmployeeRepository employeeRepository;

	public Application(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return args ->{
			Employee e1 = new Employee();
			e1.setJob("Programmer");
			e1.setName("Piotr Malinowski");
			e1.setSalary(123);
			employeeRepository.save(e1);
		};
	}

}
