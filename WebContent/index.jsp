<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
<link rel="stylesheet" type="text/css" href="estilos.css">

</head>

<body>

	<div id="header">Cabeceira</div>
	<div id="contedor">
		<div id="menu">
			Men�
			<ul>
				<li><a href="index.jsp" id="actual">Inicio</a></li>
				<li><a href="identificacion.jsp">Identificarse</a></li>
				<li><a href="crearUsuario.jsp">Registrarse</a></li>
				<li><a href="http://www.google.com" target=_blank>Ir a
						Google</a></li>
				<li><a href="http://recursosformacion.com" target=_blank>Ir
						a Recursos Formaci�n</a></li>

			</ul>
		</div>
		<div id="corpo">
			Corpo
			<h1>Bienvenido visitante!</h1>
			<p>Isto � un par�grafo escrito co marcador de par�grafos e as� se
				visualizan cando escribo</p>
			<p>Este � un novo par�grafo</p>
			<br>
			<p style="text-align:center;">
				<b>--- No est� identificado o registrado ---</b>
			</p>
			<p><a href="identificacion.jsp">Identif�quese</a></p>
			<p>Si no est� registrado, h�galo <a href="crearUsuario.jsp">aqu�</a><p>

		</div>
	</div>
	<div id="pe">P�</div>

</body>
</html>