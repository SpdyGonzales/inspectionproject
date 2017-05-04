package se.kth.carInspection.integration;

import se.kth.carInspection.model.InspectionReport;
import se.kth.carInspection.model.Receipt;

public class Printer {
	
	public Printer() {
	}
	
	// prints out receipt. different if payment was approved or not (receipt.status = true or not)
	// in this scenario it always will
	
	public void print (Receipt receipt){
		if(receipt.status){
			System.out.println("Receipt: Purchase was approved with a total of: " + receipt.cost);
		}else{
			System.out.println("Receipt: Purchase was not approved");
		}
	}
	
	public void print (InspectionReport report){
		
		System.out.println("Inspection Report:");
		System.out.println("Inspection 1 - " + report.detail1.getArea() +
							" \n Passed = " + report.result1.getPassed());
		System.out.println("Inspection 2 - " + report.detail2.getArea() +
							" \n Passed = " + report.result2.getPassed());
		System.out.println("Inspection 3 - " + report.detail3.getArea() +
							" \n Passed = " + report.result3.getPassed());
		
	}

}
