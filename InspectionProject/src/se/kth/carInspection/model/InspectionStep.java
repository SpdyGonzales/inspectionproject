package se.kth.carInspection.model;

public class InspectionStep {
	private final InspectionStepArea area;
	private InspectionStepResult result;
	
	// stores inspection details for the current step
	
	public InspectionStep(InspectionStepArea stepArea) {
		this.area = stepArea;
	}
	
	public InspectionStepArea getArea() {
		return this.area;
	}
	
	public void setResult(InspectionStepResult result) {
		this.result = result;
	}
	
	public InspectionStepResult getResult() {
		return this.result;
	}

}
