package se.kth.carInspection.model;

import se.kth.carInspection.integration.Printer;
import se.kth.iv1350.payauth.CreditCard;
import se.kth.iv1350.payauth.PaymentAuthorization;

public class Payment {
	private final Inspection inspection;
	
	/**
	 * creating new payment for this inspection
	 * @param current inspection to pay for
	 */
	public Payment (Inspection inspection) {
		this.inspection = inspection;
	}
	
	/**
	 * calculate cost, using the method in inspection.
	 */
	public float calculateCost() {
		return this.inspection.getInspectionsNeeded() * 100;
	}
	
	// getting confirmation on card from Payment Authorization and printing receipt
	
	public void paymentAuthAndPrint(CreditCard card) {
		PaymentAuthorization paymentAuth = new PaymentAuthorization();
		
		boolean isValid = paymentAuth.authorizePayment(card, (int) calculateCost());
		Receipt receipt = new Receipt(isValid, (int) calculateCost());
		Printer printer = new Printer();
		printer.print(receipt);
	}

}
