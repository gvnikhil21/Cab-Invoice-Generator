package com.bridgelabs.cabinvoicegenerator.tester;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabs.cabinvoicegenerator.controller.CabInvoiceGeneratorMain;
import com.bridgelabs.cabinvoicegenerator.model.InvoiceGenerator;
import com.bridgelabs.cabinvoicegenerator.model.Ride;

public class CabInvoiceGeneratorTest {

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		CabInvoiceGeneratorMain cabInvoiceGeneratorMain = new CabInvoiceGeneratorMain();
		Double cost = cabInvoiceGeneratorMain.calculateTotalFare(10.0, 5.0);
		Assert.assertEquals(Double.valueOf(105.0), cost);

		cost = cabInvoiceGeneratorMain.calculateTotalFare(0.2, 1.0);
		Assert.assertEquals(Double.valueOf(5.0), cost);
	}

	@Test
	public void givenMultipleRides_ShouldReturnAggregateFare() {
		CabInvoiceGeneratorMain cabInvoiceGeneratorMain = new CabInvoiceGeneratorMain();
		Ride rides[] = { new Ride(10.0, 5.0), new Ride(0.2, 1.0), new Ride(5.0, 1.0) };
		Double cost = cabInvoiceGeneratorMain.calculateAggregateFareForMulltipleRides(rides);
		Assert.assertEquals(Double.valueOf(161.0), cost);
	}

	@Test
	public void givenMultipleRides_ShouldReturnGeneratedInvoice() {
		CabInvoiceGeneratorMain cabInvoiceGeneratorMain = new CabInvoiceGeneratorMain();
		Ride rides[] = { new Ride(10.0, 5.0), new Ride(0.2, 1.0), new Ride(5.0, 1.0) };
		InvoiceGenerator invoice = cabInvoiceGeneratorMain.generateInvoiceForMulltipleRides(rides);
		InvoiceGenerator invoiceExpected = new InvoiceGenerator(3, 161.0, 161.0 / 3);
		Assert.assertEquals(invoiceExpected, invoice);
	}
}
