package controlador.pessoafisica;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.PessoaFisica;
import modelo.repositorio.PersistenceConfig;
import modelo.repositorio.PessoaFisicaRepositorio;


@WebServlet({ "/pessoafisica/listar", "/pessoafisica" })
public class ListarPessoaFisicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarPessoaFisicaServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		

		if(session.getAttribute("usuarioAutenticado") != null &&
				"OK".equals(session.getAttribute("usuarioAutenticado"))) {
			PessoaFisicaRepositorio repositorio = new PessoaFisicaRepositorio();
			
			Collection<PessoaFisica> pessoasFisicas = repositorio.recuperarPessoasFisicas();
			
			PersistenceConfig.closeEntityManager();
			
			request.setAttribute("pessoasFisicas", pessoasFisicas);
			
			request.setAttribute("tituloPagina", "Pessoas F?sicas Cadastradas");
			
			request.setAttribute("pathView", "/WEB-INF/views/pessoafisica/listar.jsp");
		} else {
			request.setAttribute("tituloPagina", "Acesso negado");
			request.setAttribute("pathView", "/WEB-INF/unauthorized.jsp");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");
		
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
