package se.kth.carInspection.model;

import se.kth.carInspection.integration.InspectionRegistry;
import se.kth.carInspection.integration.Printer;

public class Inspection {
	private InspectionRegistry inspectionList;
	private InspectionStep [] inspectionSteps;// = new InspectionStep[0];
	private int currentStep = 0;
	
	/**
	 *  starts with creating a inspection registry and fetches a list of inspections
	 *  stored in inspectionSteps 
	 * @param InspectionRegistry inspectionList
	 */
	
	public void setInspectionRegistry(InspectionRegistry inspectionList) {
		this.inspectionList = inspectionList;
		inspectionSteps = inspectionList.loadStepResults();
	}
	
	/**
	 *  looks through the fetched array for inspections that has not passed.
	 *  returns description for inspections not passed and keeps looping getNextStep method
	 *  while inspections have passed
	 * @return InspectionStepArea
	 */
	
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
	
	/**
	 *  set the result of the recent inspection made. divided into steps and going through each one
	 *  inspection steps stores the details, divided into area and result
	 * @param InspectionStepResult result
	 */
	
	public void setLastStepResult(InspectionStepResult result) {
		inspectionSteps[currentStep -1].setResult(result);
	}
	
	/**
	 *  finding out how many inspections that are needed. used for calculating cost
	 * @return int inspectionsNeeded
	 */
	
	public int getInspectionsNeeded () {
		int inspectionsNeeded = 0;
		for (InspectionStep inspectionStep : inspectionSteps) {
			if (inspectionStep.getResult().getPassed() == false) {
				inspectionsNeeded +=1;
			}
		}
		return inspectionsNeeded;
	}
	/**
	 *  ends inspections. sends saved InspectionSteps to the register
	 */
	
	public void endInspection() {
		this.inspectionList.saveStepResults(inspectionSteps);
		
	}
	
	/**
	 * creates new printer. makes new report and sends it to printer as parameter
	 */
	
	public void makeInspectionReportandPrint(){
		 InspectionReport report = new InspectionReport(inspectionSteps);
		 Printer printer = new Printer();
		 printer.print(report);
	}
}