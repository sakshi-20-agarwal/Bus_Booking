package com.sprint.btb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.btb.entity.BusEntity;
import com.sprint.btb.entity.TripEntity;
import com.sprint.btb.entity.BookingEntity;
import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.BusModel;
import com.sprint.btb.model.TripModel;
import com.sprint.btb.repo.BookingRepository;
import com.sprint.btb.repo.BusRepository;
import com.sprint.btb.repo.TripRepository;
import com.sprint.btb.util.BTBUtil;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	BusRepository busRepo;

	@Autowired
	BookingRepository bookingRepo;

	@Override
	public BusModel getBusById(int busId) throws BadRequestException {
		Optional<BusEntity> busEn = busRepo.findById(busId);
		if (busEn.isPresent()) {
			return BTBUtil.convertBusEntityToBusModel(busEn.get());
		}
		throw new BadRequestException("Bus with Id " + busId + " Not Found !!");
	}

	@Override
	public BusModel deleteBusById(int busId) throws BadRequestException {
		Optional<BusEntity> busEn = busRepo.findById(busId);
		if (busEn.isPresent()) {
			busRepo.delete(busEn.get());
			return BTBUtil.convertBusEntityToBusModel(busEn.get());
		}
		throw new BadRequestException("Bus with Id " + busId + " Not Found for deletion !!");
	}

	@Override
	public List<BusModel> getAllBuses() throws BadRequestException {
		List<BusEntity> busEntities = busRepo.findAll();
		if (busEntities.isEmpty()) {
			throw new BadRequestException("No buses found.");
		}
		return BTBUtil.convertListOfBusEntityToModel(busEntities);
	}

	@Override
	public List<BusEntity> getBusesByType(BusEntity.BusType busType) throws BadRequestException {
		List<BusEntity> buses = busRepo.findByBusType(busType);
		if (buses.isEmpty()) {
			throw new BadRequestException("No buses found for this bus type.");
		}
		return buses;
	}

	@Override
	public int getBusSeatCapacity(int busId) throws BadRequestException {
		BusEntity bus = busRepo.findById(busId).orElseThrow(() -> new BadRequestException("Bus not found"));
		return bus.getCapacity();
	}

}
