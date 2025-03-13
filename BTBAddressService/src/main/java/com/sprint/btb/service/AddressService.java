package com.sprint.btb.service;

import java.util.List;

import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.AddressModel;

public interface AddressService {
	List<AddressModel> getAllAddresses();

	AddressModel getAddressById(int addressId) throws BadRequestException;

	AddressModel insertAddress(AddressModel addressModel);

	AddressModel updateAddressById(int addressId, AddressModel addressModel) throws BadRequestException;

	void deleteAddressById(int addressId) throws BadRequestException;
}
