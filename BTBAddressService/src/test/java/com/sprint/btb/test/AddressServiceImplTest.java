package com.sprint.btb.test;



import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.sprint.btb.entity.AddressEntity;
import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.AddressModel;
import com.sprint.btb.repo.AddressRepository;
import com.sprint.btb.service.AddressServiceImpl;
import com.sprint.btb.util.AddressUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;


@ExtendWith(MockitoExtension.class)

class AddressServiceImplTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressServiceImpl addressService;

    private AddressEntity addressEntity;
    private AddressModel addressModel;

    @BeforeEach
    void setUp() {
      

        addressEntity = new AddressEntity();
        addressEntity.setAddress("123 Main St");
        addressEntity.setCity("Springfield");
        addressEntity.setState("IL");
        addressEntity.setZipCode("62701");

        addressModel = new AddressModel();
        addressModel.setAddress("123 Main St");
        addressModel.setCity("Springfield");
        addressModel.setState("IL");
        addressModel.setZipCode("62701");
    }

    @Test
    void testGetAllAddresses() {
        when(addressRepository.findAll()).thenReturn(Arrays.asList(addressEntity));


        List<AddressModel> addresses = addressService.getAllAddresses();

        assertNotNull(addresses);
        assertEquals(1, addresses.size());
        assertEquals(addressModel.getAddress(), addresses.get(0).getAddress());

    }

    @Test
    void testGetAddressById_Success() throws BadRequestException {
        when(addressRepository.findById(1)).thenReturn(Optional.of(addressEntity));

        AddressModel foundAddress = addressService.getAddressById(1);

        assertNotNull(foundAddress);
        assertEquals(addressModel.getAddress(), foundAddress.getAddress());

    }

    @Test
    void testGetAddressById_NotFound() {
        
        when(addressRepository.findById(1)).thenReturn(Optional.empty());

        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            addressService.getAddressById(1);
        });

        assertEquals("Address not found", thrown.getMessage());
    }

    @Test
    void testInsertAddress() {
        when(addressRepository.save(any(AddressEntity.class))).thenReturn(addressEntity);

        AddressModel insertedAddress = addressService.insertAddress(addressModel);

        assertNotNull(insertedAddress);
        assertEquals(addressModel.getAddress(), insertedAddress.getAddress());

    }

    @Test
    void testUpdateAddressById_Success() throws BadRequestException {
        when(addressRepository.findById(1)).thenReturn(Optional.of(addressEntity));
        when(addressRepository.save(any(AddressEntity.class))).thenReturn(addressEntity);

        AddressModel updatedAddress = addressService.updateAddressById(1, addressModel);

        assertNotNull(updatedAddress);
        assertEquals(addressModel.getAddress(), updatedAddress.getAddress());

    }

    @Test
    void testUpdateAddressById_NotFound() {
        
        when(addressRepository.findById(1)).thenReturn(Optional.empty());

        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            addressService.updateAddressById(1, addressModel);
        });

        assertEquals("Address not found", thrown.getMessage());
    }

    @Test
    void testDeleteAddressById_Success() throws BadRequestException {
        
        when(addressRepository.existsById(1)).thenReturn(true);

        addressService.deleteAddressById(1);

    }

    @Test
    void testDeleteAddressById_NotFound() {
        
        when(addressRepository.existsById(1)).thenReturn(false);

        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            addressService.deleteAddressById(1);
        });

        assertEquals("Address not found", thrown.getMessage());
    }
}

