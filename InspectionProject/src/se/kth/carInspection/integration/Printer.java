package se.kth.carInspection.integration;

import se.kth.carInspection.model.Receipt;

public class Printer {
	
	public Printer() {
	}
	public void print (Receipt receipt){
		if(receipt.status){
			System.out.println("Purchase was approved with a total of: " + receipt.cost);
		}else{
			System.out.println("Purchase was not approved");
		}
	}

}
