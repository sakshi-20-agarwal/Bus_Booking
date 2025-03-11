package com.sprint.btb.service;

import com.sprint.btb.entity.TripEntity;
import com.sprint.btb.exception.BadRequestException;

import com.sprint.btb.model.TripModel;
import com.sprint.btb.repo.TripRepository;
import com.sprint.btb.util.BTBUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {

  

    @Autowired
    TripRepository tripRepository;


    @Transactional
    public TripModel fetchTripById(int tripId) throws BadRequestException {
        Optional<TripEntity> tripEntity = tripRepository.findById(tripId);
        if (tripEntity.isEmpty()) {
            throw new BadRequestException("Trip with ID " + tripId + " not found.");
        }
        return BTBUtil.convertTripToModel(tripEntity.get());
    }

    @Override
    @Transactional
    public List<TripModel> fetchTripsByFromCity(String fromCity) throws BadRequestException {
        List<TripEntity> trips = tripRepository.findByRouteFromCity(fromCity);
        if (trips.isEmpty()) {
            throw new BadRequestException("No trips found from " + fromCity);
        }
        
        // Convert each TripEntity to TripModel without using streams
        List<TripModel> tripModels = new ArrayList<>();
        for (TripEntity tripEntity : trips) {
            tripModels.add(BTBUtil.convertTripToModel(tripEntity));
        }
        return tripModels;
    }

    @Override
    @Transactional
    public List<TripModel> fetchTripsByToCity(String toCity) throws BadRequestException {
        List<TripEntity> trips = tripRepository.findByRouteToCity(toCity);
        if (trips.isEmpty()) {
            throw new BadRequestException("No trips found to " + toCity);
        }
        
        // Convert each TripEntity to TripModel without using streams
        List<TripModel> tripModels = new ArrayList<>();
        for (TripEntity tripEntity : trips) {
            tripModels.add(BTBUtil.convertTripToModel(tripEntity));
        }
        return tripModels;
    }

    @Override
    @Transactional
    public List<TripModel> fetchTripsByFromCityToCityAndDate(String fromCity, String toCity, LocalDateTime tripDate) throws BadRequestException {
        List<TripEntity> trips = tripRepository.findByRouteFromCityAndRouteToCityAndTripDate(fromCity, toCity, tripDate);
        if (trips.isEmpty()) {
            throw new BadRequestException("No trips found for " + fromCity + " to " + toCity + " on " + tripDate);
        }
        
       
        List<TripModel> tripModels = new ArrayList<>();
        for (TripEntity tripEntity : trips) {
            tripModels.add(BTBUtil.convertTripToModel(tripEntity));
        }
        return tripModels;
    }

//    @Override
//    @Transactional
//    public List<TripModel> fetchTripsByFromCityToCityDateAndBusType(String fromCity, String toCity, LocalDateTime tripDate, String busType) throws BadRequestException {
//        List<TripEntity> trips = tripRepository.findByRouteFromCityAndRouteToCityAndTripDateAndBusType(fromCity, toCity, tripDate, busType);
//        if (trips.isEmpty()) {
//            throw new BadRequestException("No trips found for " + fromCity + " to " + toCity + " on " + tripDate + " with bus type " + busType);
//        }
//        
//        // Convert each TripEntity to TripModel without using streams
//        List<TripModel> tripModels = new ArrayList<>();
//        for (TripEntity tripEntity : trips) {
//            tripModels.add(TripUtil.convertToModel(tripEntity));
//        }
//        return tripModels;
//    }
}
