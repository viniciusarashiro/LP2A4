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
			
			System.out.println("Conex�o aberta!");
		}
		catch (Exception e) {
			System.out.println("Erro ao criar conex�o! " + e.getMessage());
		}
	}
	
	public void fecharConexao() {
		try {
			conn.close();
			System.out.println("Conex�o fechada!");
		} 
		catch (Exception e){
			System.out.println("Erro ao fechar conex�o! " + e.getMessage());
		}
	}
	
}
