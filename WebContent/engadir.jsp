<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear unha nova Categor�a</title>
<link rel="stylesheet" type="text/css" href="estilos.css">

</head>

<body>

	<div id="header">Cabeceira</div>
	<div id="contedor">
		<div id="menu">
			Men�
			<ul>
			<li><a href="engadir.jsp" id="actual">Crear nueva categor�a</a></li>
						<li><a href="ListarCategoria">Mostrar todas las categor�as</a></li>
				<li><a href="http://www.google.com" target=_blank>Ir a
						Google</a></li>
				<li><a href="http://recursosformacion.com" target=_blank>Ir
						a Recursos Formaci�n</a></li>

			</ul>
		</div>
		<div id="corpo">
			<h1>Crear nueva categor�a:</h1>
			<p>Cumplimente los siguientes campos para a�adir una nueva categor�a</p><br>
			
			<form action="engadir" method=post>
				<label>Nome de categor�a:</label></br> 
				<input name="cat_nombre" type="text"/></br> </br>
				<label>Descripci�n de categor�a:</label></br>
				<input name="cat_descripcion" type="text" /></br> 
				<input type="submit" value="Enviar" />
			</form><br>
			
		</div>
	</div>
	<div id="pe">P�</div>

</body>
</html>