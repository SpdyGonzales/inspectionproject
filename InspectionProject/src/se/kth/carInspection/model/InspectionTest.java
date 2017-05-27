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
	public void setInspectionRegistryTest(){
		Inspection inspection = new Inspection();
		InspectionRegistry reg = CarRegistry.getResultList(licNumTest);
		
		float inspectionsBeforeLoading = inspection.getInspectionsNeeded();
		inspection.setInspectionRegistry(reg);
		assertNotSame(inspectionsBeforeLoading, inspection.getInspectionsNeeded());
	}
	

	@Test
	public void testGetNextStep(){
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

	

}
