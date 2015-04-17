package org.bisso.gco.procurement;

import org.bisso.gco.account.Supplier;
import org.bisso.gco.identity.User;

public class PurchaseOrder {

	Supplier supplier;
	
	Quotation quotation;
	
	User createdBy;
	
	PurchaseOrderItem[] items;
	
}
