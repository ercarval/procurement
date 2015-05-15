package org.bisso.gco.procurement;

import java.util.Date;

import org.bisso.gco.account.Supplier;
import org.bisso.gco.identity.User;

public class Quotation {
	
	private long id;

	private Supplier supplier;
	
	private User createdBy;
	
	private QuotationItem[] items;
	
	private Date createdDate;

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

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public QuotationItem[] getItems() {
		return items;
	}

	public void setItems(QuotationItem[] items) {
		this.items = items;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
}
