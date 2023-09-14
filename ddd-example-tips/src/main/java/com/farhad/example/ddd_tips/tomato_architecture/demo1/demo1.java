package com.farhad.example.ddd_tips.tomato_architecture.demo1;

import java.time.Instant;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

public class demo1 {
	static class EmailAlreadyInUseException extends RuntimeException {

		public EmailAlreadyInUseException(String email) {
		}
		
	}
	interface Customer {
		String getEmail();
		void setCreatedAt(Instant now);
	}
	interface CustomerService {
		void save(Customer customer);
		boolean existByEmail(String email);
	}
	interface CustomerRepository {

		boolean existByEmail(String email);

		void save(Customer customer);

	}
	static class DontDoThis {

		@RestController
		@RequiredArgsConstructor
		class CustomerController {
			private final CustomerService customerService;

			@PostMapping("/api/customers")
			void createCustomer(@RequestBody Customer customer) {
				if (customerService.existByEmail(customer.getEmail())) {
					throw new EmailAlreadyInUseException(customer.getEmail());
				}
				customer.setCreatedAt(Instant.now());
				customerService.save(customer);
			}
		}
	}

	// With this approach, whether you try to create a Customer from a REST API call or from a CLI, all the business logic is 
	// centralized in Application Core
	static class DoThis {

		@RestController
		@RequiredArgsConstructor
		class CustomerController {
			private final CustomerService customerService;

			@PostMapping("/api/customers")
			void createCustomer(@RequestBody Customer customer) {
				customerService.save(customer);
			}
		}
		@Service
		@Transactional
		@RequiredArgsConstructor
		static class CustomerService {
			private final CustomerRepository customerRepository;

			void save(Customer customer) {
				if ( customerRepository.existByEmail(customer.getEmail())) {
					throw new EmailAlreadyInUseException(customer.getEmail());
				}
				customer.setCreatedAt(Instant.now());
				customerRepository.save(customer);
			}
		}
	}
}
