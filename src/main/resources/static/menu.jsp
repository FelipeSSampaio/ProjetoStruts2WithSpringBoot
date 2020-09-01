<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Página de opções</title>
</head>
<body style="background-color:ghostWhite">

	<div class="container">
		
		<div class="list-group pt-3" style="width:20em;">
			<ul>
				<li class="list-group-item list-group-item-action active">Opções</li>
				<li class="list-group-item list-group-item-action"><a href="/cadastraExame.action">Cadastrar Exame</a></li>
				<li class="list-group-item list-group-item-action"><a href="/pesquisaExame.action">Pesquisar Exame (Serviço SOAP)</a></li>
				<li class="list-group-item list-group-item-action"><a href="/listaTodosExames.action">Listar todos os Exames</a></li>
			</ul>
		</div>
	</div>
	

</body>
</html>