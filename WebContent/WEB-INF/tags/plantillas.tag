<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="type" required="true" rtexprvalue="true"%>
<%@ attribute name="pos" required="true" rtexprvalue="true"%>
<%@ attribute name="content" fragment="true"%>
<%@ taglib prefix="tag" uri="../etiquetas/tags.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title }</title>
<link rel="stylesheet" type="text/css" href="estilos.css">

</head>

<body>
	<%@ include file='/cabeceira.html'%>
	<div id="contedor">
		<tag:menu type="${type }" pos="${pos }"/>
		<div id="corpo">
			<jsp:invoke fragment="content"></jsp:invoke>
		</div>
	</div>
	<%@ include file='/pe.html'%>
</body>
</html>