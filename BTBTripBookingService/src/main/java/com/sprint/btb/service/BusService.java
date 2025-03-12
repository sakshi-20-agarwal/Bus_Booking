package com.sprint.btb.service;

import java.util.List;

import com.sprint.btb.entity.BusEntity;
import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.BusModel;
import com.sprint.btb.model.TripModel;

public interface BusService {

	public BusModel getBusById(int busId) throws BadRequestException;
	public BusModel deleteBusById(int busId) throws BadRequestException;
	public List<BusModel> getAllBuses() throws BadRequestException;
	public List<BusEntity> getBusesByType(BusEntity.BusType busType) throws BadRequestException;


	public int getBusSeatCapacity(int busId) throws BadRequestException;

}
