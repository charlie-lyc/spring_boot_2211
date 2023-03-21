package com.charliecodefactory.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class SpringBootDemoApplication {

	private final CustomerRepository customerRepository;

	public SpringBootDemoApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}


	public static void main(String[] args) {

		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@GetMapping
	public List<Customer> getCustomers() {
//		return List.of();
		return customerRepository.findAll();
	}

	record NewCustomerRequest(
			String name,
			String email,
			Integer age
	) {}

	@PostMapping
	public void addCustomer(@RequestBody NewCustomerRequest request) {
		Customer customer = new Customer();
		customer.setName(request.name());
		customer.setEmail(request.email());
		customer.setAge(request.age());
		customerRepository.save(customer);
	}

	@DeleteMapping("{customerId}")
	public void deleteCustomer(@PathVariable("customerId") Integer id) {
		customerRepository.deleteById(id);
	}

	@PutMapping("{customerId}")
	public void updateCustomer(
			@PathVariable("customerId") Integer id,
			@RequestBody NewCustomerRequest request
	) {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setName(request.name());
		customer.setEmail(request.email());
		customer.setAge(request.age());
		customerRepository.save(customer);
	}
}
