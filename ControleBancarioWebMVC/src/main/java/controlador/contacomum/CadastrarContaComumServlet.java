package controlador.contacomum;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.ContaComum;
import modelo.PessoaFisica;
import modelo.repositorio.PersistenceConfig;
import modelo.repositorio.PessoaFisicaRepositorio;
import modelo.repositorio.Repositorio;

@WebServlet({ "/contacomum/cadastrar" })
public class CadastrarContaComumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CadastrarContaComumServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PessoaFisicaRepositorio repositorio = new PessoaFisicaRepositorio();
		
		Collection<PessoaFisica> pessoasFisicasAtivas = repositorio.recuperarPessoasFisicasPorStatus((byte)1);
		
		if(pessoasFisicasAtivas == null) {
			pessoasFisicasAtivas = new ArrayList<PessoaFisica>();
		}
		
		request.setAttribute("pessoasFisicasAtivas", pessoasFisicasAtivas);
		
		request.setAttribute("tituloPagina", 
				"Cadastrar Nova Conta Comum Vinculada a Pessoas Físicas");
		
		request.setAttribute("pathView", "/WEB-INF/views/contacomum/cadastrar.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");
		
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PessoaFisicaRepositorio repositorioPessoaFisica = new PessoaFisicaRepositorio();
		
		String[] idsTitularesSelecionados = 
				request.getParameterValues("selTitulares");
		
		Collection<PessoaFisica> titulares = new ArrayList<PessoaFisica>();
		
		if(idsTitularesSelecionados != null) {
			for(String idTitular : idsTitularesSelecionados) {
				int id = 0;
				
				try {
					id = Integer.parseInt(idTitular);
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				
				PessoaFisica pf = repositorioPessoaFisica.recuperarPessoaFisicaPorId(id);
				
				if(pf != null) {
					titulares.add(pf);
				}
			}
		}
		
		ContaComum contaComum = new ContaComum();
		
		if(request.getParameter("selSituacao") != null && 
				!request.getParameter("selSituacao").trim().equals(""))  {
			contaComum.setSituacao(Byte.parseByte(request.getParameter("selSituacao")));
			
			if(contaComum.getSituacao() == 0) {
				contaComum.setFechamento(new Date());
			} else {
				contaComum.setFechamento(null);
			}
		}
		
		
		if(request.getParameter("pwdSenha") != null && 
				!request.getParameter("pwdSenha").trim().equals(""))  {
			
			try {
				contaComum.setSenha(Integer.parseInt(request.getParameter("pwdSenha")));
			} 
			catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		
		if(request.getParameter("numSaldo") != null && 
				!request.getParameter("numSaldo").trim().equals(""))  {
			contaComum.setSaldo(Float.parseFloat(request.getParameter("numSaldo").replace(',', '.')));
		}
		
		
		
		Repositorio<ContaComum> repositorioContaComum = new Repositorio<ContaComum>();
		
		repositorioContaComum.criar(contaComum);
		
		for(PessoaFisica pessoaFisica : titulares) {
			pessoaFisica.getContas().add(contaComum);
			
			repositorioPessoaFisica.atualizar(pessoaFisica);
		}
		
		PersistenceConfig.closeEntityManager();
		
		RequestDispatcher rd = request.getRequestDispatcher("/contacomum");
		
		rd.forward(request, response);
	}

}
