package controlador.pessoajuridica;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.PessoaJuridica;
import modelo.repositorio.Repositorio;


@WebServlet("/pessoajuridica/cadastrar")
public class CadastrarPessoaJuridicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CadastrarPessoaJuridicaServlet() {
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/pessoajuridica/cadastrar.jsp");
		
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PessoaJuridica pj = new PessoaJuridica();
		
		if(request.getParameter("txtNome") != null && 
				!request.getParameter("txtNome").trim().equals(""))  {
			pj.setNome(request.getParameter("txtNome"));
		}
		
		if(request.getParameter("numCnpj") != null &&
				!request.getParameter("numCnpj").trim().equals("")) {
			pj.setCnpj(Long.parseLong(request.getParameter("numCnpj")));
		}
		
		if(request.getParameter("txtNomeFantasia") != null && 
				!request.getParameter("txtNomeFantasia").trim().equals(""))  {
			pj.setNomeFantasia(request.getParameter("txtNomeFantasia"));
		}
		
		if(request.getParameter("txtEndereco") != null && 
				!request.getParameter("txtEndereco").trim().equals(""))  {
			pj.setEndereco(request.getParameter("txtEndereco"));
		}
		
		if(request.getParameter("numCep") != null && 
				!request.getParameter("numCep").trim().equals(""))  {
			pj.setCep(Long.parseLong(request.getParameter("numCep")));
		}
		
		if(request.getParameter("txtTelefone") != null && 
				!request.getParameter("txtTelefone").trim().equals(""))  {
			pj.setTelefone(request.getParameter("txtTelefone"));
		}
		
		if(request.getParameter("numRenda") != null && 
				!request.getParameter("numRenda").trim().equals(""))  {
			pj.setRenda(Float.parseFloat(request.getParameter("numRenda").replace(',', '.')));
		}
		
		if(request.getParameter("selSituacao") != null && 
				!request.getParameter("selSituacao").trim().equals(""))  {
			pj.setSituacao(Byte.parseByte(request.getParameter("selSituacao")));
		}
		
		Repositorio<PessoaJuridica> repositorio = new Repositorio<PessoaJuridica>();
		
		repositorio.criar(pj);
		
		doGet(request, response);
	}

}
