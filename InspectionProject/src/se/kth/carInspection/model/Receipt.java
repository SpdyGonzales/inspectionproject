package se.kth.carInspection.model;

public class Receipt {
	public boolean status;
	public int cost;
	
	//creates receipt
	
	public Receipt(boolean status, int cost) {
		this.status = status;
		this.cost = cost;
	}

}
