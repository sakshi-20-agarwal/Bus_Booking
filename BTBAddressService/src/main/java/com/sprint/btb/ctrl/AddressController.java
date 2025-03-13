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

import com.sprint.btb.entity.AddressEntity;
import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.AddressModel;
import com.sprint.btb.service.AddressService;
import com.sprint.btb.service.AddressServiceImpl;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

	@Autowired
	private AddressServiceImpl addressService;

	@GetMapping("/")
	public List<AddressModel> fetchAllAddresses() {
		return addressService.getAllAddresses();
	}

	@GetMapping("/{id}")
	public AddressModel fetchAddressById(@PathVariable("id") int addressId) throws BadRequestException {
		return addressService.getAddressById(addressId);
	}

	@PostMapping("/add")
	public AddressModel addAddress(@RequestBody AddressModel addressModel) {
		return addressService.insertAddress(addressModel);
	}

	@PutMapping("/update/{id}")
	public AddressModel updateAddressById(@PathVariable("id") int addressId, @RequestBody AddressModel addressModel)
			throws BadRequestException {
		return addressService.updateAddressById(addressId, addressModel);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteAddressById(@PathVariable("id") int addressId) throws BadRequestException {
		addressService.deleteAddressById(addressId);
	}
}
