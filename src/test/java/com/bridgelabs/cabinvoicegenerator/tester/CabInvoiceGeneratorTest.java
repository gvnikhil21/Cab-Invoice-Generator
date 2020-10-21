package com.bridgelabs.cabinvoicegenerator.tester;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabs.cabinvoicegenerator.controller.CabInvoiceGeneratorMain;

public class CabInvoiceGeneratorTest {

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		CabInvoiceGeneratorMain cabInvoiceGeneratorMain = new CabInvoiceGeneratorMain();
		Double cost = cabInvoiceGeneratorMain.calculateTotalFare(10.0, 5.0);
		Assert.assertEquals(Double.valueOf(105.0), cost);

		cost = cabInvoiceGeneratorMain.calculateTotalFare(0.2, 1.0);
		Assert.assertEquals(Double.valueOf(5.0), cost);
	}

}
