package com.sprint.btb.util;

import com.sprint.btb.entity.CustomerEntity;
import com.sprint.btb.model.CustomerModel;

public class CustomerUtil {

	public static CustomerModel convertCustomerEntityToCustomerModel(CustomerEntity customer) {
		CustomerModel customerModel = new CustomerModel();
		customerModel.setCustomerId(customer.getCustomerId());
		customerModel.setName(customer.getName());
		customerModel.setEmail(customer.getEmail());
		customerModel.setPhone(customer.getPhone());
		customerModel.setAddressId(customer.getAddressId());
		customerModel.setPassword(customer.getPassword());
		return customerModel;
	}

	public static CustomerEntity convertCustomerModelToCustomerEntity(CustomerModel customerModel) {
		CustomerEntity customer = new CustomerEntity();
		customer.setCustomerId(customerModel.getCustomerId());
		customer.setName(customerModel.getName());
		customer.setEmail(customerModel.getEmail());
		customer.setPhone(customerModel.getPhone());
		customer.setAddressId(customerModel.getAddressId());
		customer.setPassword(customerModel.getPassword());
		return customer;
	}
}
