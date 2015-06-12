package org.bisso.gco.procurement;

import org.bisso.gco.account.Supplier;
import org.bisso.gco.identity.User;

public class PurchaseOrder {

	private long id;


	private Supplier supplier;
	
	private Quotation quotation;
	
	private User createdBy;
	
	private PurchaseOrderItem[] items;
	
	public PurchaseOrder () {
		items = new PurchaseOrderItem[10];
		supplier = new Supplier();
		createdBy = new User();
		quotation = new Quotation();
	}

	public PurchaseOrder (User user) {
		
	}

	public PurchaseOrder (Supplier supplier , User user) {
		
	}

	public PurchaseOrder (  User user, Supplier supplier) {
		
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Quotation getQuotation() {
		return quotation;
	}

	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public PurchaseOrderItem[] getItems() {
		return items;
	}

	public void setItems(PurchaseOrderItem[] items) {
		this.items = items;
	}
	
	/*
	public boolean convertQuotationIntoPurchaseOrder() {
		//verificar se a quotation esta expirada
		if (quotation.getCreatedDate() > MAX_CONVERTION_DATE) {
			return false;
		}
		
		if (quotation.isExpired())
		
		//converter para PO 
		return true;
	}
	*/
	
	
	
}
