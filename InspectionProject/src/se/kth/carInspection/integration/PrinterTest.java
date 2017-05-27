package se.kth.carInspection.integration;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import se.kth.carInspection.model.Inspection;
import se.kth.carInspection.model.InspectionReport;
import se.kth.carInspection.model.InspectionStep;
import se.kth.carInspection.model.InspectionStepArea;
import se.kth.carInspection.model.InspectionStepResult;

public class PrinterTest extends TestCase {

	private Inspection inspection;
	private InspectionRegistry inspectionList;
	private InspectionStep [] inspectionSteps;
	private InspectionReport report;
	
	
	@Override
	protected void setUp() throws Exception {
		String testLicenseNumber = "APK420";
		inspectionList = new InspectionRegistry(testLicenseNumber);
		this.inspection.setInspectionRegistry(inspectionList);
		inspectionSteps = inspectionList.loadStepResults();
		this.inspection = new Inspection();
		
	}
	@Override
	protected void tearDown() throws Exception {
		// Tear down
	}
	/**
	 * tests if the getter works and the right description is printed with the right result.
	 * @param report
	 */
	
	@Test
	public void testPrintReceipt (){
		
	}
	
	
	@Test
	public void testPrintList (){
		
		report = new InspectionReport(inspectionSteps);
		assertEquals(report.detail1, "Däck");
		assertEquals(report.result1, false);
		
	}
}