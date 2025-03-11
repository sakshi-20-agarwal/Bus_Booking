package com.sprint.btb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.sprint.btb.entity.TripEntity;

@Repository
public interface TripRepository extends JpaRepository<TripEntity, Integer> {

	//-----------------Find trip by its ID----------------------------
	TripEntity findByTripId(int tripId);
	

	// ----------------Find trips by from city---------------------------
	@Query("SELECT t FROM TripEntity t WHERE t.route.fromCity = :fromCity")
	List<TripEntity> findByRouteFromCity(String fromCity);

	
	//----------------- Find trips by 'to city'----------------------------
	@Query("SELECT t FROM TripEntity t WHERE t.route.toCity = :toCity")
	List<TripEntity> findByRouteToCity(String toCity);
	

	//------------------Find trips by from city to city and date----------
	@Query("SELECT t FROM TripEntity t WHERE t.route.fromCity = :fromCity AND t.route.toCity = :toCity AND t.tripDate = :tripDate")
	List<TripEntity> findByRouteFromCityAndRouteToCityAndTripDate(@Param("fromCity") String fromCity,
			@Param("toCity") String toCity, @Param("tripDate") LocalDateTime tripDate);
	
	
// -------------------Find trips by 'from city', 'to city', 'trip date', and 'bus type-----------'
//    @Query("SELECT t FROM TripEntity t \r\n"
//    		+ "WHERE t.route.fromCity = :fromCity \r\n"
//    		+ "AND t.route.toCity = :toCity \r\n"
//    		+ "AND t.tripDate = :tripDate \r\n"
//    		+ "AND t.bus.busType = :busType\r\n"
//    		)
//    List<TripEntity> findByRouteFromCityAndRouteToCityAndTripDateAndBusType(String fromCity, String toCity, LocalDateTime tripDate, String busType);

}
