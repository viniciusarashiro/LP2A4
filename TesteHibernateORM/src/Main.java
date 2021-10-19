import java.util.Date;

import modelo.ContaComum;
import modelo.Pessoa;
import modelo.PessoaFisica;
import modelo.PessoaJuridica;
import modelo.repositorio.PersistenceConfig;
import modelo.repositorio.PessoaFisicaRepositorio;
import modelo.repositorio.PessoaRepositorio;
import modelo.repositorio.Repositorio;

public class Main {

	public static void main(String[] args) 
	{
		 /* PessoaFisica pf1 = new PessoaFisica();
		
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
		
		PessoaFisicaRepositorio pfREP = new PessoaFisicaRepositorio();
		PessoaFisica pf1 = pfREP.recuperarPessoaFisicaPorId(1);
		System.out.println(pf1.getNome()); 
		
		pj1.setNome("José Silva");
		pj1.setEndereco("Avenida Brasil, 250, Sao Paulo - SP");
		pj1.setCep(89888899);
		pj1.setTelefone("(99) 8888-8889");
		pj1.setRenda(3000.25f);
		pj1.setCnpj(555555555555555l);
		pj1.setNomeFantasia("Extra");
		*/
		
		
		PessoaFisica pf1 = new PessoaFisica();
		pf1.setNome("Joao Pereira");
		pf1.setEndereco("Rua Abc Def, 250, Sao Paulo - SP");
		pf1.setCep(99999999);
		pf1.setTelefone("(99) 9999-9999");
		pf1.setRenda(2500.25f);
		pf1.setCpf(99999999999l);
		pf1.setNascto(new Date(1900 - 1900,3,25));
		
		PessoaFisicaRepositorio repPF = new PessoaFisicaRepositorio(); 	
		
		repPF.atualizar(pf1);
		
		PersistenceConfig.closeEntityManager();
	}

}
