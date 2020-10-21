package com.bridgelabs.cabinvoicegenerator.model;

public class Ride {
	private double distance;
	private double minutes;

	// constructor
	public Ride(double distance, double minutes) {
		this.distance = distance;
		this.minutes = minutes;
	}

	// getters
	public double getDistance() {
		return distance;
	}

	public double getMinutes() {
		return minutes;
	}
}
