package com.bridgelabs.cabinvoicegenerator.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bridgelabs.cabinvoicegenerator.model.*;
import com.bridgelabs.cabinvoicegenerator.model.Ride.RideType;

public class CabInvoiceGeneratorMain {

	private static final Logger LOGGER = LogManager.getLogger(CabInvoiceGeneratorMain.class);
	private static final double MINIMUM_FARE_NORMAL = 5.0;
	private static final double COST_PER_KM_NORMAL = 10.0;
	private static final double COST_PER_MINUTE_NORMAL = 1.0;
	private static final double MINIMUM_FARE_PREMIUM = 20.0;
	private static final double COST_PER_KM_PREMIUM = 15.0;
	private static final double COST_PER_MINUTE_PREMIUM = 2.0;

	public static void main(String[] args) {
		// welcome message
		LOGGER.info("Welcome to cab invoice generator");
	}

	// calculates fare for each ride
	public Double calculateTotalFare(double distance, double minutes, RideType rideType) {
		if (rideType.equals(Ride.RideType.NORMAL))
			return Math.max(MINIMUM_FARE_NORMAL, distance * COST_PER_KM_NORMAL + minutes * COST_PER_MINUTE_NORMAL);
		if (rideType.equals(Ride.RideType.PREMIUM))
			return Math.max(MINIMUM_FARE_PREMIUM, distance * COST_PER_KM_PREMIUM + minutes * COST_PER_MINUTE_PREMIUM);
		return 0d;
	}

	// calculates aggregate for multiple rides
	public Double calculateAggregateFareForMulltipleRides(Ride[] rides) {
		double totalCost = 0;
		for (Ride ride : rides)
			totalCost += calculateTotalFare(ride.getDistance(), ride.getMinutes(), ride.getRideType());
		return totalCost;
	}

	// generates invoice summary for multiple rides
	public InvoiceGenerator generateInvoiceForMulltipleRides(Ride[] rides) {
		double totalCost = calculateAggregateFareForMulltipleRides(rides);
		return new InvoiceGenerator(rides.length, totalCost, totalCost / rides.length);
	}

	// generate invoice summary for rides made by specific user
	public InvoiceGenerator generateInvoiceForGivenUserId(String userId, InvoiceService invoiceService) {
		return generateInvoiceForMulltipleRides(invoiceService.getUserRidesArray(userId));
	}
}
