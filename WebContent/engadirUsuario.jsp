<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
			Menú
			<ul>
				<li><a href="homeUser.jsp">Inicio</a></li>
				<li><a href="ListarCategoria">Ver Categorías</a>
				<li><a href="ListarProductos">Ver Productos</a>
				<li><a href="ListarUsuarios">Ver Usuarios</a>
				<li><a href="Tenda">Ir a la tienda</a>
				<li><a href="MostrarMisDatos">Ver mis datos</a>
				<li><a href="Desconectarse"><b>Desconectarse</b></a></li>
				<li><a href="http://www.google.com" target=_blank>Ir a
						Google</a></li>
				<li><a href="http://recursosformacion.com" target=_blank>Ir
						a Recursos Formación</a></li>

			</ul>
		</div>
		<div id="corpo">
			<h1>Crear nuevo usuario:</h1>
			<p>Cumplimente los siguientes campos para añadir un nuevo usuario</p><br>
			
			<form action="EngadirUser" method=post>
				<label>Nome de usuario:</label></br> <input name="user_nombre" type="text" /></br>
				<label>E-mail:</label></br> <input name="user_email" type="text" /></br>
				<label>Contraseña:</label></br> <input name="user_pass" type="password" /></br>
				<label>Repetir contraseña:</label></br> <input name="user_pass2" type="password" /></br>
				<input type="submit" value="Enviar" />
			</form><br>
			
		</div>
	</div>
	<div id="pe">Pé</div>

</body>
</html>