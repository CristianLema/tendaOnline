package com.sopra.tienda.objetos.daos;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sopra.tienda.dominio.Categoria;
import com.sopra.tienda.exception.DAOException;
import com.sopra.tienda.util.Conexion;

public class testCategoriaDao {
	static CategoriaDAO cDAO;
	static Categoria reg1;
	static Categoria reg2;
	static Categoria reg3;
	static Connection conn;

	@BeforeClass
	public static void inicializar() throws DAOException, SQLException {
		cDAO = new CategoriaDAO();

		reg1 = new Categoria();
		reg1.setId_categoria(90);
		reg1.setCat_nombre("Titulo n-1");
		reg1.setCat_descripcion("Descripcion categoria n-1");

		reg2 = new Categoria();
		reg2.setCat_nombre("Titulo n");
		reg2.setCat_descripcion("Descripcion categoria n");
		
		conn=Conexion.getConnection();

	}

	//Imprimir en pantalla cada uno de los registros de la base de datos
	@Test
	public void testLeerTodos() throws DAOException, SQLException {
		List<Categoria> lista = cDAO.leerTodos();
		System.out.println("Leer todos los registros:");
		for (Categoria reg1 : lista) {
			System.out.println("Id: " + reg1.getId_categoria() + "\tTitulo: " + reg1.getCat_nombre());
		}
		assertTrue("Lista todo", lista.size() > 0);
	}

	//Imprimir en pantalla todos los registros de la base de datos que coincidan en id, nombre y descripcion con reg1
	@Test
	public void testLeerRegistros() throws DAOException, SQLException {
		List<Categoria> lista = cDAO.leerRegistros(reg1);
		System.out.println("Leer algunos registros:");
		for (Categoria reg1 : lista) {
			System.out.println("Id:" + reg1.getId_categoria() + " Titulo:" + reg1.getCat_nombre());
		}
		assertTrue("Lista registros", lista.size() > 0);
	}

	//Comprobar que leerRegistro da un objeto categoría igual al que introducimos
	@Test
	public void testLeerRegistro() throws DAOException, SQLException {
		cDAO.insertarRegistro(reg1);
		Categoria resp = cDAO.leerRegistro(reg1);
		reg2 = new Categoria();
		reg2.setId_categoria(reg1.getId_categoria());
		reg2.setCat_descripcion(reg1.getCat_descripcion());
		reg2.setCat_nombre(reg1.getCat_nombre());
		assertTrue("Ler Registro", resp.equals(reg1));
	}

	//Modificar un registro y comprobar que se ha actualizado correctamente
	@Test
	public void testActualizarRegistro() throws DAOException, SQLException {
		cDAO.insertarRegistro(reg1);
		conn.commit();
		reg3= new Categoria();
		reg3.setId_categoria(reg1.getId_categoria());
		reg3.setCat_nombre("Titulo reg3");
		reg3.setCat_descripcion("Descripcion reg3");
		cDAO.actualizarRegistro(reg3);
		conn.commit();
		reg1.setCat_descripcion(reg3.getCat_descripcion());
		reg1.setCat_nombre(reg3.getCat_nombre());
		Categoria resp = cDAO.leerRegistro(reg3);
		assertTrue(resp.equals(cDAO.leerRegistro(reg1)));
	}

	//Insertar un registro y comprobar que se ha insertado correctamente
	@Test
	public void testInsertarRegistro() throws DAOException, SQLException {
		cDAO.insertarRegistro(reg1);
		conn.commit();
		reg2 = new Categoria();
		reg2.setId_categoria(reg1.getId_categoria());
		Categoria resp = cDAO.leerRegistro(reg2);
		assertTrue(resp.equals(reg1));

	}

	//Borrar un registro y comprobar que no existe a la hora de leerlo
	@Test
	public void testBorrarRegistro() throws DAOException, SQLException {
		cDAO.insertarRegistro(reg1);
		conn.commit();
		cDAO.borrarRegistro(reg1);
		conn.commit();
		Categoria resp = cDAO.leerRegistro(reg1);
		assertNull(resp);
	}

}
