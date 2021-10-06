package modelo.repositorio;

import java.sql.*;
import java.util.*;

public class FabricaConexao {
	
	protected Connection conn;
	
	public FabricaConexao() {
		try {
			String url = "jdbc:postgresql://localhost/testepgdb";
			
			Properties props = new Properties();
			props.setProperty("user", "postgres");
			props.setProperty("password", "postgres");
			props.setProperty("ssl", "false");
			
			conn = DriverManager.getConnection(url, props);
			
			System.out.println("Conexão aberta!");
		}
		catch (Exception e) {
			System.out.println("Erro ao criar conexão! " + e.getMessage());
		}
	}
	
	public void fecharConexao() {
		try {
			conn.close();
			System.out.println("Conexão fechada!");
		} 
		catch (Exception e){
			System.out.println("Erro ao fechar conexão! " + e.getMessage());
		}
	}
	
}
