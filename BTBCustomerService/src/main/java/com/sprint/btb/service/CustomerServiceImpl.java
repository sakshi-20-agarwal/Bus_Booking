package com.sprint.btb.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.sprint.btb.entity.CustomerEntity;
import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.AddressModel;
import com.sprint.btb.model.CustomerModel;
import com.sprint.btb.model.LoginModel;
import com.sprint.btb.repo.CustomerRepository;
import com.sprint.btb.util.CustomerUtil;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;  

    @Override
    public CustomerModel createCustomer(CustomerModel customerModel) throws BadRequestException {
        try {
            System.out.println("Creating customer with details: " + customerModel);
            if (customerRepository.findByEmail(customerModel.getEmail()) != null) {
                throw new BadRequestException("Email already exists");
            }
            String url = "http://localhost:9091/api/addresses/" + customerModel.getAddressId();
            AddressModel addressModel = restTemplate.getForObject(url, AddressModel.class);
            if (addressModel == null) {
                throw new BadRequestException("Address not found for addressId: " + customerModel.getAddressId());
            }
            CustomerEntity customerEntity = CustomerUtil.convertCustomerModelToCustomerEntity(customerModel);
            System.out.println("Saving customer to the database: " + customerEntity);
            customerEntity = customerRepository.save(customerEntity);
            customerModel.setCustomerId(customerEntity.getCustomerId());
            System.out.println("Customer saved successfully with ID: " + customerModel.getCustomerId());
            return customerModel;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException("Error creating customer: " + e.getMessage());
        }
    }

    @Override
    public CustomerModel login(LoginModel loginModel) throws BadRequestException {
        CustomerEntity customer = customerRepository.findByEmail(loginModel.getEmail());

        if (customer != null) {
            if (customer.getPassword().equals(loginModel.getPassword())) {
                return CustomerUtil.convertCustomerEntityToCustomerModel(customer);
            } else {
                throw new BadRequestException("Password doesn't match.");
            }
        } else {
            throw new BadRequestException("User with given email not found!");
        }
    }

    @Override
    public List<CustomerModel> getAllCustomers() throws BadRequestException {
    	try {
            List<CustomerEntity> customers = customerRepository.findAll();
            return CustomerUtil.convertCustomerEntitiesToCustomerModels(customers);
        } catch (Exception e) {
            throw new BadRequestException("Error fetching customers");
        }
    }

    @Override
    public CustomerModel getCustomerById(int customerId) throws BadRequestException {
        try {
            CustomerEntity customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new BadRequestException("Customer not found"));
            CustomerModel customerModel = CustomerUtil.convertCustomerEntityToCustomerModel(customer);
            String url = "http://localhost:9091/api/addresses/" + customer.getAddressId();
            AddressModel addressModel = restTemplate.getForObject(url, AddressModel.class);
            return customerModel;
        } catch (Exception e) {
            throw new BadRequestException("Error fetching customer");
        }
    }

    @Override
    public CustomerModel updateCustomerById(int customerId, CustomerModel customerModel) throws BadRequestException {
        try {
            CustomerEntity customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new BadRequestException("Customer not found"));
            customer.setName(customerModel.getName());
            customer.setEmail(customerModel.getEmail());
            customer.setPhone(customerModel.getPhone());
            customer.setAddressId(customerModel.getAddressId());
            customer.setPassword(customerModel.getPassword());
            customer = customerRepository.save(customer);
            customerModel.setCustomerId(customer.getCustomerId());
            return customerModel;
        } catch (Exception e) {
            throw new BadRequestException("Error updating customer");
        }
    }

    @Override
    public void deleteCustomerById(int customerId) throws BadRequestException {
        try {
            CustomerEntity customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new BadRequestException("Customer not found"));
            customerRepository.delete(customer);
        } catch (Exception e) {
            throw new BadRequestException("Error deleting customer");
        }
    }
    
    @Override
    public CustomerModel getCustomerByEmailId(String email) throws BadRequestException{
        // Find customer by email
        CustomerEntity customer = customerRepository.findByEmail(email);
        
        // Check if customer is null
        if (customer == null) {
            throw new BadRequestException("Customer with email " + email + " not found");
        }
        
        // Convert the customer entity to a model if found
        CustomerModel cModel = CustomerUtil.convertCustomerEntityToCustomerModel(customer);
        return cModel;
    }
}
