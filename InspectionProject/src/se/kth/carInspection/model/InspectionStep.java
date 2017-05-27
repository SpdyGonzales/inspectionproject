package se.kth.carInspection.model;

/** 
 * stores inspection details for the current step
 * 
 *
 */

public class InspectionStep {
	private final InspectionStepArea area;
	private InspectionStepResult result;
	
	/**
	 *  saves a step with the stepArea associated with it
	 * @param InspectionStepArea stepArea
	 */
	
	public InspectionStep(InspectionStepArea stepArea) {
		this.area = stepArea;
	}
	
	/**
	 *  Returns the class InspectionStepArea for the specified step
	 * @return InspectionStepArea
	 */
	
	public InspectionStepArea getArea() {
		return this.area;
	}
	
	/**
	 *  stores result for the specific step
	 * @param InspectionStepResult result
	 */
	
	public void setResult(InspectionStepResult result) {
		this.result = result;
	}
	
	/**
	 *  gets the current result for the step in array
	 * @return InspectionStepResult
	 */
	
	public InspectionStepResult getResult() {
		return this.result;
	}

}
