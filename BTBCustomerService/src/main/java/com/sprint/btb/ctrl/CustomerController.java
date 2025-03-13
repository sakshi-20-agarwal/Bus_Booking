package com.sprint.btb.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.CustomerModel;
import com.sprint.btb.model.LoginModel;
import com.sprint.btb.service.CustomerServiceImpl;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerService;

	@PostMapping("/create")
	public CustomerModel createCustomer(@RequestBody CustomerModel customerDTO) throws BadRequestException {
		return customerService.createCustomer(customerDTO);
	}

	@PostMapping("/login")
	public CustomerModel login(@RequestBody LoginModel loginModel) throws BadRequestException {
		return customerService.login(loginModel);
	}

	@GetMapping("/get")
	public List<CustomerModel> fetchAllCustomers() throws BadRequestException {
		return customerService.getAllCustomers();
	}

	@GetMapping("/{customerId}")
	public CustomerModel fetchCustomerById(@PathVariable int customerId) throws BadRequestException {
		return customerService.getCustomerById(customerId);
	}

	@PutMapping("/update/{customerId}")
	public CustomerModel updateCustomerById(@PathVariable int customerId, @RequestBody CustomerModel customerDTO)
			throws BadRequestException {
		return customerService.updateCustomerById(customerId, customerDTO);
	}

	@DeleteMapping("/delete/{customerId}")
	public void deleteCustomerById(@PathVariable int customerId) throws BadRequestException {
		customerService.deleteCustomerById(customerId);
	}

	@GetMapping("/get/{email}")
	public CustomerModel getCustomerById(@PathVariable String email) throws BadRequestException {
		return customerService.getCustomerByEmailId(email);
	}
}
