package org.bisso.gco.procurement;

import org.bisso.gco.account.Supplier;
import org.bisso.gco.identity.User;

public class PurchaseOrderTest {
	
	public static void main(String[] args) {
		
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		
		if (purchaseOrder.getCreatedBy() == null) {
			System.out.println("Faio o Created By");
		}
		
		if (purchaseOrder.getItems() == null) {
			System.out.println("Faio o Items");
		}
		
		if (purchaseOrder.getSupplier() == null) {
			System.out.println("Faio o Supplier");
		}
		
		
		
		
	}

}
