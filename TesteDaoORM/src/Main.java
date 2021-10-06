import modelo.Pessoa;
import modelo.repositorio.*;
import java.util.*;

public class Main {

	public static void main(String[] args)
	{
		/* Exemplo de Execu��o 1 */
		/*
		Pessoa p1 = new Pessoa();
		
		p1.setNome("Maria dos Santos");
		p1.setEndereco("Rua Nove de Julho, 500, Sao Paulo - SP");
		p1.setCep(70605222l);
		p1.setTelefone("(88) 8888-8888");
		p1.setRenda(5000.75f);
		
		PessoaDAO pDAO = new PessoaDAO(); //Faz abertura da conex�o
		
		int idP1 = pDAO.criarPessoa(p1); //Executa a opera��o no BD
		
		p1.setId(idP1);
		
		System.out.println("ID da pessoa inserida: " + p1.getId());
		
		pDAO.fecharConexao(); //Fecha a conex�o
		*/
		
		/* Exemplo de Execu��o 2 */
		PessoaDAO pDAO = new PessoaDAO();
		
		ArrayList<Pessoa> pessoas = pDAO.recuperarPessoas();
		
		pessoas.forEach(p -> System.out.println("Nome: " + p.getNome()));
		
		pDAO.fecharConexao();
	}

}
