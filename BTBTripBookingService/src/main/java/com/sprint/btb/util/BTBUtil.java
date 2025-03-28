package com.sprint.btb.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sprint.btb.entity.BookingEntity;
import com.sprint.btb.entity.BusEntity;
import com.sprint.btb.entity.RouteEntity;
import com.sprint.btb.entity.TripEntity;
import com.sprint.btb.model.BookingModel;
import com.sprint.btb.model.BusModel;
import com.sprint.btb.model.RouteModel;
import com.sprint.btb.model.TripModel;

public class BTBUtil {

	// ---------------------------ROUTE CONVERSIONS---------------------------//

	public static RouteModel convertRouteEntityToRouteModel(RouteEntity routeEntity) {

		RouteModel routeModel = new RouteModel();
		routeModel.setRouteId(routeEntity.getRouteId());
		routeModel.setFromCity(routeEntity.getFromCity());
		routeModel.setToCity(routeEntity.getToCity());
		routeModel.setBreakPoints(routeEntity.getBreakPoints());
		routeModel.setDuration(routeEntity.getDuration());
		return routeModel;
	}

	public static RouteEntity convertRouteModelToRouteEntity(RouteModel routeModel) {

		RouteEntity routeEntity = new RouteEntity();
		routeEntity.setRouteId(routeModel.getRouteId());
		routeEntity.setFromCity(routeModel.getFromCity());
		routeEntity.setToCity(routeModel.getToCity());
		routeEntity.setBreakPoints(routeModel.getBreakPoints());
		routeEntity.setDuration(routeModel.getDuration());
		return routeEntity;
	}

	public static List<RouteEntity> convertListOfRouteModelToEntity(List<RouteModel> routeModelList) {
		List<RouteEntity> routeEntityList = new ArrayList<>();
		for (RouteModel rm : routeModelList) {
			routeEntityList.add(convertRouteModelToRouteEntity(rm));
		}
		return routeEntityList;
	}

	public static List<RouteModel> convertListOfRouteEntityToModel(List<RouteEntity> routeEntityList) {
		List<RouteModel> routeModelList = new ArrayList<>();
		for (RouteEntity re : routeEntityList) {
			routeModelList.add(convertRouteEntityToRouteModel(re));
		}
		return routeModelList;
	}

	// ---------------------------BUS CONVERSIONS---------------------------//

	public static BusModel convertBusEntityToBusModel(BusEntity busEntity) {
		BusModel busModel = new BusModel();
		busModel.setBusId(busEntity.getBusId());
		busModel.setBusName(busEntity.getBusName());
		busModel.setCapacity(busEntity.getCapacity());
		busModel.setRegistrationNumber(busEntity.getRegistrationNumber());
		busModel.setBusType(busEntity.getBusType());
		return busModel;
	}

	public static BusEntity convertBusModelBusEntity(BusModel busModel) {
		BusEntity busEntity = new BusEntity();
		busEntity.setBusId(busModel.getBusId());
		busEntity.setBusName(busModel.getBusName());
		busEntity.setCapacity(busModel.getCapacity());
		busEntity.setRegistrationNumber(busModel.getRegistrationNumber());
		busEntity.setBusType(busModel.getBusType());
		return busEntity;
	}

	public static List<BusEntity> convertListOfBusModelToEntity(List<BusModel> busModelList) {
		List<BusEntity> busEntityList = new ArrayList<>();
		for (BusModel bm : busModelList) {
			busEntityList.add(convertBusModelBusEntity(bm));
		}
		return busEntityList;
	}

	public static List<BusModel> convertListOfBusEntityToModel(List<BusEntity> busEntityList) {
		List<BusModel> busModelList = new ArrayList<>();
		for (BusEntity be : busEntityList) {
			busModelList.add(convertBusEntityToBusModel(be));
		}
		return busModelList;
	}

//	------------------------------------TRIP CONVERSIONS------------------------------------------------------------//

	public static TripModel convertTripEntityToModel(TripEntity tripEntity) {
		return new TripModel(tripEntity.getTripId(), 
				tripEntity.getRoute(), 
				tripEntity.getBus(),
				tripEntity.getBoardingId(), 
				tripEntity.getDroppingId(), 
				tripEntity.getDepartureTime(),
				tripEntity.getArrivalTime(), 
				tripEntity.getAvailableSeats(), 
				tripEntity.getFare(),
				tripEntity.getTripDate());
	}

	public static List<TripModel> convertListOfTripEntityToModel(List<TripEntity> tripEntityList) {
		List<TripModel> tripModelList = new ArrayList<>();
		for (TripEntity te : tripEntityList) {
			tripModelList.add(convertTripEntityToModel(te));
		}
		return tripModelList;
	}

	
	// ---------------------------------BOOKING  CONVERSIONS-------------------------------------//
	
	
	public static BookingEntity convertBookingModelToEntity(BookingModel bm) {
		BookingEntity bookingEntity = new BookingEntity();
		bookingEntity.setBookingId(bm.getBookingId());
		bookingEntity.setSeatNumber(bm.getSeatNumber());
		bookingEntity.setStatus(bm.getStatus());

		return bookingEntity;
	}

	public static BookingModel convertBookingEntityToModel(BookingEntity be) {
		return new BookingModel(be.getBookingId(), be.getSeatNumber(), be.getTrip().getTripId(), be.getStatus(), be.getCustomerId()

		);
	}

	public static Set<BookingModel> convertBookingEntityListToModelSet(List<BookingEntity> bookingEntities) {
		Set<BookingModel> bookingModelSet = new HashSet<>();

		for (BookingEntity bookingEntity : bookingEntities) {
			BookingModel bookingModel = convertBookingEntityToModel(bookingEntity);
			bookingModelSet.add(bookingModel);
		}

		return bookingModelSet;
	}

}
