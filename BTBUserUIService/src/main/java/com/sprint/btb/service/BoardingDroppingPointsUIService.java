package com.sprint.btb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.sprint.btb.model.AddressModel;
import com.sprint.btb.exception.BadRequestException;

import java.util.List;

@Service
public class BoardingDroppingPointsUIService {

    

    @Autowired
    private RestTemplate restTemplate;

    // Fetch all addresses (boarding and dropping points)
    public List<AddressModel> fetchAddresses() throws BadRequestException {
        try {
            String url = "http://localhost:9091/api/addresses/";  // Correct URL to fetch all addresses
            UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url)
                    .encode()
                    .build();
            
            AddressModel[] addressModels = restTemplate.getForObject(uriComponents.toUriString(), AddressModel[].class);
            
            if (addressModels != null && addressModels.length > 0) {
                return List.of(addressModels);
            } else {
                throw new BadRequestException("No addresses found.");
            }
        } catch (Exception e) {
            throw new BadRequestException("Failed to fetch addresses.");
        }
    }
}
