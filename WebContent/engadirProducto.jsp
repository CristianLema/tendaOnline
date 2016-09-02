<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List,com.sopra.tienda.dominio.Categoria" %>

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
				<li><a href="homeUser.jsp" id="actual">Inicio</a></li>
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
			<h1>Crear nuevo producto:</h1>
			<p>Cumplimente los siguientes campos para añadir un nuevo producto</p><br>
			
			<form action="EngadirProducto" method=post>
				<label>ID:</label></br> <input name="id_producto" type="text" /></br>
				<label>Descripción:</label></br> <input name="pro_descripcion" type="text" /></br>
				<label>Descripción larga:</label></br> <input name="pro_desLarga" type="text" style="height:50px;" /></br>
				<label>Precio:</label></br> <input name="pro_precio" type="text" /></br>
				<label>Unidad de venta:</label></br> <input name="pro_uniVenta" type="text" /></br>
				<label>Cantidad por unidad de venta:</label></br> <input name="pro_cantXUniVenta" type="text" /></br>
				<label>Unidad último nivel:</label></br> <input name="pro_uniUltNivel" type="text" /></br>
				<label>País:</label></br> <input name="id_pais" type="text" /></br>
				<label>Uso Recomendado:</label></br> <input name="pro_usoRecomendado" type="text" /></br>
				<label>Categoría:</label></br> <select name="id_categoria">
				<% List<Categoria> cat = (List<Categoria>) request.getAttribute("cat");
				for (int i=0; i<cat.size(); i++){
					int id = cat.get(i).getId_categoria();
					String nome = cat.get(i).getCat_nombre(); %>
					<option value="${id }" > "${nome }" </option>
				<% } %>
				</select></br>
				<label>Stock reservado:</label></br> <input name="pro_stkReservado" type="text" /></br>
				<label>Nivel stock alto:</label></br> <input name="pro_nStkAlto" type="text" /></br>
				<label>Nivel stock bajo:</label></br> <input name="pro_nStkBajo" type="text" /></br>
				<label>Stock:</label></br> <input name="pro_stock" type="text" /></br>
				<label>Fecha Reposición:</label></br> <input name="pro_fecRepos" type="text" /></br>
				<label>Fecha Activación:</label></br> <input name="pro_fecActi" type="text" /></br>
				<label>Fecha Desactivación:</label></br> <input name="pro_fecDesacti" type="text" /></br>
				<label>Estado:</label></br> <input name="pro_stat" type="text" /></br>
				<input type="submit" value="Enviar" />
			</form><br>
			
		</div>
	</div>
	<div id="pe">Pé</div>

</body>
</html>