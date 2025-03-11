package com.sprint.btb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="routes")
public class RouteEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="route_id")
    private int routeId;
 
	
	@Column(name = "from_city", nullable = false, length = 255)
	private String fromCity;
	
	@Column(name = "to_city", nullable = false, length = 255)
	private String toCity;
	
	@Column(name = "break_points")
	private Integer breakPoints;
	
	@Column(name="duration", nullable = false)
	private Integer duration;

	public RouteEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RouteEntity(int routeId, String fromCity, String toCity, Integer breakPoints, Integer duration) {
		super();
		this.routeId = routeId;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.breakPoints = breakPoints;
		this.duration = duration;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public Integer getBreakPoints() {
		return breakPoints;
	}

	public void setBreakPoints(Integer breakPoints) {
		this.breakPoints = breakPoints;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "RouteEntity [routeId=" + routeId + ", fromCity=" + fromCity + ", toCity=" + toCity + ", breakPoints="
				+ breakPoints + ", duration=" + duration + "]";
	}
	
}

