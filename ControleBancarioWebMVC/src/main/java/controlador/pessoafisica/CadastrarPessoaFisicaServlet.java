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
import modelo.repositorio.Repositorio;

@WebServlet("/pessoafisica/cadastrar")
public class CadastrarPessoaFisicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CadastrarPessoaFisicaServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("tituloPagina", "Cadastrar nova Pessoa F�sica");
		
		request.setAttribute("pathView", "/WEB-INF/views/pessoafisica/cadastrar.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PessoaFisica pf = new PessoaFisica();
		
		if(request.getParameter("numCpf") != null && 
				!request.getParameter("numCpf").trim().equals(""))  {
			pf.setCpf(Long.parseLong(request.getParameter("numCpf")));
		}
		
		if(request.getParameter("txtNome") != null && 
				!request.getParameter("txtNome").trim().equals(""))  {
			pf.setNome(request.getParameter("txtNome"));
		}
		
		if(request.getParameter("datNascto") != null && 
				!request.getParameter("datNascto").trim().equals(""))  {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			Date nascto;
			
			try {
				nascto = dateFormat.parse(request.getParameter("datNascto"));
				pf.setNascto(nascto);
			} 
			catch(ParseException e) {
				e.printStackTrace();
			}
		}
		
		if(request.getParameter("txtEndereco") != null && 
				!request.getParameter("txtEndereco").trim().equals(""))  {
			pf.setEndereco(request.getParameter("txtEndereco"));
		}
		
		if(request.getParameter("numCep") != null && 
				!request.getParameter("numCep").trim().equals(""))  {
			pf.setCep(Long.parseLong(request.getParameter("numCep")));
		}
		
		if(request.getParameter("txtTelefone") != null && 
				!request.getParameter("txtTelefone").trim().equals(""))  {
			pf.setTelefone(request.getParameter("txtTelefone"));
		}
		
		if(request.getParameter("numRenda") != null && 
				!request.getParameter("numRenda").trim().equals(""))  {
			pf.setRenda(Float.parseFloat(request.getParameter("numRenda").replace(',', '.')));
		}
		
		if(request.getParameter("selSituacao") != null && 
				!request.getParameter("selSituacao").trim().equals(""))  {
			pf.setSituacao(Byte.parseByte(request.getParameter("selSituacao")));
		}
		
		
		Repositorio<PessoaFisica> repositorio = new Repositorio<PessoaFisica>();
		
		repositorio.criar(pf);
		
		doGet(request, response);
	}

}
