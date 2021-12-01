package webapp.ControleBancarioWebAPI;

import java.util.Collection;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import modelo.ContaComum;
import modelo.PessoaFisica;
import modelo.repositorio.PessoaFisicaRepositorio;
import modelo.repositorio.Repositorio;

@Path("pessoafisica")
public class PessoaFisicaResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<PessoaFisica> getAll() {
		PessoaFisicaRepositorio  repositorio = new PessoaFisicaRepositorio();
		
		Collection<PessoaFisica> pessoasFisicas = repositorio.recuperarPessoasFisicas();
		
		return pessoasFisicas;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(PessoaFisica pf) {
		try {
			Repositorio<PessoaFisica> repositorio = new Repositorio<PessoaFisica>();
			
			repositorio.criar(pf);
			
			return Response.ok(pf, MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return Response.serverError().build();
		}
	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")  // URL/pessoafisica/{id}
	public Response update(@PathParam("id") int id, PessoaFisica pf) {
		try {
			PessoaFisicaRepositorio  repositorio = new PessoaFisicaRepositorio();
			PessoaFisica entidade = repositorio.recuperarPessoaFisicaPorId(id);
			
			entidade.setCep(pf.getCep());
			entidade.setCpf(pf.getCpf());
			entidade.setEmail(pf.getEmail());
			entidade.setEndereco(pf.getEndereco());
			entidade.setNascto(pf.getNascto());
			entidade.setNome(pf.getNome());
			entidade.setRenda(pf.getRenda());
			entidade.setSenha(pf.getSenha());
			entidade.setSituacao(pf.getSituacao());
			entidade.setTelefone(pf.getTelefone());
			
			entidade.getContas().clear();
			for(ContaComum conta : pf.getContas()) {
				entidade.getContas().add(conta);
			}
			
			if(repositorio.atualizar(entidade)) {
				return Response.ok(entidade, MediaType.APPLICATION_JSON).build();
			} else {
				return Response.notModified().build();
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return Response.serverError().build();
		}
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") int id) {
		PessoaFisicaRepositorio repositorio = new PessoaFisicaRepositorio();
		PessoaFisica pf = repositorio.recuperarPessoaFisicaPorId(id);
		
		if(pf != null) {
			return Response.ok(pf, MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") int id) {
		try {
			PessoaFisicaRepositorio repositorio = new PessoaFisicaRepositorio();
			PessoaFisica entidade = repositorio.recuperarPessoaFisicaPorId(id);
			
			
			if(repositorio.excluir(entidade)) {
				return Response.ok().build();
			} else {
				return Response.notModified().build();
			}
		} catch(Exception e) {
			System.out.print(e.getMessage());
			return Response.serverError().build();
		}
} 
		
	
	
}
