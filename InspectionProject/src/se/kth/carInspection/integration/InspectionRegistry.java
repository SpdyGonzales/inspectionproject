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
     * Creates a InspectionRegistry for the specific license number
     * 
     * @param license number to store results for
     */
    public InspectionRegistry(String licenseNumber) {
        this.licenseNumber = licenseNumber;
        this.insertRandomData();
    }
    
    /**
     *  returns an array of inspection results
     * @return InspectionStep[]
     */
    
    public InspectionStep [] loadStepResults () {
        this.fetch();
        return this.storedSteps;
    }
    
    /**
     *  saves the steps in parameter to private array storedSteps
     * @param InspectionStep[] steps
     */
    
    public void saveStepResults (InspectionStep[] steps){
    	this.storedSteps = steps;
    	this.store();
    }
    
    /** 
     * gets values from list of random data (database) license number tells which to get from
     * thanks to hash map
     */
    
    
    private void fetch () {
    	this.storedSteps = data.get(this.licenseNumber);
    }
    
    /**
     *  sets new values to the array of random data (database)
     */
    
    private void store () {
    	data.put(this.licenseNumber, this.storedSteps);
    }
   
    /**
     * array of random data. new InspectionStep that can later be accessed
     */
    
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
