package org.bisso.gco.procurement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
	
public class PurchaseOrderRepository {
//0 - Registrar o Driver
	//1 - Conectar 
		//2 - Capacidade de Executar Comandos
			//3 - Executar o Danado .. do Comando.
				//4 - liberar a conexao !!!

	
	public void createPurchaseOrderDdl() throws Exception {
		//0 - Registrar o Driver
		Class.forName("org.apache.derby.jdbc.ClientDriver40");
		
		//1 - Conectar 
		//Padrao de URL jdbc:<nomedovendor>:<subnome>
		Connection conn = DriverManager
					.getConnection("jdbc:derby://localhost:1527/gco;create=true"
							, "app"
							, "app");
		
		//Ja estou conectado \o/ !!!!!
		//2 - Capacidade de Executar Comandos
		State
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
