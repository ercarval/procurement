package org.bisso.gco.account;

import java.util.ArrayList;

import com.mysql.fabric.Response;

public class SupplierRepositoryTest {

	private SupplierRepository repository;
	
	private SupplierFixtureFactory fixtureFactory;

	public SupplierRepositoryTest() {
		repository = new SupplierRepository();
		fixtureFactory = new SupplierFixtureFactory();
	}

	public void dropSupplierTables() throws Exception {
		
		repository.createSupplierTables();
		
		repository.dropSupplierTables();
		
	}

	public void createSupplierTables() throws Exception {
		repository.createSupplierTables();
	}

	public void create() throws Exception {
		
		Supplier supplier = fixtureFactory.newBaseSupplier();
		
		repository.create(supplier);
		
		ArrayList<Supplier> suppliers = repository.listAll();
		
		if (suppliers.size() > 0) {
			System.out.println("Teste create Com Sucesso ..!!!!");
		} else {
			System.out.println("Teste create Faio .. :_(");
		}
		
	}

	public void update() throws Exception {
		
		Supplier supplier = fixtureFactory.newBaseSupplier();
		supplier.setId(1L);
		supplier.setName("Noosssa Bissos S/A");
		
		repository.update(supplier);
		
		Supplier storedSupplier = repository.findById(supplier.getId());
		
		if (storedSupplier.getName().equals(supplier.getName())) {
			System.out.println(" :) - JJ Funnfou ... !!!");
		} else {
			System.out.println(" :_( - Não Funnfou ... !!!");
		}
		
		
	}

	public void delete() throws Exception {
		// > 
		repository.dropSupplierTables();
		repository.createSupplierTables();
		
		Supplier supplier = fixtureFactory.newBaseSupplier();
		
		repository.create(supplier);
		// < Setup
		
		Supplier storedSupplier = repository.findById(1L);
		
		
		repository.delete( storedSupplier );	
		
		Supplier deletedSupplier = repository.findById(storedSupplier.getId());
		
		if (deletedSupplier.getId() == 0) {
			System.out.println("Supplier Deletado com Sucesso :)");
		} else { 
			System.out.println("Supplier nao morreu :(");
		}
	}

	public void listAll() throws Exception {
		
		// > 
		repository.dropSupplierTables();
		repository.createSupplierTables();
		
		Supplier supplierFLL = fixtureFactory.newBaseSupplier();
		Supplier supplierLBG = fixtureFactory.newBaseSupplier();
		supplierFLL.setName("FLL");
		supplierLBG.setName("LBG");
			
		repository.create(supplierFLL);
		repository.create(supplierLBG);
		// < Setup
		
		ArrayList<Supplier> suppliers = repository.listAll();
		
		if (suppliers.size() > 0) {
			System.out.println("List All com sucesso  :)");
		} else { 
			System.out.println("List All faio !!! :_(");
		}		

	}
	
	public static void main(String[] args) throws Exception {
		
		SupplierRepositoryTest test = new SupplierRepositoryTest();
		
		test.dropSupplierTables();
		
		test.createSupplierTables();
		
		test.create();
		test.update();
		test.delete();
		test.listAll();
		
	}
	
}
