package org.bisso.gco.procurement;

import org.bisso.gco.identity.User;

public class PurchaseRequisition {

	private User requestedBy;
	
	private User createdBy;
	
	private PurchaseRequisitionItem[] items;

	public User getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(User requestedBy) {
		this.requestedBy = requestedBy;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public PurchaseRequisitionItem[] getItems() {
		return items;
	}

	public void setItems(PurchaseRequisitionItem[] items) {
		this.items = items;
	}
	
	
	
}
