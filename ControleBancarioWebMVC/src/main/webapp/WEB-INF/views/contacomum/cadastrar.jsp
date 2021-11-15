<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Collection" %>
<%@ page import="modelo.PessoaFisica" %>

<%
	Collection<PessoaFisica> pessoasFisicasAtivas = 
	(Collection<PessoaFisica>) request.getAttribute("pessoasFisicasAtivas");
%>

	<form method="POST" action="${pageContext.request.contextPath}/contacomum/cadastrar">
		<p>
			<label for="selTitulares">Titulares: </label>
			<select name="selTitulares" multiple required>
				<%
					for(PessoaFisica pf : pessoasFisicasAtivas) {
						out.print("<option value=\"");
						
						out.print(pf.getId());
						
						out.print("\">");
						
						out.print(pf.getNome());
						
						out.print("</option>");
					}
				%>
			</select>
		</p>
			
		<p>
			<label for="pwdSenha">Senha:</label>
			<input type="password" name="pwdSenha" required>
		</p>
		
		<p>
			<label for="numSaldo">Saldo inicial(R$):</label>
			<input type="number" name="numSaldo" step=".01">
		</p>
		
		<p>
			<label for="selSituacao">Situação:</label>
				<select name="selSituacao" required>
					<option value="" selected>- Selecione -</option>
					<option value="0">Inativo</option>
					<option value="1">Ativo</option>
				</select>
		</p>
		
		<p>
			<input type="submit" value="Enviar">
		</p>
	</form>