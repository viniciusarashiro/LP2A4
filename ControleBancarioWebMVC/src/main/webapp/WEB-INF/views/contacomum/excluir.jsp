<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="modelo.ContaComum" %> 
 <%
 
 ContaComum contaComum = (ContaComum) request.getAttribute("contaComum");
 
 %>
<p>Tem certeza que deseja excluir o cadastro de <%=contaComum.getNumero() %>?</p>
	
	<form method="POST" action="${pageContext.request.contextPath}/contacomum/excluir">
		<input type="hidden" name="numNumero" value="<%=contaComum.getNumero()%>">
		
		<p>
			<input type="submit" value="Sim">
		</p>
	</form>