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
	
	private Controller controller;
	

	@Override
	protected void setUp() throws Exception {
		
		this.controller = new Controller();
		
	}
	
	@Override
	protected void tearDown() throws Exception {
		// Tear down
	}
	
	@Test(expected=NullPointerException.class)
	public void testInvalidLincense () {
		
		this.controller.newInspection();
		float cost = this.controller.enterLicenseNumber("foo");
		assertEquals(216, cost, 0);
		
	}
	
	@Test
	public void performInspectionTest(){
		this.controller.newInspection();
		float cost = this.controller.enterLicenseNumber("APK420");
		InspectionStepArea areaInspec = this.controller.performInspection();
		assertEquals("Däck", areaInspec.getArea());
	}

}
