package com.sopra.tienda.util;

import static org.junit.Assert.*;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sopra.tienda.exception.DAOException;

public class testConexion {
	private static Connection conn;
	static Statement stm;
	static final String IDENTIFICADOR1 = "BRBRTRBRBRBRT";
	static final String REGISTRO1 = " - categoria Uno";
	static final String SQL_LIMPA = "DELETE FROM categoria WHERE cat_nombre = '" + IDENTIFICADOR1 + "%'";
	// pónse % por se se puxera IDENTIFICADOR1+OQUESEXA, este tamén quedaría
	// eleminado
	static final String INSERTA1 = "INSERT into categoria VALUES (1,'" + IDENTIFICADOR1 + REGISTRO1
			+ "','Descripción de la primera categoria')";
	final String ELIMINA1 = "DELETE FROM categoria WHERE cat_nombre = '" + IDENTIFICADOR1 + "'";
	final String SELECCIONAR1 = "SELECT * FROM categoria WHERE cat_nombre = '" + IDENTIFICADOR1 + "'";
	final String SQL_LER = "SELECT COUNT(*) as contador FROM categoria WHERE cat_nombre LIKE '" 
			+ IDENTIFICADOR1 + "'";

	@BeforeClass
	public static void inicio() throws DAOException, SQLException {
		// @BeforeClass execútase antes de se iniciaren os tests
		// bórranse posibles rastros de probas anteriores
		conn = Conexion.getConnection();
		stm = conn.createStatement();
		borrarTodo();

	}

	@AfterClass
	public static void finalizar() throws DAOException {
		// elemínanse os rastros que se deixaron das probas
		borrarTodo();
	}

	@Test
	public void insertar() throws DAOException, SQLException {
		System.out.println(stm.executeUpdate(INSERTA1));
		ResultSet rs = stm.executeQuery(SQL_LER + REGISTRO1);
		rs.next(); // posicionar rs na posición 1
		if (rs.getInt("contador") != 1) {
			fail("Fallou INSERT. Contador = " + rs.getInt("contador"));
		}
	}

	/*
	 * @Test public void eliminar() throws DAOException, SQLException {
	 * Statement stm = conn.createStatement(); ResultSet prim =
	 * stm.executeQuery(SELECCIONAR1); stm.executeUpdate(ELIMINA1); }
	 */
	public static void borrarTodo() throws DAOException {
		conn = Conexion.getConnection();
		Statement stm;
		try {
			stm = conn.createStatement();
			stm.executeUpdate(SQL_LIMPA);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * @Before public void inicio() throws DAOException{ conn =
	 * Conexion.getConnection(); }
	 * 
	 * @Test public void testCommit() throws DAOException, SQLException {
	 * Statement stm = conn.createStatement(); stm.executeUpdate(
	 * "Update EMP set JOB = JOB"); RFDataConnection.commit(); }
	 * 
	 * @Test public void testRollback() throws SQLException, DAOException {
	 * Statement stm = conn.createStatement(); stm.executeUpdate(
	 * "Update EMP set sal = sal + 10000 "); RFDataConnection.rollback(); }
	 * 
	 * @Test public void testCloseStatement() throws SQLException, DAOException
	 * { Statement stm = conn.createStatement();
	 * RFDataConnection.closeStatement(stm); assertTrue("Cerrar statment"
	 * ,stm.isClosed()); }
	 * 
	 * @Test public void testCloseResulSet() throws SQLException, DAOException {
	 * Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(
	 * "SELECT * FROM EMP"); RFDataConnection.closeResulSet(rs);
	 * 
	 * }
	 */
}
