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
import modelo.repositorio.Repositorio;

@WebServlet("/pessoafisica/editar")
public class EditarPessoaFisicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditarPessoaFisicaServlet() {
       
    }
    
    // http://<server-ip-or-dns>/<context-path>/pessoafisica/editar?id=<valor>

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
		
		request.setAttribute("tituloPagina", "Editar Pessoa F�sica");
		
		request.setAttribute("pathView", "/WEB-INF/views/pessoafisica/editar.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");
		
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
			
			if(request.getParameter("txtEmail") != null && 
					!request.getParameter("txtEmail").trim().equals(""))  {
				pf.setEmail(request.getParameter("txtEmail").trim());
			}
			
			if(request.getParameter("pwdSenha") != null && 
					!request.getParameter("pwdSenha").trim().equals(""))  {
				pf.setSenha(request.getParameter("pwdSenha").trim());
			}
			
			
			repositorio.atualizar(pf);
			
			PersistenceConfig.closeEntityManager();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/pessoafisica");
		
		rd.forward(request, response);
	}

}
