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
import com.sopra.tienda.objetos.daos.CategoriaDAOH;

/**
 * Servlet implementation class MostrarCat
 */
@WebServlet("/MostrarCat")
public class MostrarCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaDAOH cDAOH = new CategoriaDAOH();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostrarCat() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		Categoria catID = new Categoria();
		String id_categoria = request.getParameter("id");
		catID.setId_categoria(Integer.valueOf(id_categoria));
		try {
			request.setAttribute("MostrarCategoria", cDAOH.leerRegistro(catID));
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mostrar.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
