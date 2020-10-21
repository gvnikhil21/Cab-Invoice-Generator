package com.bridgelabs.cabinvoicegenerator.model;

public class Ride {
	private double distance;
	private double minutes;
	private RideType rideType;

	public enum RideType {
		NORMAL, PREMIUM;
	}

	// constructor
	public Ride(double distance, double minutes, RideType rideType) {
		this.distance = distance;
		this.minutes = minutes;
		this.rideType = rideType;
	}

	// getters
	public double getDistance() {
		return distance;
	}

	public double getMinutes() {
		return minutes;
	}

	public RideType getRideType() {
		return rideType;
	}
}
