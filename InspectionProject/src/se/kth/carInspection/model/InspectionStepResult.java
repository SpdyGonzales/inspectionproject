package se.kth.carInspection.model;

public class InspectionStepResult {
	private boolean passed;
	
	public InspectionStepResult(boolean passed) {
		this.passed = passed;
	}
	
	public boolean getPassed() {
		return this.passed;
	}

}
