package modelo.repositorio;

import java.util.Collection;

import modelo.PessoaJuridica;

public class PessoaJuridicaRepositorio extends Repositorio<PessoaJuridica>{

	public PessoaJuridica recuperarPessoaJuridicaPorId(int id) 
	{
		PessoaJuridica resultado = null;
		
		try
		{
			resultado = PersistenceConfig.entityManager.find(PessoaJuridica.class, id);
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar retornar pessoa jurídica por id! " + e.getMessage());
		}
		
		
		return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<PessoaJuridica> recuperarPessoasJuridicas()
	{
		Collection<PessoaJuridica> resultado = null;
		
		try
		{
			resultado = PersistenceConfig.getEntityManager().createQuery("FROM " + PessoaJuridica.class.getName()).getResultList();
		}
		catch(Exception e)
		{
			System.out.println("Erro ao tentar recuperar pessoas jurídicas! " + e.getMessage());
		}
		
		return resultado;
	}
}
