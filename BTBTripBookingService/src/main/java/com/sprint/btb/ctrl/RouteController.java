package com.sprint.btb.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.btb.model.RouteModel;
import com.sprint.btb.service.RouteServiceImpl;
import com.sprint.btb.exception.*;

@RestController
@RequestMapping("/routes")
public class RouteController {

	@Autowired
	RouteServiceImpl routeService;

	@GetMapping("/")
	public List<RouteModel> fetchAllRoutes() throws BadRequestException {
		List<RouteModel> routeModelList = routeService.getAllRoutes();
		return routeModelList;
	}

	@PostMapping("/")
	public RouteModel addRoute(@RequestBody RouteModel routeModel) throws BadRequestException {
		RouteModel routeMd = routeService.insertRoute(routeModel);
		if (routeMd == null) {
			throw new BadRequestException("Error While Inserting the Route !!");
		}
		return routeMd;
	}

	@GetMapping("/{route_id}")
	public RouteModel fetchRouteById(@PathVariable("route_id") int routeId) throws BadRequestException {
		RouteModel route = routeService.getRouteById(routeId);
		return route;
	}

	@GetMapping("/fromcity/{from_city}")
	public List<RouteModel> fetchRoutesByFromCity(@PathVariable("from_city") String fromCity)
			throws BadRequestException {
		List<RouteModel> routes = routeService.getRoutesByFromCity(fromCity);
		return routes;
	}

	@GetMapping("/tocity/{to_city}")
	public List<RouteModel> fetchRoutesByToCity(@PathVariable("to_city") String toCity) throws BadRequestException {
		List<RouteModel> routes = routeService.getRoutesByToCity(toCity);
		return routes;
	}

	@GetMapping("/{from_city}/{to_city}")
	public RouteModel fetchRouteByFromAndToCity(@PathVariable("from_city") String fromCity,
			@PathVariable("to_city") String toCity) throws BadRequestException {
		RouteModel route = routeService.getRouteByFromAndToCity(fromCity, toCity);
		return route;
	}

}
