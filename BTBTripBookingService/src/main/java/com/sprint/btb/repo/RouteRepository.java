package com.sprint.btb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.btb.entity.RouteEntity;
import com.sprint.btb.model.RouteModel;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Integer> {
	

	List<RouteEntity> findByFromCity(String fromCity);

	List<RouteEntity> findByToCity(String toCity);

	List<RouteEntity> findByFromCityAndToCity(String fromCity, String toCity);

}
