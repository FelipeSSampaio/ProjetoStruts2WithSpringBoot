<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Página de lista de exames</title>
</head>
<body style="background-color:ghostWhite">

	<div class="container pt-3">

		<div class="card" style="width: 40rem;">
			<div class="card-body">
				<h5 class="card-title">Lista de Exames</h5>
		    	<p class="card-text pt-3">
					<table class="table table-hover table-sm">
						<thead>
							<tr class="bg-primary text-white">
								<td>ID</td>
								<td>Nome</td>
								<td>Status</td>
								<td></td>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listaExame">
								<tr>
									<td><s:property value="id"/></td>
									<td><s:property value="nome"/></td>
									<td><s:property value="status"/></td>
									<td>
										<a href="listaResultadoExame.action?id=<s:property value="id"/>" title="dados">
		          							<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-pencil-square" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
											  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"></path>
											  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"></path>
											</svg>
		        						</a>
		        					</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					</p>
				</div>	
			
			<div class="card-footer">
				<a href="menu.action" class="card-link">Voltar para opções</a>
			</div>
		</div>
		
	</div>
	

</body>
</html>