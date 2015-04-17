package org.bisso.gco.procurement;

import org.bisso.gco.account.Supplier;
import org.bisso.gco.identity.User;

public class PurchaseOrderTest {
	
	public static void main(String[] args) {
		
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		
		purchaseOrder.items = new PurchaseOrderItem[10];
		purchaseOrder.supplier = new Supplier();
		purchaseOrder.createdBy = new User();
		
		
	}

}
