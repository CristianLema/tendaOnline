package com.sopra.tienda.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MenuTag extends TagSupport{
	private int type;
	private String pos;
	
	public int doStartTag(){
		String index = "";
		String identificacion = "";
		String crearUsuario = "";
		String tenda = "";
		String carrito = "";
		String mostrarDatos = "";
		String listarCateg = "";
		String listarProd = "";
		String listarUser = "";
		JspWriter out = pageContext.getOut();
		
		switch(pos){
		case "homeUser":
		case "homeAdmin":
		case "index":
			index = " id=\"actual\"";
			break;
		case "identificacion":
			identificacion = " id=\"actual\"";
			break;
		case "crearUsuario":
			crearUsuario = " id=\"actual\"";
			break;
		case "Tenda":
			tenda = " id=\"actual\"";
			break;
		case "Carrito":
			carrito = " id=\"actual\"";
			break;
		case "MostrarMisDatos":
			mostrarDatos = " id=\"actual\"";
			break;
		case "ListarCategoria":
			listarCateg = " id=\"actual\"";
			break;
		case "ListarProductos":
			listarProd = " id=\"actual\"";
			break;
		case "ListarUsuarios":
			listarUser = " id=\"actual\"";
			break;
		}
		
		try {
			out.println("<div id=\"menu\">");
			out.println("Menú");
			out.println("<ul>");
			if(type==0){
				out.println("<li><a href=\"index.jsp\"" + index + ">Inicio</a></li>");
				out.println("<li><a href=\"identificacion.jsp\"" + identificacion + ">Identificarse</a></li>");
				out.println("<li><a href=\"crearUsuario.jsp\"" + crearUsuario + ">Registrarse</a></li>");
			}else if(type==1){
				out.println("<li><a href=\"homeUser.jsp\"" + index + ">Inicio</a></li>");
				out.println("<li><a href=\"Tenda\"" + tenda + ">Ir a la tienda</a></li>");
				out.println("<li><a href=\"Carrito\"" + carrito + ">Ver mi carrito</a></li>");
				out.println("<li><a href=\"MostrarMisDatos\"" + mostrarDatos + ">Ver mis datos</a></li>");
				out.println("<li><a href=\"Desconectarse\">Desconectarse</a></li>");
			}else if(type==9){
				out.println("<li><a href=\"homeAdmin.jsp\"" + index + ">Inicio</a></li>");
				out.println("<li><a href=\"Tenda\"" + tenda + ">Ir a la tienda</a></li>");
				out.println("<li><a href=\"ListarCategoria\"" + listarCateg + ">Ver Categorías</a></li>");
				out.println("<li><a href=\"ListarProductos\"" + listarProd + ">Ver Productos</a></li>");
				out.println("<li><a href=\"ListarUsuarios\"" + listarUser + ">Ver Usuarios</a></li>");
				out.println("<li><a href=\"MostrarMisDatos\"" + mostrarDatos + ">Ver mis datos</a></li>");
				out.println("<li><a href=\"Desconectarse\">Desconectarse</a></li>");
			}else{
				out.println("<li>Tipo de usuario erróneo</li>");
			}
			out.println("</ul>");
			out.println("</div>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	
	
}
