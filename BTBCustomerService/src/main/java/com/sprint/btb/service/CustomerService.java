package com.sprint.btb.service;

import java.util.List;
import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.CustomerModel;
import com.sprint.btb.model.LoginModel;


public interface CustomerService {
	List<CustomerModel> getAllCustomers() throws BadRequestException;
	CustomerModel getCustomerById(int customerId) throws BadRequestException;
	CustomerModel createCustomer(CustomerModel customerDTO) throws BadRequestException; 
    CustomerModel updateCustomerById(int customerId, CustomerModel customerDTO) throws BadRequestException;
    void deleteCustomerById(int customerId) throws BadRequestException;
	CustomerModel login(LoginModel loginModel) throws BadRequestException;
	CustomerModel getCustomerByEmailId(String email) throws BadRequestException;
}
