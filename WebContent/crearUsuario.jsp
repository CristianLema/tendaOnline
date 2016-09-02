<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear un novo Usuario</title>
<link rel="stylesheet" type="text/css" href="estilos.css">

</head>

<body>

	<div id="header">Cabeceira</div>
	<div id="contedor">
		<div id="menu">
			Men�
			<ul>
				<li><a href="ListarCategoria">Mostrar todas las categor�as</a></li>
				<li><a href="crearUsuario.jsp" id="actual">Crear nuevo
						usuario</a>
				<li><a href="http://www.google.com" target=_blank>Ir a
						Google</a></li>
				<li><a href="http://recursosformacion.com" target=_blank>Ir
						a Recursos Formaci�n</a></li>

			</ul>
		</div>
		<div id="corpo">
			<h1>Crear nuevo usuario:</h1>
			<p>Introduzca los siguientes datos para crear un nuevo usuario</p>
			<br>

			<form action="EngadirUser" method=post>
				<label>Nome de usuario:</label></br> <input name="user_nombre" type="text" /></br>
				<label>E-mail:</label></br> <input name="user_email" type="text" /></br>
				<label>Contrase�a:</label></br> <input name="user_pass" type="password" /></br>
				<label>Repetir contrase�a:</label></br> <input name="user_pass2" type="password" /></br>
				<input type="submit" value="Enviar" />
			</form>
			<br>
			<p>Si ya est� registrado, identif�quese <a href="identificacion.jsp">aqu�</a><p>
		</div>
	</div>
	<div id="pe">P�</div>

</body>
</html>