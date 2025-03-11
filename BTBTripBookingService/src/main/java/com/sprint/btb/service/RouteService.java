package com.sprint.btb.service;

import java.util.List;

import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.RouteModel;


public interface RouteService {

	public RouteModel getRouteById(int routeId) throws BadRequestException;
	public RouteModel deleteRouteById(int routeId) throws BadRequestException;
	public RouteModel insertRoute(RouteModel routeModel) throws BadRequestException;
	public RouteModel updateRoute(int routeId, String newRoute) throws BadRequestException;
	public List<RouteModel> getAllRoutes() throws BadRequestException;
	public List<RouteModel> getRoutesByFromCity(String fromCity) throws BadRequestException;
	public List<RouteModel> getRoutesByToCity(String toCity) throws BadRequestException;
	public RouteModel getRouteByFromAndToCity(String fromCity, String toCity) throws BadRequestException;
}
