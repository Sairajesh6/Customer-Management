
package com.cu.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cu.customer.entity.Customer;
import com.cu.customer.service.CustomerService;


@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	

	@GetMapping("/customerlist")
	public String getAllCustomers(Model model) {
		model.addAttribute("listcustomer", customerService.allCustomers());
		return "CustomerList";

	}
	@GetMapping("/NewCustomerForm")
	public String showNewEmployeeForm(Model model) {

		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "AddCustomer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer)
	{
		customerService.addNewCustomer(customer);
		return "redirect:/customerlist";
		
	}
	@PostMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("updatecustomer") Customer customer)
	{
		customerService.updateCustomer(customer);
		return "redirect:/customerlist";
		
	}
	@GetMapping("/showFormForUpdate/{cusid}")
	public String showFormForUpdate(@PathVariable(value = "cusid") int id, Model model) {

		Customer customer = customerService.getcustomerById(id);

		model.addAttribute("updatecustomer", customer);
		return "UpdateCustomer";
		
	}
	
	
	@GetMapping("/deleteEmployee/{cusid}")
	public String deleteEmployee(@PathVariable(value = "cusid") int id) {
		this.customerService.deleteById(id);
		return "redirect:/customerlist";
	}
    
}
