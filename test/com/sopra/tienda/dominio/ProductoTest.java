package com.sopra.tienda.dominio;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.sopra.tienda.dominio.Producto;
import com.sopra.tienda.exception.DomainException;

public class ProductoTest {
	Producto producto;
	final String descri = "Texto para descripcion";

	@Before
	public void iniciar() {
		producto = new Producto();
	}

	// Comprobar que producto es válido
	@Test
	public void testValidoBen() throws DomainException {
		producto.setId_producto("AB234");
		producto.setPro_descripcion(descri);
		String udVenta = "uds";
		producto.setPro_uniVenta(udVenta);
		producto.setPro_precio(23d);
		producto.setId_pais(1);
		producto.setId_categoria(2);
		assertTrue(producto.isValid());
	}

	// Producto no válido porque falta id
	@Test
	public void testValidoMal1() throws DomainException {
		producto.setPro_descripcion(descri);
		String udVenta = "uds";
		producto.setPro_uniVenta(udVenta);
		producto.setPro_precio(23d);
		producto.setId_pais(1);
		producto.setId_categoria(2);
		assertFalse(producto.isValid());
	}

	// Producto no válido porque falta descripcion
	@Test
	public void testValidoMal2() throws DomainException {
		producto.setId_producto("AB234");
		String udVenta = "uds";
		producto.setPro_uniVenta(udVenta);
		producto.setPro_precio(23d);
		producto.setId_pais(1);
		producto.setId_categoria(2);
		assertFalse(producto.isValid());
	}

	// Producto no válido porque falta ud venta
	@Test
	public void testValidoMal3() throws DomainException {
		producto.setId_producto("AB234");
		producto.setPro_descripcion(descri);
		producto.setPro_precio(23d);
		producto.setId_pais(1);
		producto.setId_categoria(2);
		assertFalse(producto.isValid());
	}

	// Producto no válido porque precio fuera de rango
	@Test(expected = DomainException.class)
	public void testValidoMal4() throws DomainException {
		producto.setId_producto("AB234");
		producto.setPro_descripcion(descri);
		String udVenta = "uds";
		producto.setPro_precio(201d);
		producto.setPro_uniVenta(udVenta);
		producto.setId_pais(1);
		producto.setId_categoria(2);
	}

	// Producto no válido porque pais inválido
	@Test
	public void testValidoMal5() throws DomainException {
		producto.setId_producto("AB234");
		producto.setPro_descripcion(descri);
		String udVenta = "uds";
		producto.setPro_uniVenta(udVenta);
		producto.setId_pais(-1);
		producto.setPro_precio(23d);
		producto.setId_categoria(2);
		assertFalse(producto.isValid());
	}

	// Producto no válido porque inválida id categoría
	@Test
	public void testValidoMal6() throws DomainException {
		producto.setId_producto("AB234");
		producto.setPro_descripcion(descri);
		String udVenta = "uds";
		producto.setPro_uniVenta(udVenta);
		producto.setPro_precio(23d);
		producto.setId_categoria(-2);
		producto.setId_pais(1);
		assertFalse(producto.isValid());
	}

	// unidad venta correcto
	@Test
	public void testUdVentaBen() throws DomainException {
		String udVenta = "uds";
		producto.setPro_uniVenta(udVenta);
		assertEquals("Unidad de vetna", udVenta, producto.getPro_uniVenta());

	}

	// unidad venta incorrecto
	@Test(expected = DomainException.class)
	public void testUdVentaMal() throws DomainException {
		String udVenta = "uds.2";
		producto.setPro_uniVenta(udVenta);
	}

	// Probar menos de 5 posiciones
	@Test(expected = DomainException.class)
	public void setId_producto1Mal() throws DomainException {
		producto.setPro_descripcion("AB2");
	}

	// Probar mas de 5 posiciones
	@Test(expected = DomainException.class)
	public void setId_producto2Mal() throws DomainException {
		producto.setId_producto("AB2345");
	}

	// Probar 5 caracteres no alfanumericos
	@Test(expected = DomainException.class)
	public void setId_producto3Mal() throws DomainException {
		producto.setId_producto("AB.34");
	}

