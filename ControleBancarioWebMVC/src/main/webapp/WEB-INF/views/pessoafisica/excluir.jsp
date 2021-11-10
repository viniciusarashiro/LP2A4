<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="modelo.PessoaFisica" %> 
 <%
 
 PessoaFisica pessoaFisica = (PessoaFisica) request.getAttribute("pessoaFisica");
 
 %>
	<p>Tem certeza que deseja excluir o cadastro de <%=pessoaFisica.getNome() %>?</p>
	
	<form method="POST" action="${pageContext.request.contextPath}/pessoafisica/excluir">
		<input type="hidden" name="numId" value="<%=pessoaFisica.getId()%>">
		
		<p>
			<input type="submit" value="Sim">
		</p>
	</form>