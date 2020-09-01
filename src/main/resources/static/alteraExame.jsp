<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Página de alteração de exames</title>
</head>
<body style="background-color:ghostWhite">

	<div class="container pt-3">
		
		<div class="card" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Alteração de Exame</h5>
		    <p class="card-text">
		    	</p><form action="alteraExameForm.action" method="get">
					<input readonly="readonly" type="text" class="form-control form-control-sm mb-3" name="id" id="id" placeholder="ID" autocomplete="off" value='<s:property value="id"/>'>
					<input type="text" class="form-control form-control-sm mb-3" name="nome" id="nomePaciente" placeholder="Nome do Paciente" autocomplete="off" value='<s:property value="nome"/>'>
					<input type="text" class="form-control form-control-sm" name="status" id="status" placeholder="Status Exame" autocomplete="off" value='<s:property value="status"/>'>
					<hr>
					<button type="submit" class="btn btn-danger mb-2 float-right">Alterar</button>	
				</form>
		  </div>
		  <div class="card-footer">
		  	<a href="menu.action" class="card-link">Voltar para opções</a>
		  </div>
		</div>
	
	</div>
	

</body>
</html>