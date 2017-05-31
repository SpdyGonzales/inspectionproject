package se.kth.carInspection.model;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;
import se.kth.carInspection.controller.Controller;
import se.kth.carInspection.integration.CarRegistry;
import se.kth.carInspection.integration.InspectionRegistry;

public class InspectionTest extends TestCase {
	private Inspection inspection;
	private String licNumTest = "APK420";
	
	
	@Override
	protected void setUp() throws Exception {
	}
	
	private void createInspection (String licenseNumber){
		this.inspection = new Inspection();
		this.inspection.setInspectionRegistry(CarRegistry.getResultList(licenseNumber));
	}
	@Override
	protected void tearDown() throws Exception {
		// Tear down
	}	

	@Test
	public void testGetNextStep(){
		System.out.println("getNextStep");
		this.createInspection(licNumTest);
		InspectionStepArea expectedOne = new InspectionStepArea("Däck");
		InspectionStepArea expectedTwo = new InspectionStepArea("Ljus");
		InspectionStepArea expectedThree = new InspectionStepArea("Bromsar");
		
		InspectionStepArea step1 = this.inspection.getNextStep();
		InspectionStepArea step2 = this.inspection.getNextStep();
		InspectionStepArea step3 = this.inspection.getNextStep();
		
		assertEquals(expectedOne.getArea(), step1.getArea());
		assertEquals(expectedTwo.getArea(), step2.getArea());
		assertEquals(expectedThree.getArea(), step3.getArea());
	
		
	}
	
	public void testSetLastStepResult(){
		System.out.println("setLastStepResult");
		this.createInspection(licNumTest);
		int stepsLeftAtFirst = this.inspection.getInspectionsNeeded();
		this.inspection.getNextStep();
		this.inspection.setLastStepResult(new InspectionStepResult(true));
		int stepsLeft = this.inspection.getInspectionsNeeded();
		
		assertNotSame(stepsLeftAtFirst, stepsLeft);
	}

	public void testEndInspection(){
		System.out.println("EndInspection");
		Inspection inspection = new Inspection();
        InspectionRegistry storage = CarRegistry.getResultList(licNumTest);
        
        inspection.setInspectionRegistry(storage);
        
        inspection.getNextStep();
        inspection.setLastStepResult(new InspectionStepResult(true));
        inspection.getNextStep();
        inspection.setLastStepResult(new InspectionStepResult(false));
        inspection.endInspection();
        
        InspectionStepResult step1Results = storage.loadStepResults()[0].getResult();
        InspectionStepResult step2Results = storage.loadStepResults()[2].getResult();
        
        assertEquals(step1Results.getPassed(), true);
        assertEquals(step2Results.getPassed(), false);
	}

}
