<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="temp" tagdir="/WEB-INF/tags" %>

<temp:plantillas title="Inicio" type="0" pos="index">
	<jsp:attribute name="content">
			<h1>Bienvenido visitante!</h1>
			<p>Isto � un par�grafo escrito co marcador de par�grafos e as� se
				visualizan cando escribo</p>
			<p>Este � un novo par�grafo</p>
			<br>
			<p style="text-align:center;">
				<b>--- No est� identificado o registrado ---</b>
			</p>
			<p><a href="identificacion.jsp">Identif�quese</a></p>
			<p>Si no est� registrado, h�galo <a href="crearUsuario.jsp">aqu�</a></p>
	</jsp:attribute>
</temp:plantillas>