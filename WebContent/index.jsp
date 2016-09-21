<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="temp" tagdir="/WEB-INF/tags" %>

<temp:plantillas title="Inicio" type="0" pos="index">
	<jsp:attribute name="content">
			<h1>Bienvenido visitante!</h1>
			<p>Isto é un parágrafo escrito co marcador de parágrafos e así se
				visualizan cando escribo</p>
			<p>Este é un novo parágrafo</p>
			<br>
			<p style="text-align:center;">
				<b>--- No está identificado o registrado ---</b>
			</p>
			<p><a href="identificacion.jsp">Identifíquese</a></p>
			<p>Si no está registrado, hágalo <a href="crearUsuario.jsp">aquí</a></p>
	</jsp:attribute>
</temp:plantillas>