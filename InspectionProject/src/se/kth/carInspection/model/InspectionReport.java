package se.kth.carInspection.model;

// gathers Inspection details with the array of inspection steps. saves each step as a variable
// that can later be used to getArea and getResult for each step.

public class InspectionReport {
	public InspectionStepArea detail1;
	public InspectionStepArea detail2;
	public InspectionStepArea detail3;
	
	public InspectionStepResult result1;
	public InspectionStepResult result2;
	public InspectionStepResult result3;
	
	public InspectionReport(InspectionStep [] steps) {
		detail1 = steps[0].getArea();
		detail2 = steps[1].getArea();
		detail3 = steps[2].getArea();
		
		result1 = steps[0].getResult();
		result2 = steps[0].getResult();
		result3 = steps[0].getResult();
	}

}
