package se.kth.carInspection.integration;

import java.util.HashMap;

import se.kth.carInspection.model.InspectionStep;
import se.kth.carInspection.model.InspectionStepArea;
import se.kth.carInspection.model.InspectionStepResult;

public class InspectionRegistry {
	
	private final String licenseNumber;
    private InspectionStep[] storedSteps;
    private final HashMap<String, InspectionStep[]> data = new HashMap<>();
    
    /**
     * Creates a InspectionRegistry
     * 
     * @param license number to store results for
     */
    public InspectionRegistry(String licenseNumber) {
        this.licenseNumber = licenseNumber;
        this.insertRandomData();
    }
    
    public InspectionStep [] loadStepResults () {
        this.fetch();
        return this.storedSteps;
    }
    
    public void saveStepResults (InspectionStep[] steps){
    	this.storedSteps = steps;
    	this.store();
    }
    
    private void fetch () {
    	this.storedSteps = data.get(this.licenseNumber);
    }
    
    private void store () {
    	data.put(this.licenseNumber, this.storedSteps);
    }
   
    
    private void insertRandomData () {
        InspectionStep[] steps1 = new InspectionStep[3];
        steps1[0] = new InspectionStep(new InspectionStepArea("Däck"));
        steps1[0].setResult(new InspectionStepResult(false));
        steps1[1] = new InspectionStep(new InspectionStepArea("Ljus"));
        steps1[1].setResult(new InspectionStepResult(false));
        steps1[2] = new InspectionStep(new InspectionStepArea("Bromsar"));
        steps1[2].setResult(new InspectionStepResult(false));
        data.put("APK420", steps1);
    }
}