	// Sin mayúsculas
	@Test(expected = DomainException.class)
	public void setId_producto4Mal() throws DomainException {
		producto.setId_producto("ab234");
	}

	// formato incorrecto
	@Test(expected = DomainException.class)
	public void setId_producto5Mal() throws DomainException {
		producto.setId_producto("EJT32");
	}

	// Probar 5 caracteres alfanumericos
	@Test
	public void setId_producto6Ben() throws DomainException {
		producto.setId_producto("AB234");
		assertEquals("setId_producto", "AB234", producto.getId_producto());
	}

	// Introducir descripción
	@Test
	public void testsetPro_descripcionBen() throws DomainException {
		final String descri = "Texto para descripcion";
		producto.setPro_descripcion(descri);
		assertEquals("Descripcion", descri, producto.getPro_descripcion());
	}
	// Comprobar entrada no numerica - no ha lugar

	// Comprobar entrada numerica con decimal/verificar
	@Test
	public void testSetPrecio1Ben() throws DomainException {
		producto.setPro_precio(95.34);
		assertEquals("Precio con decimales", 95.34, producto.getPro_precio(), 0);
	}

	// Comprobar entrada numerica < 0
	@Test(expected = DomainException.class)
	public void testSetPrecio2Mal() throws DomainException {
		producto.setPro_precio(-100.1);
	}

	// Comprobar entrada numérica >100
	@Test(expected = DomainException.class)
	public void testSetPrecio3Mal() throws DomainException {
		producto.setPro_precio(105.3);
	}

	// Fecha de activación anterior a la acutal
	@Test(expected = DomainException.class)
	public void testSetFecActivacionMal() throws DomainException {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 4);
		producto.setPro_fecActi(cal);
	}

	// Fecha de activación posterior a la actual
	@Test
	public void testSetFecActivacionBen() throws DomainException {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 8);
		producto.setPro_fecActi(cal);
		assertEquals("Fecha de activación", cal, producto.getPro_fecActi());
	}

	// Fecha de desactivación anterior a la actual
	@Test(expected = DomainException.class)
	public void testSetFecDesactivacionMal() throws DomainException {
		Calendar calDesactiv = Calendar.getInstance();
		Calendar calActiv = Calendar.getInstance();
		calDesactiv.set(Calendar.MONTH, 4);
		calActiv.set(Calendar.MONTH, 8);
		producto.setPro_fecDesacti(calDesactiv);
	}

	// Sin fecha de activación
	@Test(expected = DomainException.class)
	public void testSetFecDesactivacion2Mal() throws DomainException {
		Calendar calDesactiv = Calendar.getInstance();
		calDesactiv.set(Calendar.MONTH, 8);
		producto.setPro_fecDesacti(calDesactiv);
	}

	// Fecha de desactivación posterior a la actual
	@Test
	public void testSetFecDesactivacionBen() throws DomainException {
		Calendar calDesactiv = Calendar.getInstance();
		Calendar calActiv = Calendar.getInstance();
		calDesactiv.set(Calendar.MONTH, 9);
		calActiv.set(Calendar.MONTH, 8);
		producto.setPro_fecActi(calActiv);
		producto.setPro_fecDesacti(calDesactiv);
		assertEquals("Fecha de desactivación", calDesactiv, producto.getPro_fecDesacti());
	}

	// Descripción Larga del producto
	@Test
	public void testDescripLargaBen() throws DomainException {
		String descripLarga = "Enblakeubflaiub labfilaeur laif ieal eaiu bliufbv leiub vieb vieu aieu i4 ah74 laie47 awe4i7 d";
		producto.setPro_desLarga(descripLarga);
		assertEquals("DescripLarga", descripLarga, producto.getPro_desLarga());
	}

	// Fecha de activación anterior a la acutal
	@Test(expected = DomainException.class)
	public void testSetFecReposMal() throws DomainException {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 4);
		producto.setPro_fecRepos(cal);
	}

	// Fecha de activación posterior a la actual
	@Test
	public void testSetFecReposBen() throws DomainException {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 8);
		producto.setPro_fecRepos(cal);
		assertEquals("Fecha de activación", cal, producto.getPro_fecRepos());
	}

}
