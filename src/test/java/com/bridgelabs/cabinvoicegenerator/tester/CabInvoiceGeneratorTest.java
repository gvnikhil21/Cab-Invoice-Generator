package com.bridgelabs.cabinvoicegenerator.tester;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabs.cabinvoicegenerator.controller.CabInvoiceGeneratorMain;
import com.bridgelabs.cabinvoicegenerator.model.*;

public class CabInvoiceGeneratorTest {

	@Test
	public void givenUserId_ShouldReturnGeneratedInvoiceForThatUser() {
		CabInvoiceGeneratorMain cabInvoiceGeneratorMain = new CabInvoiceGeneratorMain();
		InvoiceService invoiceService = new InvoiceService();
		Ride rides[] = { new Ride(10.0, 5.0, Ride.RideType.NORMAL), new Ride(0.2, 1.0, Ride.RideType.PREMIUM),
				new Ride(5.0, 1.0, Ride.RideType.NORMAL) };
		invoiceService.addRideDetails("user1", rides);
		InvoiceGenerator invoice = cabInvoiceGeneratorMain.generateInvoiceForGivenUserId("user1", invoiceService);
		InvoiceGenerator invoiceExpected = new InvoiceGenerator(3, 176.0, 176.0 / 3);
		Assert.assertEquals(invoiceExpected, invoice);
	}
}
