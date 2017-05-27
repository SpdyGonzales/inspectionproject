package se.kth.carInspection.model;


import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;
import se.kth.carInspection.integration.CarRegistry;
import se.kth.carInspection.integration.InspectionRegistry;
import se.kth.*;

public class InspectionReportTest extends TestCase {
	
	private Inspection inspection;
	private InspectionRegistry inspectionList;
	private InspectionStep [] inspectionSteps;
	
	public InspectionStepArea detail1;
	public InspectionStepResult result1;
	public String ExpectedString = "Däck";
	
	
	@Override
	protected void setUp() throws Exception {
		String testLicenseNumber = "APK420";
		this.inspectionList = new InspectionRegistry(testLicenseNumber);
		this.inspectionSteps = inspectionList.loadStepResults();
	
			
		}
	@Override
	protected void tearDown() throws Exception {
		// Tear down
	}
	
	@Test
	public void testInspectionReport(){
		
		InspectionReport report = new InspectionReport(inspectionSteps);
		assertEquals(ExpectedString, report.detail1);
		assertEquals(report.result1, false);
		
	}

	
}
	
	

