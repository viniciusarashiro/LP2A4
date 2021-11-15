package controlador.contacomum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.ContaComum;
import modelo.repositorio.ContaComumRepositorio;
import modelo.repositorio.PersistenceConfig;


@WebServlet({ "/contacomum/listar", "/contacomum" })
public class ListarContaComumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarContaComumServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContaComumRepositorio repositorio = new ContaComumRepositorio();
		
		Collection<ContaComum> contasComuns = repositorio.recuperarContasComuns();
		
		if(contasComuns == null) {
			contasComuns = new ArrayList<ContaComum>();
		}
		
		request.setAttribute("contasComuns", contasComuns);
		
		request.setAttribute("tituloPagina", "Contas Comuns Cadastradas");
		
		request.setAttribute("pathView", "/WEB-INF/views/contacomum/listar.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");
		
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
