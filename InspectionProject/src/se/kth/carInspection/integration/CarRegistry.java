package se.kth.carInspection.integration;

public class CarRegistry {
	
	public static InspectionRegistry getResultList (String licenseNumber) {
		return new InspectionRegistry(licenseNumber);
	}

}
