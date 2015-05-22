package org.bisso.gco.procurement.repository;

import org.bisso.gco.account.Supplier;
import org.bisso.gco.identity.User;
import org.bisso.gco.procurement.PurchaseOrder;
import org.bisso.gco.procurement.Quotation;

public class PurchaseOrderRepositoryTest {

	private PurchaseOrderRepository	repository;
	
	public PurchaseOrder createNewPurchaseOrderFixture() {

		User createdBy = new User();
		createdBy.setId(12);
		createdBy.setName("Ze das Cove");

		Quotation quote = new Quotation();
		quote.setCreatedBy(createdBy);
		quote.setId(23);
		
		Supplier supplier = new Supplier(); 
		supplier.setId(343);
		
		PurchaseOrder purchase = new PurchaseOrder();
		purchase.setCreatedBy(createdBy);
		purchase.setQuotation(quote);
		purchase.setSupplier(supplier);
		
		return purchase;
	}
	
	public PurchaseOrderRepositoryTest () {
		repository = new PurchaseOrderRepository();
	}
	
	public void dropPurchaseOrderIntoRepositoryTest() throws Exception {
		repository.dropPurchaseOrderDdl();
	}
	public void createTablePurchaseOrderIntoRepositoryTest() throws Exception {
		repository.createPurchaseOrderDdl();
	}

	public void createNewPurchaseOrderIntoRepositoryTest() throws Exception {
		PurchaseOrder purchaseOrder = createNewPurchaseOrderFixture();
		repository.create( purchaseOrder );
	}
			
	public void updatePurchaseOrderIntoRepositoryTest() throws Exception {
		User createdBy = new User();
		createdBy.setId(234);
		createdBy.setName("Seu Ze das Cove");
		
		PurchaseOrder purchaseOrder = createNewPurchaseOrderFixture();
		purchaseOrder.setCreatedBy(createdBy);

		repository.update( purchaseOrder );
		
	}

	public void removePurchaseOrderIntoRepositoryTest() {
		//PurchaseOrder purchaseOrder = createNewPurchaseOrderFixture();
		//repository.delete( purchaseOrder );
	}
	
	
	public static void main(String[] args) throws Exception {
 
		PurchaseOrderRepositoryTest	test = new PurchaseOrderRepositoryTest();
		
		test.dropPurchaseOrderIntoRepositoryTest();
		
		test.createTablePurchaseOrderIntoRepositoryTest();
		
		test.createNewPurchaseOrderIntoRepositoryTest();
		
		test.updatePurchaseOrderIntoRepositoryTest();
		
		
	}

}
