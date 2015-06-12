package org.bisso.gco.identity.repository;

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
public class UserRepository {
	
	public void dropUserTables() throws Exception {

		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		Connection conn = DriverManager.getConnection(
				"jdbc:derby://localhost:1527/gco;create=true", "app", "app");

		Statement stmt = conn.createStatement();
		stmt.executeUpdate("DROP TABLE APP.USER");
		stmt.close();
		conn.close();
	}

	public void createUserTables() throws Exception {
		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		Connection conn = DriverManager.getConnection(
				"jdbc:derby://localhost:1527/gco;create=true", "app", "app");

		Statement stmt = conn.createStatement();
		stmt.executeUpdate("CREATE TABLE APP.USER ( "
						+ " ID  INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS "
						+ " IDENTITY (START WITH 1, INCREMENT BY 1),"
						+ "NOME VARCHAR(255)");
		stmt.close();
		conn.close();
	}
	
	public void create(User user) throws Exception {

		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/gco;create=true", "app", "app");

		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate("INSERT INTO APP.USER ( NAME ) VALUES ( '"
					     + user.getName() +  "' )"  );
		stmt.close();
		conn.close();
		
	}
	
	public void update(User user) throws Exception {

		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/gco;create=true", "app", "app");

		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate("update APP.USER set NAME='"	+ user.getName() + "' "
							+ " where id = " + user.getId() );
		stmt.close();
		conn.close();
		
		
	}
	
	public void delete(User user) throws Exception {
		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/gco;create=true", "app", "app");
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("delete from APP.USER where id = " + user.getId() );
		stmt.close();
		conn.close();
	}
	
	public ArrayList<User> listAll() throws Exception {

		ArrayList<User> users = new ArrayList<User>();
		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/gco;create=true", "app", "app");
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("select * from app.user");
		
		while ( rset.next() ) {
			User user = new User();
			user.setId( rset.getLong("id") );
			user.setName( rset.getString("name") );
			users.add(user);
		}

		rset.close();
		stmt.close();
		conn.close();		
		
		
		return users;
	}

}
