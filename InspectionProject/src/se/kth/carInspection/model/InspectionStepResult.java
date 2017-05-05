package se.kth.carInspection.model;

public class InspectionStepResult {
	private boolean passed;
	
	// details if certain step was passed or not.
	// @param boolean passed
	
	public InspectionStepResult(boolean passed) {
		this.passed = passed;
	}
	
	// getter if a specific step in the inspection is passed.
	// @return boolean passed
	
	public boolean getPassed() {
		return this.passed;
	}

}
