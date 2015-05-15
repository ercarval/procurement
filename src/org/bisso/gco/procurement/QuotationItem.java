package org.bisso.gco.procurement;


public class QuotationItem {
	
	private PurchaseRequisitionItem requisitionItem;
	
	private double price;

	public PurchaseRequisitionItem getRequisitionItem() {
		return requisitionItem;
	}

	public void setRequisitionItem(PurchaseRequisitionItem requisitionItem) {
		this.requisitionItem = requisitionItem;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
