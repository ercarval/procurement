package org.bisso.commons.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/**
 * 0 registrar driver
 * 1 conectar
 * 2 criar statement
 * 3 executar statement
 * 4 desconectar
 * 
 * @author ERCARVAL
 *
 */
public class CommonsRepository {

	
	public Connection getConnection() throws Exception {
		
		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		// Class.forName("com.mysql.jdbc.Driver");

		// 1 - Conectar
		// Padrao de URL jdbc:<nomedovendor>:<subnome>
		return  DriverManager.getConnection(
		// "jdbc:mysql://localhost:3306/sonar"
				"jdbc:derby://localhost:1527/gco;create=true", "app", "app");

	}
	
	public int executeUpdate (Connection conn, String sql) throws Exception {
		
		Statement stmt = conn.createStatement();

		int result = stmt.executeUpdate(sql);

		stmt.close();
		
		return result;
		
	}
	
	public int executeUpdate ( String sql) throws Exception {
		
		Connection conn = getConnection();
		
		int result = executeUpdate(conn, sql);
		
		conn.close();
		
		return result;
	}
	
		
	
	
}
