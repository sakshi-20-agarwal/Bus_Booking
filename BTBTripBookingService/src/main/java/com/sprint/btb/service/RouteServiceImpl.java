
package com.sprint.btb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sprint.btb.entity.RouteEntity;
import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.RouteModel;
import com.sprint.btb.repo.RouteRepository;
import com.sprint.btb.util.BTBUtil;


@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
    RouteRepository routeRepo;
	

	@Override
	public RouteModel getRouteById(int routeId) throws BadRequestException {
		Optional<RouteEntity> routeEn = routeRepo.findById(routeId);
		if(routeEn.isPresent()) {
			return BTBUtil.convertRouteEntityToRouteModel(routeEn.get());
		}
		throw new BadRequestException ("Route with Id "+ routeId + " Not found !!");
		
	}

	@Override
	public RouteModel deleteRouteById(int routeId) throws BadRequestException {
		RouteModel route = getRouteById(routeId);
		routeRepo.deleteById(routeId);
		return route;
		
	}

	@Override
	public RouteModel insertRoute(RouteModel routeModel) throws BadRequestException {
		if(routeRepo.existsById(routeModel.getRouteId())) {
			throw new BadRequestException("Route with Id " + routeModel.getRouteId() + " Not found !!");
		}
		routeRepo.saveAndFlush(BTBUtil.convertRouteModelToRouteEntity(routeModel));
		return getRouteById(routeModel.getRouteId());
	}

	
	@Override
	public RouteModel updateRoute(int routeId, String newRoute) throws BadRequestException {
		Optional<RouteEntity> route = routeRepo.findById(routeId);
		RouteModel routeModel = null;
		if (route.isPresent()) {
			routeModel = BTBUtil.convertRouteEntityToRouteModel(route.get());
			routeModel.setToCity(newRoute);
			routeRepo.saveAndFlush(BTBUtil.convertRouteModelToRouteEntity(routeModel));
		} else {
			throw new BadRequestException("Route Not Found !!");
		}
		return routeModel;
	}

	
	@Override
	public List<RouteModel> getAllRoutes() throws BadRequestException {
		List<RouteEntity> routeList = routeRepo.findAll();
		return BTBUtil.convertListOfRouteEntityToModel(routeList);
	}
	
	
	 @Override
	    public List<RouteModel> getRoutesByFromCity(String fromCity) throws BadRequestException {
	        List<RouteEntity> routeList = routeRepo.findByFromCity(fromCity);
	        if (routeList.isEmpty()) {
	            throw new BadRequestException("No Routes found from city: " + fromCity);
	        }
	        return BTBUtil.convertListOfRouteEntityToModel(routeList);
	    }

	    @Override
	    public List<RouteModel> getRoutesByToCity(String toCity) throws BadRequestException {
	        List<RouteEntity> routeList = routeRepo.findByToCity(toCity);
	        if (routeList.isEmpty()) {
	            throw new BadRequestException("No Routes found to city: " + toCity);
	        }
	        return BTBUtil.convertListOfRouteEntityToModel(routeList);
	    }

	    @Override
	    public RouteModel getRouteByFromAndToCity(String fromCity, String toCity) throws BadRequestException {
	        List<RouteEntity> routeList = routeRepo.findByFromCityAndToCity(fromCity, toCity);
	        if (routeList.isEmpty()) {
	            throw new BadRequestException("No Route found from " + fromCity + " to " + toCity);
	        }
	        return BTBUtil.convertRouteEntityToRouteModel(routeList.get(0)); 
	    }
	

	
}
