package com.sopra.tienda.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.tienda.dominio.Producto;
import com.sopra.tienda.exception.DAOException;
import com.sopra.tienda.exception.DomainException;
import com.sopra.tienda.objetos.daos.ProductoDAOH;
import com.sopra.tienda.util.Rutinas;

/**
 * Servlet implementation class EngadirProducto
 */
@WebServlet("/EngadirProducto")
public class EngadirProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAOH pDAOH = new ProductoDAOH();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EngadirProducto() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id_producto = request.getParameter("id_producto");
		String pro_descripcion = request.getParameter("pro_descripcion");
		String pro_desLarga = request.getParameter("pro_desLarga");
		double pro_precio = Double.parseDouble(request.getParameter("pro_precio"));
		int pro_stock = Integer.parseInt(request.getParameter("pro_stock"));
		Calendar pro_fecRepos = Rutinas.convierteACalendar(request.getParameter("pro_fecRepos"));
		Calendar pro_fecActi = Rutinas.convierteACalendar(request.getParameter("pro_fecActi"));
		Calendar pro_fecDesacti = Rutinas.convierteACalendar(request.getParameter("pro_fecDesacti"));
		String pro_uniVenta = request.getParameter("pro_uniVenta");
		double pro_cantXUniVenta = Double.parseDouble(request.getParameter("pro_cantXUniVenta"));
		String pro_uniUltNivel = request.getParameter("pro_uniUltNivel");
		int id_pais = Integer.parseInt(request.getParameter("id_pais"));
		String pro_usoRecomendado = request.getParameter("pro_usoRecomendado");
		int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
		int pro_stkReservado = Integer.parseInt(request.getParameter("pro_stkReservado"));
		int pro_nStkAlto = Integer.parseInt(request.getParameter("pro_nStkAlto"));
		int pro_nStkBajo = Integer.parseInt(request.getParameter("pro_nStkBajo"));
		char pro_stat = request.getParameter("pro_stat").charAt(0);
		
		Producto prod = new Producto();
		
		try {
			prod.setId_producto(id_producto);
		} catch (DomainException e1) {
			e1.printStackTrace();
			out.println("<HTML>");
			out.println("<HEAD><TITLE>Error</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<H1>Producto no creado</H1>");
			out.println("<P><H1>El ID es incorrecto</H1></P>");
			out.println("<P>El ID cumplir el formato AA000</P>");
			out.println("<A HREF=\"crearProducto.jsp\" style=\"margin-top:50px;margin-left:300px;\">Volver</A>");
			out.println("</BODY></HTML>");
		};
		try {
			prod.setPro_descripcion(pro_descripcion);
		} catch (DomainException e) {
			e.printStackTrace();
			out.println("<HTML>");
			out.println("<HEAD><TITLE>Error</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<H1>Producto no creado</H1>");
			out.println("<P><H1>Error en la descripción del producto</H1></P>");
			out.println("<P>La descripción del producto debe contener entre 5 y 100 caracteres alfanuméricos</P>");
			out.println("<A HREF=\"crearProducto.jsp\" style=\"margin-top:50px;margin-left:300px;\">Volver</A>");
			out.println("</BODY></HTML>");
		}
		try {
			prod.setPro_desLarga(pro_desLarga);
		} catch (DomainException e) {
			e.printStackTrace();
			out.println("<HTML>");
			out.println("<HEAD><TITLE>Error</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<H1>Producto no creado</H1>");
			out.println("<P><H1>Error en la descripción larga</H1></P>");
			out.println("<P>La descripción larga debe contener entre 4 y 2000 caracteres alfanuméricos</P>");
			out.println("<A HREF=\"crearProducto.jsp\" style=\"margin-top:50px;margin-left:300px;\">Volver</A>");
			out.println("</BODY></HTML>");
		}
		try {
			prod.setPro_precio(pro_precio);
		} catch (DomainException e) {
			e.printStackTrace();
			out.println("<HTML>");
			out.println("<HEAD><TITLE>Error</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<H1>Producto no creado</H1>");
			out.println("<P><H1>Error en el precio</H1></P>");
			out.println("<P>Debe tener un valor mayor a 0,00 y no superior a 100,00</P>");
			out.println("<A HREF=\"crearProducto.jsp\" style=\"margin-top:50px;margin-left:300px;\">Volver</A>");
			out.println("</BODY></HTML>");
		}
		prod.setPro_stock(pro_stock);
		try {
			prod.setPro_fecRepos(pro_fecRepos);
		} catch (DomainException e) {
			e.printStackTrace();
			out.println("<HTML>");
			out.println("<HEAD><TITLE>Error</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<H1>Producto no creado</H1>");
			out.println("<P><H1>Error en la fecha de reposición</H1></P>");
			out.println("<P>Debe cumplir con el formato dd/mm/aaaa</P>");
			out.println("<A HREF=\"crearProducto.jsp\" style=\"margin-top:50px;margin-left:300px;\">Volver</A>");
			out.println("</BODY></HTML>");
		}
		try {
			prod.setPro_fecActi(pro_fecActi);
		} catch (DomainException e) {
			e.printStackTrace();
			out.println("<HTML>");
			out.println("<HEAD><TITLE>Error</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<H1>Producto no creado</H1>");
			out.println("<P><H1>Error en la fecha de activación</H1></P>");
			out.println("<P>Debe cumplir con el formato dd/mm/aaaa</P>");
			out.println("<A HREF=\"crearProducto.jsp\" style=\"margin-top:50px;margin-left:300px;\">Volver</A>");
			out.println("</BODY></HTML>");
		}
		try {
			prod.setPro_fecDesacti(pro_fecDesacti);
		} catch (DomainException e) {
			e.printStackTrace();
			out.println("<HTML>");
			out.println("<HEAD><TITLE>Error</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<H1>Producto no creado</H1>");
			out.println("<P><H1>Error en la fecha de desactivación</H1></P>");
			out.println("<P>Debe cumplir con el formato dd/mm/aaaa</P>");
			out.println("<A HREF=\"crearProducto.jsp\" style=\"margin-top:50px;margin-left:300px;\">Volver</A>");
			out.println("</BODY></HTML>");
		}
		try {
			prod.setPro_uniVenta(pro_uniVenta);
		} catch (DomainException e) {
			e.printStackTrace();
			out.println("<HTML>");
			out.println("<HEAD><TITLE>Error</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<H1>Producto no creado</H1>");
			out.println("<P><H1>Error en la unidad de venta</H1></P>");
			out.println("<P>Debe contener entre 1 y 10 caracteres alfanuméricos y no puede estar vacío</P>");
			out.println("<A HREF=\"crearProducto.jsp\" style=\"margin-top:50px;margin-left:300px;\">Volver</A>");
			out.println("</BODY></HTML>");
		}
		prod.setPro_cantXUniVenta(pro_cantXUniVenta);
		prod.setPro_uniUltNivel(pro_uniUltNivel);
		prod.setId_pais(id_pais);
		prod.setPro_usoRecomendado(pro_usoRecomendado);
		prod.setId_categoria(id_categoria);
		prod.setPro_stkReservado(pro_stkReservado);
		prod.setPro_nStkAlto(pro_nStkAlto);
		prod.setPro_nStkBajo(pro_nStkBajo);
		try {
			prod.setPro_stat(pro_stat);
		} catch (DomainException e) {
			e.printStackTrace();
		}
		
		if (pro_descripcion.isEmpty() || pro_precio<=0.0 || pro_uniVenta.isEmpty() || id_pais==0 || id_categoria==0){
			out.println("<HTML>");
			out.println("<HEAD><TITLE>Error</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<H1>Producto no creado</H1>");
			out.println("<P>Alguno de los datos no son correctos, compruebe que:</P>");
			out.println("<P>El ID sigue el formato AA000</P>");
			out.println("<P>El nombre del producto solo contenga entre 5 y 100 caracteres alfanuméricos.</P>");
			out.println("<P>Contenga precio</P>");
			out.println("<P>Contenga unidad de venta</P>");
			out.println("<P>Tenga país de origen asignado</P>");
			out.println("<P>Tenga categoría asignada</P>");
			out.println("<A HREF=\"crearProducto.jsp\" style=\"margin-top:50px;margin-left:300px;\">Volver</A>");
			out.println("</BODY></HTML>");
		} else{
			try {
				pDAOH.insertarRegistro(prod);
				out.println("<HTML>");
				out.println("<HEAD><TITLE>Inserción de usuario</TITLE></HEAD>");
				out.println("<BODY>");
				out.println("<H1>El nuevo usuario ha sido creado correctamente con los siguientes datos:</H1>");
				out.println("<P><B>ID: </B> " + prod.getId_producto() + "</P>");
				out.println("<P><B>Producto: </B> " + prod.getPro_descripcion() + "</P>");
				out.println("<P><B>Descripción: </B> " + prod.getPro_desLarga() + "</P>");
				out.println("<P><B>Precio: </B> " + prod.getPro_precio() + "</P>");
				out.println("<P><B>Unidad de venta: </B> " + prod.getPro_uniVenta() + "</P>");
				out.println("<P><B>Stock: </B> " + prod.getPro_stock() + "</P>");
				out.println("<P><B>Fecha Reposición: </B> " + prod.getPro_fecRepos() + "</P>");
				out.println("<P><B>Fecha Activación: </B> " + prod.getPro_fecActi() + "</P>");
				out.println("<P><B>Fecha Desactivación: </B> " + prod.getPro_fecDesacti() + "</P>");
				out.println("<P><B>Cantidad por unidad de venta: </B> " + prod.getPro_cantXUniVenta() + "</P>");
				out.println("<P><B>Unidad última: </B> " + prod.getPro_uniUltNivel() + "</P>");
				out.println("<P><B>País de origen: </B> " + prod.getId_pais() + "</P>");
				out.println("<P><B>Uso recomendado: </B> " + prod.getPro_usoRecomendado() + "</P>");
				out.println("<P><B>Categoría: </B> " + prod.getId_categoria() + "</P>");
				out.println("<P><B>Stock reservado: </B> " + prod.getPro_stkReservado() + "</P>");
				out.println("<P><B>Cantidad de stock Alto: </B> " + prod.getPro_nStkAlto() + "</P>");
				out.println("<P><B>Cantidad de stock Bajo: </B> " + prod.getPro_nStkBajo() + "</P>");
				out.println("<P><B>Estado de producto: </B> " + prod.getPro_stat() + "</P>");
				out.println("<A HREF=\"ListarProductos\" style=\"margin-top:50px;margin-left:300px;\">Volver</A>");
				out.println("</BODY></HTML>");
			} catch (DAOException | DomainException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
