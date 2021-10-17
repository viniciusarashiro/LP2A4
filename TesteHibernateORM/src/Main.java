import java.util.Date;

import modelo.ContaComum;
import modelo.PessoaFisica;
import modelo.repositorio.PersistenceConfig;
import modelo.repositorio.Repositorio;

public class Main {

	public static void main(String[] args) 
	{
		PessoaFisica pf1 = new PessoaFisica();
		
		pf1.setNome("Joao Pereira");
		pf1.setEndereco("Rua Abc Def, 250, Sao Paulo - SP");
		pf1.setCep(99999999);
		pf1.setTelefone("(99) 9999-9999");
		pf1.setRenda(2500.25f);
		pf1.setCpf(99999999999l);
		pf1.setNascto(new Date(1900 - 1900,3,25));
		
		
		Repositorio<PessoaFisica> repPF = new Repositorio<PessoaFisica>();
		
		repPF.criar(pf1);
		
		ContaComum cc1 = ContaComum.abrirConta();
		
		cc1.setSenha(123456);
		
		Repositorio<ContaComum> repCC = new Repositorio<ContaComum>();
		
		repCC.criar(cc1);
		
		pf1.getContas().add(cc1);
		
		repPF.atualizar(pf1);
		
		PersistenceConfig.closeEntityManager();
	}

}
