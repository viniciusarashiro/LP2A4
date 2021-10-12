import modelo.ContaComum;
import modelo.Pessoa;
import modelo.PessoaFisica;
import modelo.repositorio.*;
import java.util.*;

public class Main {

	public static void main(String[] args)
	{
		/* PessoaFisica p1 = new PessoaFisica();
		
		p1.setNome("Joao Pereira");
		p1.setEndereco("Rua Abc Def, 250, Sao Paulo - SP");
		p1.setCep(77705333);
		p1.setTelefone("(77) 7777-7777");
		p1.setRenda(4800.5f);
		p1.setCpf(11111111111l);
		p1.setNascto(new Date(1990 - 1900, 3, 25));
		
		PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();
		
		int idP1 = pfDAO.criarPessoaFisica(p1);
		
		System.out.println("ID da pessoa física inserida: " + p1.getId());
		
		pfDAO.fecharConexao(); */
		
		/* Criar conta comum */
		
		/* ContaComum c1 = ContaComum.abrirConta();
		c1.setFechamento(new Date(2022 - 1900, 3, 25));
		c1.setSaldo(4500.00);
		c1.setSenha(123);
		
		ContaComumDAO c1DAO = new ContaComumDAO();
		
		long c1Numero = c1DAO.criarContaComum(c1);
		
		System.out.println("Número da conta comum criada: " + c1.getNumero()); 
		 
		c1DAO.fecharConexao(); */
		
		//ContaComumDAO c1DAO = new ContaComumDAO();
		
		//ContaComum numeroConta = c1DAO.recuperarContaComumPorNumero(4830522277178873107l);
		//System.out.println("Número da conta: " + numeroConta.getNumero());
		
		//long numeroConta = c1DAO.removerContaComum(4830522277178873107l);
		//System.out.println("Numero da conta removida: " + numeroConta);
		
		//ArrayList<ContaComum> contasComuns = c1DAO.recuperarContasComuns();
		//contasComuns.forEach(conta -> System.out.println(conta.getNumero()));
		
		//long numeroConta = c1DAO.editarContaComum(4830522277178873107l, (byte) 2, 456);
		//System.out.println("Conta editada!");
		
		//c1DAO.fecharConexao();
		
	}

}
