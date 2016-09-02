package com.sopra.tienda.util;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.sopra.tienda.dominio.Usuario;
import com.sopra.tienda.exception.DomainException;

public class UsuarioTest {
	Usuario user;

	@Before
	public void inicio() {
		user = new Usuario();
	}

	// comprobar que usuario es válido
	@Test
	public void testValidoBen() throws DomainException {
		user.setUser_nombre("Esd5Fr");
		user.setUser_email("sienvf.sen.snboge@soeigns.er.et");
		user.setUser_pass("83ne%dieAGEW");
		user.setId_usuario(3);
		assertTrue(user.isValid());
	}

	// si falta el nombre de usuario, no se puede poner la contraseña

	// usuario no válido porque falta email
	@Test
	public void testValidoMal2() throws DomainException {
		user.setUser_nombre("Esd5Fr");
		user.setUser_pass("83ne%dieAGEW");
		user.setId_usuario(3);
		assertFalse(user.isValid());
	}

	// usuario no válido porque falta contraseña
	@Test
	public void testValidoMal3() throws DomainException {
		user.setUser_nombre("Esd5Fr");
		user.setUser_email("sienvf.sen.snboge@soeigns.er.et");
		user.setId_usuario(3);
		assertFalse(user.isValid());
	}

	// usuario no válido porque id no válida
	@Test
	public void testValidoMal4() throws DomainException {
		user.setUser_nombre("Esd5Fr");
		user.setUser_email("sienvf.sen.snboge@soeigns.er.et");
		user.setUser_pass("83ne%dieAGEW");
		user.setId_usuario(-5);
		assertFalse(user.isValid());
	}

	// Nombre de usuario menor a 5 caracteres
	@Test(expected = DomainException.class)
	public void testUserNameMal1() throws DomainException {
		user.setUser_nombre("Esd1");
	}

	// Nombre de usuario con caracteres no alfanumericos
	@Test(expected = DomainException.class)
	public void testUserNameMal2() throws DomainException {
		user.setUser_nombre("Esd.5fR");
	}

	// Nombre de usuario correcto
	@Test
	public void testUserNameBen() throws DomainException {
		user.setUser_nombre("Esd5Fr");
		assertEquals("setUserName", "Esd5Fr", user.getUser_nombre());
	}

	// Email incorrecto
	@Test(expected = DomainException.class)
	public void testEmailMal() throws DomainException {
		user.setUser_email("sdf@sjo-se");

	}

	// Email corto
	@Test(expected = DomainException.class)
	public void testUserEmailMal1() throws DomainException {
		user.setUser_email("s@d.e");
	}

	// Email correcto
	@Test
	public void testUserEmailBen() throws DomainException {
		user.setUser_email("sienvf.sen.snboge@soeigns.er.et");
		assertEquals("setUserEmail", "sienvf.sen.snboge@soeigns.er.et", user.getUser_email());
	}

	// Contraseña corta
	@Test(expected = DomainException.class)
	public void testUserPassMal() throws DomainException {
		// La contraseña no puede contener al nombre de usuario
		user.setUser_nombre("Esd5Fr");
		user.setUser_pass("gh%34R");
	}

	// Contraseña larga
	@Test(expected = DomainException.class)
	public void testUserPassMal1() throws DomainException {
		user.setUser_nombre("Esd5Fr");
		user.setUser_pass("gh%34Rfjsoen738283js%%nfesielsneifle893782EGSR");
	}

	// falta número
	@Test(expected = DomainException.class)
	public void testUserPassMal2() throws DomainException {
		user.setUser_nombre("Esd5Fr");
		user.setUser_pass("gh%EiEGEtR");
	}

	// falta minúscula
	@Test(expected = DomainException.class)
	public void testUserPassMal3() throws DomainException {
		user.setUser_nombre("Esd5Fr");
		user.setUser_pass("GH%EIEGE5R");
	}

	// falta mayúscula
	@Test(expected = DomainException.class)
	public void testUserPassMal4() throws DomainException {
		user.setUser_nombre("Esd5Fr");
		user.setUser_pass("gh%3i346t2");
	}

	// falta caracter especial
	@Test(expected = DomainException.class)
	public void testUserPassMal5() throws DomainException {
		user.setUser_nombre("Esd5Fr");
		user.setUser_pass("gh3EiEGEtR");
	}

	// no puede contener nombre de usuario
	@Test(expected = DomainException.class)
	public void testUserPassMal6() throws DomainException {
		user.setUser_nombre("Esd5Fr");
		user.setUser_pass("Esd5Frgh%3");
	}

	// contraseña correcta
	@Test
	public void testUserPassBen() throws DomainException {
		user.setUser_nombre("Esd5Fr");
		user.setUser_pass("83ne%dieAGEW");
		assertEquals("UserPassword", "83ne%dieAGEW", user.getUser_pass());
	}

	// formato DNI incorrecto
	@Test(expected = DomainException.class)
	public void testUserDNIMal() throws DomainException {
		user.setUser_dni("12345678-Z");
	}

	// letra DNI incorrecta
	@Test(expected = DomainException.class)
	public void testUserDNIMal1() throws DomainException {
		user.setUser_dni("12.345.678-A");
	}

	// DNI correcto
	@Test
	public void testUserDNIBen() throws DomainException {
		user.setUser_dni("12.345.678-Z");
		assertEquals("UserDNI", "12.345.678-Z", user.getUser_dni());
	}

	// Fecha de alta diferente a la actual
	@Test(expected = DomainException.class)
	public void testUserFecAltaMal() throws DomainException {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 3);
		user.setUser_fecAlta(cal);

	}

	// Fecha de alta igual a la actual
	@Test
	public void testUserFecAltaBen() throws DomainException {
		Calendar cal = Calendar.getInstance();
		user.setUser_fecAlta(cal);
		assertEquals("Data alta", cal, user.getUser_fecAlta());
	}

	// Fecha de confirmación diferente a la actual
	@Test(expected = DomainException.class)
	public void testUserFecConfirmMal() throws DomainException {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 3);
		user.setUser_fecConfirmacion(cal);

	}

	// Fecha de confirmacion igual a la actual
	@Test
	public void testUserFecAltaConfirmBen() throws DomainException {
		Calendar cal = Calendar.getInstance();
		user.setUser_fecConfirmacion(cal);
		assertEquals("Data alta", cal, user.getUser_fecConfirmacion());
	}

}
