package se.kth.carInspection.model;

public class InspectionStepArea {
	private final String area;
	
	// methods to create details of which area and to get information
	
	public InspectionStepArea(String area){
		this.area = area;
	}
	
	public String getArea() {
		return this.area;
	}

}
