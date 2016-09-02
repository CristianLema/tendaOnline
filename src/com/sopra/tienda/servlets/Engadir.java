package com.sopra.tienda.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.tienda.dominio.Categoria;
import com.sopra.tienda.exception.DAOException;
import com.sopra.tienda.exception.DomainException;
import com.sopra.tienda.objetos.daos.CategoriaDAOH;

/**
 * Servlet implementation class Inicio
 */
@WebServlet("/engadir") // esta é a dirección á que está a atender este servlet
public class Engadir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CategoriaDAOH cDAOH;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Engadir() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//obtener las nuevas variables
		String cat_nombre = request.getParameter("cat_nombre");
		String cat_descripcion = request.getParameter("cat_descripcion");
		//se crea un objeto Categoría y se le meten los datos anteriores
		Categoria cat = new Categoria();
		cat.setCat_nombre(cat_nombre);
		cat.setCat_descripcion(cat_descripcion);
		cDAOH = new CategoriaDAOH();
		try {
			cDAOH.insertarRegistro(cat);
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (DomainException e) {
			e.printStackTrace();
		}
		
		//HTML
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Inserción de categoría</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<P>La nueva categoría ha sido añadida correctamente con los siguientes datos:</P>");
		out.println("<P><B>ID :</B> " + cat.getId_categoria() + "</P>");
		out.println("<P><B>Nombre de categoría:</B> " + cat_nombre + "</P>");
		out.println("<P><B>Descripción de categoría:</B></P>");
		out.println("<P style=\"margin-left:30px;\">" + cat_descripcion + "</P>");
	
		out.println("<A HREF=\"ListarCategoria\" style=\"margin-top:50px;margin-left:300px;\">Volver</A>");
		out.println("</BODY></HTML>");
	}

}
