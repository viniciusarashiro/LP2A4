package controlador;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.PessoaFisica;


@WebServlet({ "/index", "/home" })
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public IndexServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		

		if(session.getAttribute("usuarioAutenticado") != null &&
				"OK".equals(session.getAttribute("usuarioAutenticado"))) {
			PessoaFisica p = (PessoaFisica) session.getAttribute("usuario");
			request.setAttribute("tituloPagina", "Sistema de Controle Bancario Web - Pagina "
					+ "Inicial<br>" + "Bem-vindo " + p.getNome() + "!");
		} else {
			request.setAttribute("tituloPagina", "Sistema de Controle Bancário Web - Página inicial");
		}	
		
		
		request.setAttribute("pathView", "/WEB-INF/index.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");
		rd.forward(request, response);
	}

}
