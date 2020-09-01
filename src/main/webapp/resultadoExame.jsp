<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Exame do Paciente <s:property value="nome" /></title>

<script>
function goBack() {
  window.history.back();
}
</script>

</head>
<body style="background-color:ghostWhite">

	<div class="container pt-3">
		
		<div class="card" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Dados</h5>
		    <hr>
		    <p class="card-text">
		    	ID: <s:property value="id" /><br>
		    	Nome paciente: <s:property value="nome"/><br>
		    	Status do Exame: <s:property value="status"/>
		    </p>
		    	<a href="alteraExame.action?id=<s:property value="id" />&nome=<s:property value="nome" />&status=<s:property value="status" />" class="btn btn-primary mb-2 float-right">Alterar</a>
		   		<a href="exclueExame.action?id=<s:property value="id" />&nome=<s:property value="nome" />&status=<s:property value="status" />" class="btn btn-danger mb-2 float-right mr-3">Excluir</a>
		    
		  </div>
		  <div class="card-footer">
		  	<a href="menu.action" class="card-link">Voltar para opções</a><br>
		  	<a href="listaTodosExames.action" class="card-link">Ir para lista de exames</a>
		  </div>
		</div>
		
	</div>

</body>
</html>