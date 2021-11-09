<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="modelo.PessoaFisica" %> 
 <%
 
 PessoaFisica pessoaFisica = (PessoaFisica) request.getAttribute("pessoaFisica");
 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Excluir Pessoa Física</title>
</head>
<body>
	<h1>Excluir Pessoa Física</h1>
	
	<nav>
		<a href="${pageContext.request.contextPath}/pessoafisica/listar">Voltar para a listagem de pessoas físicas</a>
	</nav>
	
	<p>Tem certeza que deseja excluir o cadastro de <%=pessoaFisica.getNome() %>?</p>
	
	<form method="POST" action="${pageContext.request.contextPath}/pessoafisica/excluir">
		<input type="hidden" name="numId" value="<%=pessoaFisica.getId()%>">
		
		<p>
			<input type="submit" value="Sim">
		</p>
	</form>
</body>
</html>