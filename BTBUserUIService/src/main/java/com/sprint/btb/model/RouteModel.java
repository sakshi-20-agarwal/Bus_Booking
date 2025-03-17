package com.sprint.btb.model;

public class RouteModel {
	private int routeId;
	private String fromCity;
	private String toCity;
	private Integer breakPoints;
	private Integer duration;

	public RouteModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RouteModel(int routeId, String fromCity, String toCity, Integer breakPoints, Integer duration) {
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
		return "RouteModel [routeId=" + routeId + ", fromCity=" + fromCity + ", toCity=" + toCity + ", breakPoints="
				+ breakPoints + ", duration=" + duration + "]";
	}

}
