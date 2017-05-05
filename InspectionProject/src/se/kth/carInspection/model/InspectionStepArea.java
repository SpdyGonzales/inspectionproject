package se.kth.carInspection.model;

public class InspectionStepArea {
	private final String area;
	
	// methods to create details of which area and to get information
	// @param String area
	
	public InspectionStepArea(String area){
		this.area = area;
	}
	
	// returns string of the specified inspection area
	// @return String area
	
	public String getArea() {
		return this.area;
	}

}
