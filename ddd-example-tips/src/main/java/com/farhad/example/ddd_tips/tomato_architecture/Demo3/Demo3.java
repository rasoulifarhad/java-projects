package com.farhad.example.ddd_tips.tomato_architecture.Demo3;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

public class Demo3 {
	private static final int PAGE_SIZE = 10;
	interface Customer {

	}
	interface CustomerRepository extends JpaRepository<Customer, String>{

	}

	interface PagedResult<Customer> {

	}
	static class DontDoThis {

		@Service
		@Transactional
		@RequiredArgsConstructor
		static class CustomerService {
			private final CustomerRepository customerRepository;

			PagedResult<Customer> getCustomer(Integer pageNo) {
				Pageable pageable = PageRequest.of(pageNo, PAGE_SIZE, Sort.by("name"));
				Page<Customer> customersPage = customerRepository.findAll(pageable); 
				return convertToPageResult(customersPage);
			}

			private PagedResult<Customer> convertToPageResult(Page<Customer> customersPage) {
				return null;
			}
		}
	}

	// This way any persistence library changes will only affect repository layer only.
	static class DoThis {

		interface CustomerRepository {

			PagedResult<Customer> findAll(Integer pageNo);
			
		}
		@Service
		@Transactional
		@RequiredArgsConstructor
		static class CustomerService {
			private final CustomerRepository customerRepository;

			PagedResult<Customer> getCustomer(Integer pageNo) {
				return customerRepository.findAll(pageNo);
			}
		}

		@Repository 
		@RequiredArgsConstructor
		static class JpaCustomerRepository implements CustomerRepository {
			private final JpaRepository<Customer, String> jpaRepository;  
			public PagedResult<Customer> findAll(Integer pageNo) {
				Pageable pageable = PageRequest.of(pageNo, PAGE_SIZE, Sort.by("name"));
				Page<Customer> customersPage = jpaRepository.findAll(pageable); 
				return convertToPageResult(customersPage);
			}
			private PagedResult<Customer> convertToPageResult(Page<Customer> customersPage) {
				return null;
			}  
		}
	}
}
