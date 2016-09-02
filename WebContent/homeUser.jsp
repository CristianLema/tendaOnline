<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio Usuario</title>
<link rel="stylesheet" type="text/css" href="estilos.css">

</head>

<body>

	<div id="header">Cabeceira</div>
	<div id="contedor">
		<div id="menu">
			Menú
			<ul>
				<li><a href="homeUser.jsp" id="actual">Inicio</a></li>
				<li><a href="Tenda">Ir a la tienda</a>
				<li><a href="Carrito">Ir a mi carrito</a>
				<li><a href="MostrarMisDatos">Ver mis datos</a>
				<li><a href="Desconectarse"><b>Desconectarse</b></a></li>
				<li><a href="http://www.google.com" target=_blank>Ir a
						Google</a></li>
				<li><a href="http://recursosformacion.com" target=_blank>Ir
						a Recursos Formación</a></li>

			</ul>
		</div>
		<div id="corpo">
			<h1>Bienvenido Usuario!</h1>
			<p>Isto é un parágrafo escrito co marcador de parágrafos e así se
				visualizan cando escribo</p>
			<p>Este é un novo parágrafo</p>
			<br>
			<p>
				<b>Haga click en uno de los enlaces del menú de la izquierda</b>
			</p>

		</div>
	</div>
	<div id="pe">Pé</div>

</body>
</html>