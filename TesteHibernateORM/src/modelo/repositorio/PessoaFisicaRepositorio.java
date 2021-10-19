package modelo.repositorio;

import java.util.Collection;

import modelo.PessoaFisica;

public class PessoaFisicaRepositorio extends Repositorio<PessoaFisica>{
	
	public PessoaFisica recuperarPessoaFisicaPorId(int id)
	{
		PessoaFisica resultado = null;
		
		try
		{
			resultado =
					PersistenceConfig.getEntityManager()
					.find(PessoaFisica.class, id);
		}
		catch(Exception e)
		{
			System.out.println("Erro ao tentar recuperar a pessoa f�sica! " +
		e.getMessage());
		}
		
		return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<PessoaFisica> recuperarPessoasFisicas()
	{
		Collection<PessoaFisica> resultado = null;
		
		try
		{
			resultado = PersistenceConfig.getEntityManager()
					.createQuery("FROM " + PessoaFisica.class.getName()).getResultList();
		}
		catch(Exception e)
		{
			System.out.println("Erro ao tentar recuperar as pessoas f�sicas "
					+ "cadastradas!" + e.getMessage());
		}
		
		return resultado;
		
	}
}
