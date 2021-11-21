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
	<div class="row">
		<div class="col-xl-12">
			<nav>
				<a class="btn btn-secondary" href="${pageContext.request.contextPath}/pessoafisica/cadastrar">Cadastrar nova pessoa f�sica</a>
			</nav>
		</div>
	</div>
	
	<div class="row">
		<div class="col-xl-12">
			<table class="table table-striped table-responsive">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Nome</th>
						<th scope="col">CPF</th>
						<th scope="col">Data de Nascimento</th>
						<th scope="col">Telefone</th>
						<th scope="col">E-mail</th>
						<th scope="col">Situa��o</th>
						<th scope="col">Op��es</th>
					</tr>
				</thead>
				<tbody>
					<%
						for(PessoaFisica pf : pessoasFisicas) {
							out.write("<tr>");
							
							out.write("<td  scope=\"row\">" + pf.getId() + "</td>");
							
							
							out.write("<td>" + (pf.getNome() != null ? pf.getNome() : "") + "</td>");
							out.write("<td>" + pf.getCpf() + "</td>");
							
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							
							out.write("<td>" + (pf.getNascto() != null ? dateFormat.format(pf.getNascto()) : "") + "</td>");
							
							//out.write("<td>" + (pf.getEndereco() != null ? pf.getEndereco() : "") + "</td>");
							
							out.write("<td>" + (pf.getTelefone() != null ? pf.getTelefone() : "") + "</td>");
							
							out.write("<td>" + pf.getEmail() + "</td>");
							
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
		</div>
	</div>
