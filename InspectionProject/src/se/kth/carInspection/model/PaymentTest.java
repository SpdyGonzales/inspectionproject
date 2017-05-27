package se.kth.carInspection.model;

import static org.junit.Assert.*;
import org.junit.Test;

import junit.framework.TestCase;
import se.kth.iv1350.payauth.*;
import se.kth.carInspection.integration.*;

public class PaymentTest extends TestCase {
	
	private Inspection inspection;
	private final float totalPriceGuess = 300;
	private CreditCard card;
	
	@Override
	protected void setUp() throws Exception {
		String testLicenseNumber = "APK420";
		this.inspection = new Inspection();
		this.inspection.setInspectionRegistry(CarRegistry.getResultList(testLicenseNumber));		
	}
	
	@Override
	protected void tearDown() throws Exception {
		// Tear down
	}
	/**
	 * test if the calculated cost method is correct and is equal to the expected cost of a full inspection
	 */
	@Test
	public void testCalculateCost() {
		System.out.println("calculateCost");
		Payment payment = new Payment(inspection);
	
		assertEquals(payment.calculateCost(), this.totalPriceGuess, 0);
		
	}
	/**
	 * test if the Payment Authorization is correctly implemented. Expected to always return true
	 */
	@Test	
	public void testPayAuthAndPrint() {
		System.out.println("payAuthAndPrint");
		PaymentAuthorization paymentAuth = new PaymentAuthorization();
		Payment payment = new Payment(inspection);
		boolean isValid = paymentAuth.authorizePayment(card, (int) payment.calculateCost());
		
		assertEquals(true, isValid);
	}

}
