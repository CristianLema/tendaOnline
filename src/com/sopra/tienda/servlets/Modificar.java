package com.sopra.tienda.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class Modificar
 */
@WebServlet("/Modificar")
public class Modificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaDAOH cDAOH = new CategoriaDAOH();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Modificar() {
		super();
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
		String cat_nombre = request.getParameter("cat_nombre");
		String cat_descripcion = request.getParameter("cat_descripcion");
		int id_categoria = Integer.valueOf(request.getParameter("id_categoria"));
		Categoria cat = new Categoria();
		cat.setId_categoria(id_categoria);
		cat.setCat_nombre(cat_nombre);
		cat.setCat_descripcion(cat_descripcion);
		cDAOH = new CategoriaDAOH();
		try {
			cDAOH.actualizarRegistro(cat);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarCategoria");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
		
		
	}

}
