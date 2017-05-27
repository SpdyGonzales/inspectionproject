package se.kth.carInspection.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;
import se.kth.carInspection.integration.CarRegistry;
import se.kth.carInspection.model.Inspection;
import se.kth.carInspection.model.InspectionStepArea;
import se.kth.carInspection.model.Payment;
import se.kth.iv1350.garage.Garage;

public class ControllerTest extends TestCase {
	
	private Inspection inspection;
	private InspectionStepArea area;
	private String currentArea;

	@Override
	protected void setUp() throws Exception {
		
		String licenseNumberTest = "APK420";
		this.inspection = new Inspection();
		this.inspection.setInspectionRegistry(CarRegistry.getResultList(licenseNumberTest));
		
	}
	
	@Override
	protected void tearDown() throws Exception {
		// Tear down
	}
	@Test
	public void testPerformInspection () {
		
		this.area = inspection.getNextStep();
		this.currentArea = this.area.getArea();
		
		assertEquals(this.currentArea,"Däck");
		
		
		
		
	}

}
