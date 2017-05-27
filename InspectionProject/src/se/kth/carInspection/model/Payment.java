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
	 * @return int 
	 */
	public float calculateCost() {
		return this.inspection.getInspectionsNeeded() * 100;
	}
	
	/**
	 *  getting confirmation on card from Payment Authorization and printing receipt.
	 *  creating new receipt and new printer to print receipt. receipt takes two parameter, one to see if it's valid and the other
	 *  to calculate cost.
	 * @param CreditCard card
	 */
	
	public void paymentAuthAndPrint(CreditCard card) {
		PaymentAuthorization paymentAuth = new PaymentAuthorization();
		
		boolean isValid = paymentAuth.authorizePayment(card, (int) calculateCost());
		Receipt receipt = new Receipt(isValid, (int) calculateCost());
		Printer printer = new Printer();
		printer.print(receipt);
	}

}
