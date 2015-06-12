package org.bisso.gco.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.bisso.gco.identity.User;

/**
 * Agora que agente criou este repository zuado ... como 
 * que agente vai fazer para melhora-lo ?
 * 
 * @author ERCARVAL
 */
public class SupplierRepository {
	
	public void dropSupplierTables() throws Exception {

		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		Connection conn = DriverManager.getConnection(
				"jdbc:derby://localhost:1527/gco;create=true", "app", "app");

		Statement stmt = conn.createStatement();
		stmt.executeUpdate("DROP TABLE APP.SUPPLIER");
		stmt.close();
		conn.close();
	}

	public void createSupplierTables() throws Exception {
		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		Connection conn = DriverManager.getConnection(
				"jdbc:derby://localhost:1527/gco;create=true", "app", "app");

		Statement stmt = conn.createStatement();
		stmt.executeUpdate("CREATE TABLE APP.SUPPLIER ( "
						+ " ID  INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS "
						+ " IDENTITY (START WITH 1, INCREMENT BY 1),"
						+ " NAME VARCHAR(255) )");
		stmt.close();
		conn.close();
	}
	
	public void create(Supplier supplier) throws Exception {

		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/gco;create=true", "app", "app");

		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate("INSERT INTO APP.SUPPLIER ( NAME ) VALUES ( '"
					     + supplier.getName() +  "' )"  );
		stmt.close();
		conn.close();
		
	}
	
	public void update(Supplier supplier) throws Exception {

		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/gco;create=true", "app", "app");

		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate("update APP.SUPPLIER set NAME='"	+ supplier.getName() + "' "
							+ " where id = " + supplier.getId() );
		stmt.close();
		conn.close();
		
	}
	
	public void delete(Supplier supplier) throws Exception {
		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/gco;create=true", "app", "app");
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("delete from APP.SUPPLIER where id = " + supplier.getId() );
		stmt.close();
		conn.close();
	}
	
	public ArrayList<Supplier> listAll() throws Exception {

		ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/gco;create=true", "app", "app");
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("select * from APP.SUPPLIER");
		
		while ( rset.next() ) {
			Supplier supplier = new Supplier();
			supplier.setId( rset.getLong("id") );
			supplier.setName( rset.getString("name") );
			suppliers.add(supplier);
		}

		rset.close();
		stmt.close();
		conn.close();		
		
		return suppliers;
	}

	public Supplier findById(long id) throws Exception {
		
		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/gco;create=true", "app", "app");
		Statement stmt = conn.createStatement();
		
		ResultSet rset = stmt.executeQuery("select * from APP.SUPPLIER where id = " + id);
		
		Supplier supplier = new Supplier();
		
		if ( rset.next() ) {
			supplier.setId( rset.getLong("id") );
			supplier.setName( rset.getString("name") );
		}

		rset.close();
		stmt.close();
		conn.close();		
		
		return supplier;
	}	
	
}
