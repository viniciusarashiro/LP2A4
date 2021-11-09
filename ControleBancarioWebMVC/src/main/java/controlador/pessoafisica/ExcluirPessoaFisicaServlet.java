package controlador.pessoafisica;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.PessoaFisica;
import modelo.repositorio.PersistenceConfig;
import modelo.repositorio.PessoaFisicaRepositorio;

@WebServlet("/pessoafisica/excluir")
public class ExcluirPessoaFisicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ExcluirPessoaFisicaServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pessoaFisicaId = 0;
		PessoaFisica pessoaFisica = null;
		
		
		try {
			pessoaFisicaId = Integer.parseInt(request.getParameter("id").trim());
			
			PessoaFisicaRepositorio repositorio = new PessoaFisicaRepositorio();
			pessoaFisica = repositorio.recuperarPessoaFisicaPorId(pessoaFisicaId);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		if(pessoaFisica == null)
			pessoaFisica = new PessoaFisica();
		
		request.setAttribute("pessoaFisica", pessoaFisica);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/pessoafisica/excluir.jsp");
		
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = 0;
		
		try {
			id = Integer.parseInt(request.getParameter("numId"));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		if(id > 0) {
			PessoaFisicaRepositorio repositorio = new PessoaFisicaRepositorio();
			
			request.getParameter("numId");
			
			PessoaFisica pf = repositorio.recuperarPessoaFisicaPorId(id);
			
			repositorio.excluir(pf);
			
			PersistenceConfig.closeEntityManager();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/pessoafisica");
		
		rd.forward(request, response);
	}

}
