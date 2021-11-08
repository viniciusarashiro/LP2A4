<%@ page import="modelo.PessoaJuridica"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	Collection<PessoaJuridica> pessoasJuridicas = new ArrayList<PessoaJuridica>();

	if(request.getAttribute("pessoasJuridicas") != null) 
		pessoasJuridicas = (Collection<PessoaJuridica>) request.getAttribute("pessoasJuridicas");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pessoas Jurídicas Cadastradas</title>
</head>
<body>
	<h1>Pessoas Jurídicas Cadastradas</h1>
	
	<nav>
		<a href="${pageContext.request.contextPath}/pessoajuridica/cadastrar">Cadastrar nova pessoa jurídica</a>
	</nav>
	
	<table>
		<thead>
			<th>ID</th>
			<th>Nome</th>
			<th>CNPJ</th>
			<th>Nome fantasia</th>
			<th>Telefone</th>
			<th>Situação</th>
		</thead>
		<tbody>
			<%
				for(PessoaJuridica pj : pessoasJuridicas) {
					out.write("<tr>");
					
					out.write("<td>" + pj.getId() + "</td>");
					out.write("<td>" + pj.getNome() + "</td>");
					out.write("<td>" + pj.getCnpj() + "</td>");
					out.write("<td>" + pj.getNomeFantasia() + "</td>");
					out.write("<td>" + pj.getTelefone() + "</td>");
					
					out.write("<td>" + (pj.getSituacao() == 1 ? "Ativo" : "Inativo") + "</td>");
					
					
					out.write("</tr>");
				}
			%>
		</tbody>
	</table>
</body>
</html>