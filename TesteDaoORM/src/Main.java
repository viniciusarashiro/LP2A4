import modelo.Pessoa;
import modelo.repositorio.*;
import java.util.*;

public class Main {

	public static void main(String[] args)
	{
		/* Exemplo de Execução 1 */
		/*
		Pessoa p1 = new Pessoa();
		
		p1.setNome("Maria dos Santos");
		p1.setEndereco("Rua Nove de Julho, 500, Sao Paulo - SP");
		p1.setCep(70605222l);
		p1.setTelefone("(88) 8888-8888");
		p1.setRenda(5000.75f);
		
		PessoaDAO pDAO = new PessoaDAO(); //Faz abertura da conexão
		
		int idP1 = pDAO.criarPessoa(p1); //Executa a operação no BD
		
		p1.setId(idP1);
		
		System.out.println("ID da pessoa inserida: " + p1.getId());
		
		pDAO.fecharConexao(); //Fecha a conexão
		*/
		
		/* Exemplo de Execução 2 */
		PessoaDAO pDAO = new PessoaDAO();
		
		ArrayList<Pessoa> pessoas = pDAO.recuperarPessoas();
		
		pessoas.forEach(p -> System.out.println("Nome: " + p.getNome()));
		
		pDAO.fecharConexao();
	}

}
