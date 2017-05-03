package se.kth.carInspection.model;

import se.kth.carInspection.integration.InspectionRegistry;

public class Inspection {
	private InspectionRegistry inspectionList;
	private InspectionStep [] inspectionSteps;// = new InspectionStep[0];
	private int currentStep = 0;
	
	// starts with creating a inspection registry and fetches a list of inspections
	// stored in inspectionSteps 
	
	public void setInspectionRegistry(InspectionRegistry inspectionList) {
		this.inspectionList = inspectionList;
		inspectionSteps = inspectionList.loadStepResults();
	}
	
	// looks through the fetched array for inspections that has not passed.
	// returns description for inspections not passed and keeps looping getNextStep method
	// while inspections have passed
	
	public InspectionStepArea getNextStep() {
		if(currentStep >= inspectionSteps.length) {
			return null;
		}else{
			InspectionStep nextStep = inspectionSteps[currentStep++];
			if(nextStep.getResult().getPassed() == false) {
				return nextStep.getArea();
			}else {
				return this.getNextStep();
			}
		}
	}
	
	// set the result of the recent inspection made. divided into steps and going through each one
	// inspection steps stores the details, divided into area and result 
	
	public void setLastStepResult(InspectionStepResult result) {
		inspectionSteps[currentStep -1].setResult(result);
	}
	
	// finding out how many inspections that are needed. used for calculating cost
	
	public int getInspectionsNeeded () {
		int inspectionsNeeded = 0;
		for (InspectionStep inspectionStep : inspectionSteps) {
			if (inspectionStep.getResult().getPassed() == false) {
				inspectionsNeeded +=1;
			}
		}
		return inspectionsNeeded;
	}
	
	public void endInspection() {
		this.inspectionList.saveStepResults(inspectionSteps);
	}
}