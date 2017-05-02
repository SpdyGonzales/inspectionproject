package se.kth.carInspection.model;

import se.kth.carInspection.integration.InspectionRegistry;

public class Inspection {
	private InspectionRegistry inspectionList;
	private InspectionStep [] inspectionSteps = new InspectionStep[0];
	private int currentStep = 0;
	
	public void setInspectionRegistry(InspectionRegistry inspectionList) {
		this.inspectionList = inspectionList;
		inspectionSteps = inspectionList.loadStepResults();
	}
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
	
	public void setLastStepResult(InspectionStepResult result) {
		inspectionSteps[currentStep -1].setResult(result);
	}
	
	public int getInspectionsNeeded () {
		int inspectionsNeeded = 0;
		for (InspectionStep inspectionStep : inspectionSteps) {
			if (inspectionStep.getResult().getPassed() == false) {
				inspectionsNeeded +=1;
			}
		}
		return inspectionsNeeded;
	}
}