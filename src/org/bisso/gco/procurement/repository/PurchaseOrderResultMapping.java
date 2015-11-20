package org.bisso.gco.procurement.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bisso.commons.repository.ResultMapping;
import org.bisso.gco.procurement.PurchaseOrder;

public class PurchaseOrderResultMapping implements ResultMapping {

	@Override
	public List mapping(ResultSet rset) throws Exception {
		
		ArrayList<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
		while ( rset.next() ) {
			
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setId( rset.getLong("id") );
			purchaseOrder.getSupplier().setId( rset.getLong("supplier_id") );
			purchaseOrder.getCreatedBy().setId( rset.getLong("user_id") );
			purchaseOrder.getQuotation().setId( rset.getLong("quotation_id") );
			purchaseOrders.add(purchaseOrder);
			System.out.println("");
			
		}
		
		return purchaseOrders;
		
	}

}
