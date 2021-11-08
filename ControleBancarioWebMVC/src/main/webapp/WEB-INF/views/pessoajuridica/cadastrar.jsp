<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Nova Pessoa Jurídica</title>
</head>
<body>
	<h1>Cadastrar Nova Pessoa Jurídica</h1>
	
	<nav>
		<a href="${pageContext.request.contextPath}/pessoajuridica/listar">Voltar para a listagem de pessoas jurídicas</a>
	</nav>
	
	<form method="POST" action="${pageContext.request.contextPath}/pessoajuridica/cadastrar">
		
		
		<p>
			<label for="txtNome">Nome:</label>
			<input type="text" name="txtNome">
		</p>
		
		<p>
			<label for="numCnpj">CNPJ:</label>
			<input type="num" name="numCnpj">
		</p>
		
		
		<p>
			<label for="txtNomeFantasia">Nome Fantasia:</label>
			<input type="text" name="txtNomeFantasia">
		</p>
		
		<p>
			<label for="txtEndereco">Endereço:</label>
			<input type="text" name="txtEndereco">
		</p>
		
		<p>
			<label for="numCep">CEP:</label>
			<input type="num" name="numCep">
		</p>
	
		<p>
			<label for="txtTelefone">Telefone:</label>
			<input type="text" name="txtTelefone">
		</p>
		
		<p>
			<label for="numRenda">Renda (R$):</label>
			<input type="number" name="numRenda" step=".01">
		</p>
		
		
		<p>
			<label for="selSituacao">Situação:</label>
				<select name="selSituacao">
					<option value="">- Selecione -</option>
					<option value="0">Inativo</option>
					<option value="1">Ativo</option>
				</select>
		</p>
		
		<p>
			<input type="submit" value="Enviar">
		</p>
	</form>
</body>
</html>