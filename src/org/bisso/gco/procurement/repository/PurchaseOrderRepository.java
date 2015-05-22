package org.bisso.gco.procurement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.bisso.gco.procurement.PurchaseOrder;

public class PurchaseOrderRepository {
	// 0 - Registrar o Driver
	// 1 - Conectar
	// 2 - Capacidade de Executar Comandos
	// 3 - Executar o Danado .. do Comando.
	// 4 - liberar a conexao !!!

	public void dropPurchaseOrderDdl() throws Exception {
		// 0 - Registrar o Driver
		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		// Class.forName("com.mysql.jdbc.Driver");

		// 1 - Conectar
		// Padrao de URL jdbc:<nomedovendor>:<subnome>
		Connection conn = DriverManager.getConnection(
		// "jdbc:mysql://localhost:3306/sonar"
				"jdbc:derby://localhost:1527/gco;create=true", "app", "app");

		// Ja estou conectado \o/ !!!!!
		// 2 - Capacidade de Executar Comandos
		Statement stmt = conn.createStatement();

		stmt.executeUpdate("DROP TABLE APP.PURCHASE_ORDER");

		stmt.close();

		conn.close();

	}

	public void createPurchaseOrderDdl() throws Exception {
		// 0 - Registrar o Driver
		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		// Class.forName("com.mysql.jdbc.Driver");

		// 1 - Conectar
		// Padrao de URL jdbc:<nomedovendor>:<subnome>
		Connection conn = DriverManager.getConnection(
		// "jdbc:mysql://localhost:3306/sonar"
				"jdbc:derby://localhost:1527/gco;create=true", "app", "app");

		// Ja estou conectado \o/ !!!!!
		// 2 - Capacidade de Executar Comandos
		Statement stmt = conn.createStatement();

		stmt.executeUpdate("CREATE TABLE APP.PURCHASE_ORDER ("
				+ "ID  INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS"
				+ " AS IDENTITY (START WITH 1, INCREMENT BY 1),"
				+ "SUPPLIER_ID INTEGER," + "QUOTATION_ID INTEGER,"
				+ "USER_ID INTEGER, " + "CREATED_DATE DATE,"
				+ "LASTMODIFIED_DATE DATE )");

		stmt.close();

		conn.close();

	}

	public void create(PurchaseOrder purchaseOrder) throws Exception {
		/*
		 * " insert into app.puchase_order (supplier_id,quotation_id ,user_id )
		 * values ( " + purchaseOrder.getSupplier().getId() + " , " +
		 * purchaseOrder.getQuotation().getId() + " , " +
		 * purchaseOrder.getUser().getId() )
		 */

		// 0 - Registrar o Driver
		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		// Class.forName("com.mysql.jdbc.Driver");

		// 1 - Conectar
		// Padrao de URL jdbc:<nomedovendor>:<subnome>
		Connection conn = DriverManager.getConnection(
		// "jdbc:mysql://localhost:3306/sonar"
				"jdbc:derby://localhost:1527/gco;create=true", "app", "app");

		// Ja estou conectado \o/ !!!!!
		// 2 - Capacidade de Executar Comandos
		Statement stmt = conn.createStatement();

		stmt.executeUpdate(" insert into app.purchase_order "
				+ "  (supplier_id,quotation_id ,user_id ) " + "  values ( "
				+ purchaseOrder.getSupplier().getId() + " , "
				+ purchaseOrder.getQuotation().getId() + " , "
				+ purchaseOrder.getCreatedBy().getId() + " )");

		stmt.close();

		conn.close();

	}

	public void update(PurchaseOrder purchaseOrder) throws Exception {

		// 0 - Registrar o Driver
		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		// Class.forName("com.mysql.jdbc.Driver");

		// 1 - Conectar
		// Padrao de URL jdbc:<nomedovendor>:<subnome>
		Connection conn = DriverManager.getConnection(
		// "jdbc:mysql://localhost:3306/sonar"
				"jdbc:derby://localhost:1527/gco;create=true", "app", "app");

		// Ja estou conectado \o/ !!!!!
		// 2 - Capacidade de Executar Comandos
		Statement stmt = conn.createStatement();

		stmt.executeUpdate(" update  app.purchase_order "
				+ "  set supplier_id = " + purchaseOrder.getSupplier().getId()
				+ "  , quotation_id = " + purchaseOrder.getQuotation().getId()
				+ "  , user_id = " + purchaseOrder.getCreatedBy().getId()
				+ "  where id =  " + purchaseOrder.getId());

		stmt.close();

		conn.close();

	}

	public void delete(PurchaseOrder purchaseOrder) throws Exception {

	}

	public ArrayList<PurchaseOrder> listAll() throws Exception {

		// 0 - Registrar o Driver
		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		// Class.forName("com.mysql.jdbc.Driver");

		// 1 - Conectar
		// Padrao de URL jdbc:<nomedovendor>:<subnome>
		Connection conn = DriverManager.getConnection(
		// "jdbc:mysql://localhost:3306/sonar"
				"jdbc:derby://localhost:1527/gco;create=true", "app", "app");

		// Ja estou conectado \o/ !!!!!
		// 2 - Capacidade de Executar Comandos
		Statement stmt = conn.createStatement();

		ResultSet rset = stmt.executeQuery("select * from app.purchase_order");
	
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
