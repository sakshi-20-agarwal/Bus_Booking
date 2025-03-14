package com.sprint.btb.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sprint.btb.entity.BusEntity;
import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.BusModel;
import com.sprint.btb.repo.BusRepository;
import com.sprint.btb.service.BusService;
import com.sprint.btb.service.BusServiceImpl;
import com.sprint.btb.util.BTBUtil;

@RestController
@RequestMapping("/api/buses")
public class BusController {

	@Autowired
	BusServiceImpl busService;

	@Autowired
	BusRepository busRepo;

	@GetMapping("/")
	public List<BusModel> fetchAllBuses() throws BadRequestException {
		return busService.getAllBuses();
	}

	@GetMapping("/id/{busId}")
	public BusModel fetchBusById(@PathVariable int busId) throws BadRequestException {
		return busService.getBusById(busId);
	}

	@DeleteMapping("/buses/{busId}")
	public BusModel deleteBusById(@PathVariable int busId) throws BadRequestException {
		return busService.deleteBusById(busId);
	}

	@GetMapping("/{busId}/seats")
	public int fetchBusSeats(@PathVariable int busId) throws BadRequestException {
	    BusEntity bus = busRepo.findById(busId).orElseThrow(() -> new BadRequestException("Bus not found"));
	    return bus.getCapacity();
	}

	@GetMapping("/type/{bus_type}")
	public List<BusEntity> fetchBusesByType(@PathVariable("bus_type") String busType) throws BadRequestException {
		try {
			BusEntity.BusType busEnumType = BusEntity.BusType.valueOf(busType);
			List<BusEntity> buses = busService.getBusesByType(busEnumType);
			return buses;
		} catch (IllegalArgumentException e) {
			throw new BadRequestException("Invalid bus type provided: " + busType);
		} catch (Exception e) {
			throw new BadRequestException("An unexpected error occurred: " + e.getMessage());
		}
	}
	

}
