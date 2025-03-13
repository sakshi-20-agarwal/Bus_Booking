package com.sprint.btb.util;

import java.util.List;
import java.util.stream.Collectors;

import com.sprint.btb.entity.AddressEntity;
import com.sprint.btb.model.AddressModel;

public class AddressUtil {
	public static AddressEntity convertAddressModelToAddressEntity(AddressModel model) {
        AddressEntity entity = new AddressEntity();
        entity.setAddressId(model.getAddressId());
        entity.setAddress(model.getAddress());
        entity.setCity(model.getCity());
        entity.setState(model.getState());
        entity.setZipCode(model.getZipCode());
        return entity;
    }

    public static AddressModel convertAddressEntityToAddressModel(AddressEntity entity) {
        AddressModel model = new AddressModel();
        model.setAddressId(entity.getAddressId());
        model.setAddress(entity.getAddress());
        model.setCity(entity.getCity());
        model.setState(entity.getState());
        model.setZipCode(entity.getZipCode());
        return model;
    }
    
    public static List<AddressModel> convertAddressEntitiesToAddressModels(List<AddressEntity> entities) {
        return entities.stream()
                .map(AddressUtil::convertAddressEntityToAddressModel)
                .collect(Collectors.toList());
    }
}
