<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Página de cadastro de exames</title>
</head>
<body style="background-color:ghostWhite">

	<div class="container pt-3">
		
		<div class="card" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Cadastro de Exame</h5>
		    <p class="card-text">
		    	</p><form action="cadastraExameForm.action" method="get">
					<input type="text" class="form-control form-control-sm mb-3" name="nome" id="nomePaciente" placeholder="Nome do Paciente" autocomplete="off">
					<input type="text" class="form-control form-control-sm" name="status" id="status" placeholder="Status Exame" autocomplete="off">
					<hr>
					<button type="submit" class="btn btn-primary mb-2 float-right">Cadastrar</button>	
				</form>
		  </div>
		  <div class="card-footer">
		  	<a href="menu.action" class="card-link">Voltar para opções</a>
		  </div>
		</div>
	
	</div>
	

</body>
</html>