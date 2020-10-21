package com.bridgelabs.cabinvoicegenerator.model;

public class InvoiceGenerator {
	private int totalNoOfRides;
	private double totalFare;
	private double averageFare;

	// parameterized constructor
	public InvoiceGenerator(int totalNoOfRides, double totalFare, double averageFare) {
		this.totalNoOfRides = totalNoOfRides;
		this.totalFare = totalFare;
		this.averageFare = averageFare;
	}

	// getters
	public int getTotalNoOfRides() {
		return totalNoOfRides;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public double getAverageFare() {
		return averageFare;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceGenerator other = (InvoiceGenerator) obj;
		if (Double.doubleToLongBits(averageFare) != Double.doubleToLongBits(other.averageFare))
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		if (totalNoOfRides != other.totalNoOfRides)
			return false;
		return true;
	}

}
