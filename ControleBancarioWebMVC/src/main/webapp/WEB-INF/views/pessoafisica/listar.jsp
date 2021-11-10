<%@ page import="modelo.PessoaFisica"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%

Collection<PessoaFisica> pessoasFisicas = new ArrayList<PessoaFisica>();

if(request.getAttribute("pessoasFisicas") != null) 
	pessoasFisicas = (Collection<PessoaFisica>) request.getAttribute("pessoasFisicas");

%>   

	<nav>
		<a href="${pageContext.request.contextPath}/pessoafisica/cadastrar">Cadastrar nova pessoa física</a>
	</nav>
	
	<table>
		<thead>
			<th>ID</th>
			<th>Nome</th>
			<th>CPF</th>
			<th>Data de Nascimento</th>
			<th>Telefone</th>
			<th>Situação</th>
			<th></th>
		</thead>
		<tbody>
			<%
				for(PessoaFisica pf : pessoasFisicas) {
					out.write("<tr>");
					
					out.write("<td>" + pf.getId() + "</td>");
					out.write("<td>" + pf.getNome() + "</td>");
					out.write("<td>" + pf.getCpf() + "</td>");
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					
					out.write("<td>" + dateFormat.format(pf.getNascto()) + "</td>");
					
					out.write("<td>" + pf.getTelefone() + "</td>");
					
					out.write("<td>" + 
							(pf.getSituacao() == 1 ? "Ativo" : "Inativo")
							+ "</td>");
					
					out.write("<td>");
					
					out.write("<a href=\"" + request.getContextPath() + "/pessoafisica/editar?id=" + pf.getId() + "\">Editar </a>");
					
					out.write("<a href=\"" + request.getContextPath() + "/pessoafisica/excluir?id=" + pf.getId() + "\">Excluir</a>");
					
					out.write("</td>");
					
					out.write("</tr>");
					
				}
				
			%>
		</tbody>
	</table>
