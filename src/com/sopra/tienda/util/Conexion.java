package com.sopra.tienda.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sopra.tienda.exception.DAOException;

public class Conexion {
	/**
	 * Variable para obtener la conexión
	 */
	private static Connection conn;
	/**
	 * Driver JDBC
	 */
	private final static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	/**
	 * Dirección de la BD
	 */
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	/**
	 * Usuario para acceder a BD
	 */
	private final static String USUARIO = "alumno";
	/**
	 * Password para acceder a la BD
	 */
	private final static String PASSWORD = "Curso201604";

	/**
	 * Conexión á BD
	 * 
	 * @return
	 * @throws DAOException
	 */
	public static Connection getConnection() throws DAOException {
		try {
			if (conn == null || conn.isClosed()) { // para non facer unha conexión
													// cada vez
				try {
					Class.forName(JDBC_DRIVER);
					System.out.println("Se ha registrado el Driver correctamente");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
					conn.setAutoCommit(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static int obtenerClave(String tabla, String id) throws SQLException{
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT MAX("+ id +")+1 as maximo FROM "+tabla);
		rs.next();
		return rs.getInt("maximo");
	}
	
	
	
}
