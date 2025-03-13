package com.sprint.btb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.btb.entity.AddressEntity;
import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.AddressModel;
import com.sprint.btb.repo.AddressRepository;
import com.sprint.btb.util.AddressUtil;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public List<AddressModel> getAllAddresses() {
		List<AddressEntity> entities = addressRepository.findAll();
		return entities.stream().map(AddressUtil::convertAddressEntityToAddressModel).collect(Collectors.toList());
	}

	public AddressModel getAddressById(int addressId) throws BadRequestException {
		AddressEntity entity = addressRepository.findById(addressId)
				.orElseThrow(() -> new BadRequestException("Address not found"));
		return AddressUtil.convertAddressEntityToAddressModel(entity);
	}

	public AddressModel insertAddress(AddressModel addressModel) {
		AddressEntity entity = AddressUtil.convertAddressModelToAddressEntity(addressModel);
		AddressEntity savedEntity = addressRepository.save(entity);
		return AddressUtil.convertAddressEntityToAddressModel(savedEntity);
	}

	public AddressModel updateAddressById(int addressId, AddressModel addressModel) throws BadRequestException {
		AddressEntity entity = addressRepository.findById(addressId)
				.orElseThrow(() -> new BadRequestException("Address not found"));
		entity.setAddress(addressModel.getAddress());
		entity.setCity(addressModel.getCity());
		entity.setState(addressModel.getState());
		entity.setZipCode(addressModel.getZipCode());
		AddressEntity updatedEntity = addressRepository.save(entity);
		return AddressUtil.convertAddressEntityToAddressModel(updatedEntity);
	}

	public void deleteAddressById(int addressId) throws BadRequestException {
		if (!addressRepository.existsById(addressId)) {
			throw new BadRequestException("Address not found");
		}
		addressRepository.deleteById(addressId);
	}
}
