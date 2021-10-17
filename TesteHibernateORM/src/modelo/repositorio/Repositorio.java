package modelo.repositorio;

import javax.persistence.EntityTransaction;

public class Repositorio<T>
{
	public boolean criar(T entidade) 
	{
		boolean resultado = true;
		EntityTransaction transacao = 
				PersistenceConfig.getEntityManager().getTransaction();
		
		try
		{
			transacao.begin();
			
			PersistenceConfig.entityManager.persist(entidade);
			
			transacao.commit();
		}
		catch(Exception e)
		{
			System.out.println("Erro ao tentar persistir uma nova entidade! " + e.getMessage());
			transacao.rollback();
			resultado = false;
		}
		
		return resultado;
	}
	
	public boolean excluir(T entidade)
	{
		boolean resultado = true;
		EntityTransaction transacao = 
				PersistenceConfig.getEntityManager().getTransaction();
		
		try
		{
			transacao.begin();
			
			PersistenceConfig.entityManager.remove(entidade);
			
			transacao.commit();
		}
		catch(Exception e)
		{
			System.out.println("Erro ao tentar excluir a entidade! " + e.getMessage());
			transacao.rollback();
			resultado = false;
		}
		
		return resultado;
	}
	
	public boolean atualizar(T entidade)
	{
		boolean resultado = true;
		EntityTransaction transacao = 
				PersistenceConfig.getEntityManager().getTransaction();
		
		try
		{
			transacao.begin();
			
			PersistenceConfig.entityManager.merge(entidade);
			
			transacao.commit();
		}
		catch(Exception e)
		{
			System.out.println("Erro ao tentar atualizar a entidade! " + e.getMessage());
			transacao.rollback();
			resultado = false;
		}
		
		return resultado;
	}
}
