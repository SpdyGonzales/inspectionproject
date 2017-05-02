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
	
	public void newInspection() {
		this.inspection = new Inspection();
		garage.nextCustomer();
	}
	
	public void closeDoor() {
		garage.closeDoor();
	}
	
	public float enterLicenseNumber (String licenseNumber) {
		this.inspection.setInspectionRegistry(CarRegistry.getResultList(licenseNumber));
		
		this.payment = new Payment(this.inspection);
		return this.payment.calculateCost();
	}
	public void cardPayment(CreditCard card){
		this.payment.paymentAuthAndPrint(card);
	}
	
	public InspectionStepArea performInspection() {
		return inspection.getNextStep();
	}
	public void enterResult(boolean passed) {
		inspection.setLastStepResult(new InspectionStepResult(passed));
	}
}
   