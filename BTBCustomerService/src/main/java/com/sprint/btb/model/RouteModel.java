package com.sprint.btb.model;


public class RouteModel {
	private int routeId;
    private String fromCity;
    private String toCity;
    private int breakPoints;
    private int duration;
	public RouteModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RouteModel(int routeId, String fromCity, String toCity, int breakPoints, int duration) {
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
	public int getBreakPoints() {
		return breakPoints;
	}
	public void setBreakPoints(int breakPoints) {
		this.breakPoints = breakPoints;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "RouteDTO [routeId=" + routeId + ", fromCity=" + fromCity + ", toCity=" + toCity + ", breakPoints="
				+ breakPoints + ", duration=" + duration + "]";
	}
    
    
}
