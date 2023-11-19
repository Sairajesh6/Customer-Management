package com.cu.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cu.customer.entity.Customer;
import com.cu.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> allCustomers() {
		return customerRepository.findAll();
	}

	public Customer addNewCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getcustomerById(int id) {
		Optional<Customer> optional = customerRepository.findById(id);
		Customer customer = null;
		if (optional.isPresent()) {
			customer = optional.get();
		} else {
			throw new RuntimeException(" customer not found  id :: " + id);
		}
		return customer;
	}
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	public void deleteById(int id) {
		this.customerRepository.deleteById(id);

	}

}
