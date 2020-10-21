package com.bridgelabs.cabinvoicegenerator.model;

import java.util.*;

public class InvoiceService {
	private Map<String, List<Ride>> userRidesListMap;

	// initializes empty userRidesListMap
	public InvoiceService() {
		userRidesListMap = new HashMap<String, List<Ride>>();
	}

	// returns list of rides of a specific user
	public Ride[] getUserRidesArray(String userId) {
		return (Ride[]) userRidesListMap.get(userId).toArray();
	}

	// adds userId and rides of that user to map
	public void addRideDetails(String userId, Ride ride) {
		if (userRidesListMap.containsKey(userId))
			userRidesListMap.get(userId).add(ride);
		else {
			userRidesListMap.put(userId, new ArrayList<Ride>());
			userRidesListMap.get(userId).add(ride);
		}
	}

	// adds userId and rides array of that user to map
	public void addRideDetails(String userId, Ride[] rides) {
		userRidesListMap.put(userId, Arrays.asList(rides));
	}
}
