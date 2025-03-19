package com.sprint.btb.model;

public class BookingModel {
	private int bookingId;
	private Integer seatNumber;
	private int tripId;
	private Integer customerId;

	private BookingStatus status;

	private TripModel tripModel;
	private RouteModel routeModel;
	private BusModel busModel;

	public BookingModel() {
	}

	public BookingModel(int bookingId, Integer seatNumber, int tripId, Integer customerId, BookingStatus status,
			TripModel tripModel, RouteModel routeModel, BusModel busModel) {
		super();
		this.bookingId = bookingId;
		this.seatNumber = seatNumber;
		this.tripId = tripId;
		this.customerId = customerId;
		this.status = status;
		this.tripModel = tripModel;
		this.routeModel = routeModel;
		this.busModel = busModel;
	}



	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public TripModel getTripModel() {
		return tripModel;
	}

	public void setTripModel(TripModel tripModel) {
		this.tripModel = tripModel;
	}

	public RouteModel getRouteModel() {
		return routeModel;
	}
	

	public BusModel getBusModel() {
		return busModel;
	}

	public void setBusModel(BusModel busModel) {
		this.busModel = busModel;
	}

	public void setRouteModel(RouteModel routeModel) {
		this.routeModel = routeModel;
	}

	@Override
	public String toString() {
		return "BookingModel [bookingId=" + bookingId + ", seatNumber=" + seatNumber + ", tripId=" + tripId
				+ ", customerId=" + customerId + ", status=" + status + ", tripModel=" + tripModel + ", routeModel="
				+ routeModel + "]";
	}

}
