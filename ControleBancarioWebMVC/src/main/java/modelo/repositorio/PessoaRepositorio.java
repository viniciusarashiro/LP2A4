package modelo.repositorio;

import java.util.Collection;

import modelo.Pessoa;

public class PessoaRepositorio extends Repositorio<Pessoa>
{
	public Pessoa recuperarPessoaPorId(int id)
	{
		Pessoa resultado = null;
		
		try
		{
			resultado = PersistenceConfig.getEntityManager().find(Pessoa.class, id);
		}
		catch(Exception e)
		{
			System.out.println("Erro ao tentar recuperar pessoa por id! " + e.getMessage());
		}
		
		return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Pessoa> recuperarPessoas()
	{
		Collection<Pessoa> resultado = null;
		
		try
		{
			resultado = PersistenceConfig.getEntityManager().createQuery("FROM " + Pessoa.class.getName()).getResultList();
		}
		catch(Exception e)
		{
			System.out.println("Erro ao tentar recuperar pessoas! " + e.getMessage());
		}
		
		return resultado;
	}
	
	
}
