package com.sopra.tienda.objetos.daos;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;


import org.junit.BeforeClass;
import org.junit.Test;

import com.sopra.tienda.dominio.Usuario;
import com.sopra.tienda.exception.DAOException;
import com.sopra.tienda.exception.DomainException;
import com.sopra.tienda.util.Conexion;

public class UsuarioDAOHTest {
	static UsuarioDAOH uDAOH;
	static Usuario reg1;
	static Usuario reg2;
	static Usuario reg3;
	static Usuario reg4;
	static Connection conn;
	static Calendar cal = Calendar.getInstance();

	@BeforeClass
	public static void inicializar() throws DAOException, SQLException, DomainException {
		uDAOH = new UsuarioDAOH();

		reg1 = new Usuario();
		reg1.setId_usuario(90);
		reg1.setUser_nombre("Usuario1");
		reg1.setUser_pass("Contrase%a1");
		reg1.setUser_email("usuario.uno@email.com");
		reg1.setUser_tipo(1);
		reg1.setUser_dni("12.345.678-Z");
		reg1.setUser_fecAlta(cal);
		reg1.setUser_fecConfirmacion(cal);

		reg2 = new Usuario();
		reg2.setUser_nombre("Usuaria2");
		reg2.setUser_pass("Contrase%a2");
		reg2.setUser_email("usuaria.dos@email.com");
		reg2.setUser_tipo(1);
		reg2.setUser_dni("12.345.678-Z");
		reg2.setUser_fecAlta(cal);
		reg2.setUser_fecConfirmacion(cal);

		conn = Conexion.getConnection();

	}

	@Test
	public void testLeerTodos() throws DAOException {
		List<Usuario> lista = uDAOH.leerTodos();
		System.out.println("Leer todos los registros:");
		for (Usuario reg1 : lista) {
			System.out.println("Id: " + reg1.getId_usuario() + "\tTitulo: " + reg1.getUser_nombre() + "\tEmail: "
					+ reg1.getUser_email());
		}
		assertTrue("Lista todo", lista.size() > 0);
	}

	@Test
	public void testLeerRegistros() throws DAOException {
		List<Usuario> lista = uDAOH.leerRegistros(reg1);
		System.out.println("Leer algunos registros:");
		for (Usuario reg1 : lista) {
			System.out.println("Id:" + reg1.getId_usuario() + " Titulo:" + reg1.getUser_nombre() + "\tEmail: "
					+ reg1.getUser_email());
		}
		assertTrue("Lista registros", lista.size() > 0);
	}

	@Test
	public void testLeerRegistro() throws DomainException, DAOException {
		uDAOH.insertarRegistro(reg1);
		Usuario resp = uDAOH.leerRegistro(reg1);
		assertEquals(reg1.getId_usuario(), resp.getId_usuario());
		assertEquals(reg1.getUser_nombre(), resp.getUser_nombre());
		assertEquals(reg1.getUser_email(), resp.getUser_email());
	}

	@Test
	public void testLeerRegistro2() throws DomainException, DAOException {
		reg4 = new Usuario();
		reg4.setUser_email("admin@correo.com");
		reg4.setId_usuario(0);
		uDAOH.insertarRegistro(reg4);
		Usuario resp = uDAOH.leerRegistro(reg4);
		assertEquals(reg4.getId_usuario(), resp.getId_usuario());
		//assertEquals(reg4.getUser_nombre(), resp.getUser_nombre());
		assertEquals(reg4.getUser_email(), resp.getUser_email());
		
	}
	@Test
	public void testActualizarRegistro() throws DomainException, DAOException, SQLException {
		uDAOH.insertarRegistro(reg1);
		conn.commit();
		reg3 = new Usuario();
		reg3.setId_usuario(reg1.getId_usuario());
		reg3.setUser_nombre("Nombre3");
		uDAOH.actualizarRegistro(reg3);
		conn.commit();
		reg1.setUser_nombre(reg3.getUser_nombre());
		Usuario resp = uDAOH.leerRegistro(reg3);
		assertEquals(resp.getUser_nombre(), reg1.getUser_nombre());
		assertEquals(resp.getUser_nombre(), reg3.getUser_nombre());
	}

	@Test
	public void testInsertarRegistro() throws DAOException, SQLException, DomainException {
		uDAOH.insertarRegistro(reg1);
		conn.commit();
		reg2 = new Usuario();
		reg2.setId_usuario(reg1.getId_usuario());
		Usuario resp = uDAOH.leerRegistro(reg2);
		System.out.println(resp.getId_usuario()+" "+resp.getUser_nombre());
		System.out.println(reg1.getId_usuario()+" "+reg1.getUser_nombre());
		assertEquals(resp.getId_usuario(),reg1.getId_usuario());
		assertEquals(resp.getUser_nombre(),reg1.getUser_nombre());
		
	}

	@Test(expected = DAOException.class)
	public void testBorrarRegistro() throws DAOException, DomainException, SQLException {
		uDAOH.insertarRegistro(reg1);
		conn.commit();
		uDAOH.borrarRegistro(reg1);
		conn.commit();
		Usuario resp = uDAOH.leerRegistro(reg1);
	}

}
