package se.kth.carInspection.controller;

import se.kth.carInspection.integration.CarRegistry;
import se.kth.carInspection.model.Inspection;
import se.kth.carInspection.model.InspectionStepArea;
import se.kth.carInspection.model.InspectionStepResult;
import se.kth.carInspection.model.Payment;
import se.kth.iv1350.garage.Garage;
import se.kth.iv1350.payauth.CreditCard;

public class Controller {
	
	private Inspection inspection;
	private Payment payment;
	Garage garage = new Garage();
	
	//new inspection initiated. garage opens and displays number
	
	public void newInspection() {
		this.inspection = new Inspection();
		garage.nextCustomer();
	}
	
	public void closeDoor() {
		garage.closeDoor();
	}
	
	// license number is entered. returns total cost of inspection
	// inspection details are fetched in registry
	
	public float enterLicenseNumber (String licenseNumber) {
		this.inspection.setInspectionRegistry(CarRegistry.getResultList(licenseNumber));
		
		this.payment = new Payment(this.inspection);
		return this.payment.calculateCost();
	}
	
	// credit card has been created and passed to payment
	
	public void cardPayment(CreditCard card){
		this.payment.paymentAuthAndPrint(card);
	}
	
	// specifies details of next inspection
	
	public InspectionStepArea performInspection() {
		return inspection.getNextStep();
	}
	
	// enters result of the current inspection. now it's always pass.
	
	public void enterResult(boolean passed) {
		inspection.setLastStepResult(new InspectionStepResult(passed));
	}
	
	public void inspectionDone() {
		inspection.endInspection();
		
	}
}
   