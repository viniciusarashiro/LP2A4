package controlador.pessoajuridica;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.PessoaJuridica;
import modelo.repositorio.PessoaJuridicaRepositorio;

@WebServlet({ "/pessoajuridica", "/pessoajuridica/listar" })
public class ListarPessoaJuridicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarPessoaJuridicaServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PessoaJuridicaRepositorio repositorio = new PessoaJuridicaRepositorio();
		
		Collection<PessoaJuridica> pessoasJuridicas = repositorio.recuperarPessoasJuridicas();
		
		request.setAttribute("pessoasJuridicas", pessoasJuridicas);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/pessoajuridica/listar.jsp");
		
		rd.forward(request, response);
		
	}

}
