package modelo.repositorio;

import java.sql.*;
import java.util.ArrayList;

import modelo.ContaComum;

public class ContaComumDAO extends FabricaConexao
{
	public long criarContaComum(ContaComum contaComum) {
		
		long numero = 0;
		
		try 
		{
			String stmt = "insert into contascomuns (numero, abertura, fechamento, situacao, "
					+ "senha, saldo) values (?, ?, ?, ?, ?, ?) returning numero";
			
			PreparedStatement pStmt = conn.prepareStatement(stmt);
			
			pStmt.setLong(1, contaComum.getNumero());
			pStmt.setDate(2, new java.sql.Date(contaComum.getAbertura().getTime()));
			pStmt.setDate(3, new java.sql.Date(contaComum.getFechamento().getTime()));
			pStmt.setByte(4, contaComum.getSituacao());
			pStmt.setInt(5, contaComum.getSenha());
			pStmt.setDouble(6, contaComum.getSaldo());
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) 
			{
				numero = rs.getLong("numero");
			}
		}
		catch(Exception e) 
		{
			System.out.println("Erro ao criar Conta Comum " + e.getMessage());
		}
		
		
		return numero;
	}
	
	public ArrayList<ContaComum> recuperarContasComuns() {
		ArrayList<ContaComum> contasComuns = null;
		
		try
		{
			String stmt = "select numero, abertura, fechamento, situacao, senha, saldo "
					+ "from contascomuns";
			
			PreparedStatement pStmt = conn.prepareStatement(stmt);
			
			ResultSet rs = pStmt.executeQuery();
			
			contasComuns = new ArrayList<ContaComum>();
			
			while(rs.next())
			{
				ContaComum contaComum = new ContaComum(rs.getLong("numero"), 
						rs.getDate("abertura"));
				contaComum.setFechamento(rs.getDate("fechamento"));
				contaComum.setSituacao(rs.getByte("situacao"));
				contaComum.setSenha(rs.getInt("senha"));
				contaComum.setSaldo(rs.getDouble("saldo"));
				
				contasComuns.add(contaComum);
			}
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar recuperar contas comuns! " + e.getMessage());
		}
		
		return contasComuns;
	}

	public ContaComum recuperarContaComumPorNumero(long numero)
	{
		ContaComum contaComum = null;
		
		try
		{
			
			String stmt = "select numero, abertura, fechamento, situacao, senha, saldo "
					+ "from contascomuns where numero = ?";
			
			PreparedStatement pStmt = conn.prepareStatement(stmt);
			pStmt.setLong(1, numero);
			
			ResultSet rs = pStmt.executeQuery();
			
			
			
			if(rs.next())
			{
				contaComum = new ContaComum(rs.getLong("numero"), rs.getDate("abertura"));
				
				contaComum.setFechamento(rs.getDate("fechamento"));
				contaComum.setSituacao(rs.getByte("situacao"));
				contaComum.setSenha(rs.getInt("senha"));
				contaComum.setSaldo(rs.getDouble("saldo"));
			}
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar recuperar conta comum por número! " 
		+ e.getMessage());
		}
		
		return contaComum;
	}

	public long removerContaComum(long numero) {
		
		long numeroConta = 0;
		
		try
		{
			String stmt = "delete from contascomuns where numero = ? returning numero";
			
			PreparedStatement pStmt = conn.prepareStatement(stmt);
			
			pStmt.setLong(1, numero);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next())
			{
				numeroConta = rs.getLong("numero");
			}
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar remover conta! " + e.getMessage());
		}
		
		return numeroConta;
	}

	public long editarContaComum(long numero, byte situacao, int senha) {
		long numeroConta = 0;
		
		try
		{
			String stmt = "update contascomuns SET situacao = ?, senha = ? "
					+ "where numero = ? returning numero";
			
			PreparedStatement pStmt = conn.prepareStatement(stmt);
			
			pStmt.setByte(1, situacao);
			pStmt.setInt(2, senha);
			pStmt.setLong(3, numero);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next())
			{
				numeroConta = rs.getLong("numero");
			}
		}
		catch (Exception e)
		{
			System.out.println("Erro ao editar Conta Comum! " + e.getMessage());
		}
		
		return numeroConta;
	}
}
