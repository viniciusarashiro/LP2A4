package controlador.contacomum;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.ContaComum;
import modelo.repositorio.ContaComumRepositorio;
import modelo.repositorio.PersistenceConfig;

@WebServlet("/contacomum/excluir")
public class ExcluirContaComumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExcluirContaComumServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long contaComumNumero = 0;
		ContaComum contaComum = null;
		
		
		try {
			contaComumNumero = Long.parseLong(request.getParameter("numero").trim());
			
			ContaComumRepositorio repositorio = new ContaComumRepositorio();
			contaComum = repositorio.recuperarContaComumPorNumero(contaComumNumero);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		if(contaComum == null)
			contaComum = new ContaComum();
		
		request.setAttribute("contaComum", contaComum);
		
		request.setAttribute("tituloPagina", "Excluir Conta Comum");
		
		request.setAttribute("pathView", "/WEB-INF/views/contacomum/excluir.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");
		
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long numero = 0;
		
		try {
			numero = Long.parseLong(request.getParameter("numNumero"));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
			ContaComumRepositorio repositorio = new ContaComumRepositorio();
			
			request.getParameter("numNumero");
			
			ContaComum cc = repositorio.recuperarContaComumPorNumero(numero);
			
			repositorio.excluir(cc);
			
			PersistenceConfig.closeEntityManager();
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/contacomum");
		
		rd.forward(request, response);
	}

}
