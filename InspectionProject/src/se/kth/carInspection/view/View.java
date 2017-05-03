package se.kth.carInspection.view;

import java.util.Scanner;
import java.util.*;

import se.kth.carInspection.controller.Controller;
import se.kth.carInspection.model.InspectionStepArea;
import se.kth.iv1350.payauth.CreditCard;

public class View {
	
	public static void main(String[] args) {
		new View(new Controller());
	}
	
	Scanner in = new Scanner(System.in);
	
	public View(Controller controller) {
		System.out.println("Call to controller.newInspection");
		controller.newInspection();
		System.out.println("New inspection has started\n");
		controller.closeDoor();
		
		System.out.println("Enter License Number:");
		String regNum = in.nextLine();
		
		float cost = controller.enterLicenseNumber(regNum);
		
		System.out.println("Inspection Cost: " + cost + "\n");
		
		/**
		 * Only option to pay with Credit Card
		 */
		
		System.out.println("call to controller.cardPayment");
		controller.cardPayment(new CreditCard(233232, "Svensson", "Anders", null, 291));
		
		InspectionStepArea instruction;
		
		/**
		 * getArea is called to show details of area on car
		 * performInspection is called til it returns null 
		 */
		
		while((instruction = controller.performInspection()) != null) {
			System.out.println("controller is called with methods performInspection");
			System.out.println(instruction.getArea() + "\n");
			
			System.out.println("result is always true but called anyway");
			controller.enterResult(true);
		}
		
		System.out.println("Thank you. Press Enter to END inspection");
		in.nextLine();
		controller.inspectionDone();
		
	
	}

}
