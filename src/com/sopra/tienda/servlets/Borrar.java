package com.sopra.tienda.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.tienda.dominio.Categoria;
import com.sopra.tienda.exception.DAOException;
import com.sopra.tienda.objetos.daos.CategoriaDAOH;

/**
 * Servlet implementation class Borrar
 */
@WebServlet("/Borrar")
public class Borrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaDAOH cDAOH = new CategoriaDAOH();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Borrar() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		Categoria catID = new Categoria();
		int id_categoria = Integer.valueOf(request.getParameter("id"));
		catID.setId_categoria(id_categoria);
		try {
			cDAOH.borrarRegistro(catID);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarCategoria");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

}
