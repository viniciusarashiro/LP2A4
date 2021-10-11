import modelo.Pessoa;
import modelo.PessoaFisica;
import modelo.repositorio.*;
import java.util.*;

public class Main {

	public static void main(String[] args)
	{
		PessoaFisica p1 = new PessoaFisica();
		
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
		
		pfDAO.fecharConexao();
	}

}
