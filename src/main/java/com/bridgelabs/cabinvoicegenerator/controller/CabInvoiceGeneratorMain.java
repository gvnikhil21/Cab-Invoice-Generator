package com.bridgelabs.cabinvoicegenerator.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CabInvoiceGeneratorMain {

	private static final Logger LOGGER = LogManager.getLogger(CabInvoiceGeneratorMain.class);
	private static final double MINIMUM_FARE = 5.0;
	private static final double COST_PER_KM = 10.0;
	private static final double COST_PER_MINUTE = 1.0;

	public static void main(String[] args) {
		// welcome message
		LOGGER.info("Welcome to cab invoice generator");
	}

	public Double calculateTotalFare(double distance, double minutes) {
		if (distance * COST_PER_KM + minutes * COST_PER_MINUTE < MINIMUM_FARE)
			return MINIMUM_FARE;
		return distance * COST_PER_KM + minutes * COST_PER_MINUTE;
	}
}
