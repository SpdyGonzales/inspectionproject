package se.kth.carInspection.model;

public class Receipt {
	public boolean status;
	public int cost;
	
	/**
	 *  creates receipt
	 * @param boolean status
	 * @param int cost
	 */
	
	public Receipt(boolean status, int cost) {
		this.status = status;
		this.cost = cost;
	}

}
