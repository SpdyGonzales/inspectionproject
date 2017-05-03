package se.kth.carInspection.integration;

public class CarRegistry {
	
	// specific car registry when creating new inspection registry
	
	public static InspectionRegistry getResultList (String licenseNumber) {
		return new InspectionRegistry(licenseNumber);
	}

}
