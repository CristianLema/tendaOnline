package com.sopra.tienda.util;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {
	Validator val;

	// Todos os métodos de Validator son static, polo que podemos poñer todos os
	// assertEquals seguidos

	@Before
	public void inicio() {
		val = new Validator();
	}

	@Test
	public void testIsAlfanumeric() {
		assertEquals("jdnei3", true, val.isAlfanumeric("jdnei3"));
		assertEquals("aerthbrte", true, val.isAlfanumeric("aerthbrte"));
		assertEquals("34562345", true, val.isAlfanumeric("34562345"));
		assertEquals("dwg5.dr", false, val.isAlfanumeric("dwg5.dr"));
	}

	@Test
	public void testIsVacio() {
		assertEquals("", true, val.isVacio(""));
		assertEquals("d", false, val.isVacio("d"));
	}

	@Test
	public void testCumplePhoneNumber() {
		assertEquals("4632", false, val.cumplePhoneNumber("4632"));
		assertEquals("463245351245645387868", false, val.cumplePhoneNumber("463245351245645387868"));
		assertEquals("382638f3858", false, val.cumplePhoneNumber("382638f3858"));
		assertEquals("836 338 283", false, val.cumplePhoneNumber("836 338 283"));
		assertEquals("73 283 278 837", true, val.cumplePhoneNumber("73 283 278 837"));
		assertEquals("215 245 685 258 6r2", false, val.cumplePhoneNumber("215 245 685 258 6r2"));
		assertEquals("215 245 685  82", true, val.cumplePhoneNumber("215 245 685  82"));

	}

	@Test
	public void testIsEmailValido() {
		assertEquals("osneoi.novwi@nosie.nie", true, val.isEmailValido("osneoi.novwi@nosie.nie"));
		assertEquals(".enis@nossi.eg", false, val.isEmailValido(".enis@nossi.eg"));
		assertEquals("oiwe.@nhosie.se", false, val.isEmailValido("oiwe.@nhosie.se"));
		assertEquals("nbseoi_f@snoe.esg", true, val.isEmailValido("nbseoi_f@snoe.esg"));
		assertEquals("sevne.she@nsoe.esae@nsle.sr", false, val.isEmailValido("sevne.she@nsoe.esae@nsle.sr"));
		assertEquals("sienvf.sen.snboge@soeigns.er.et", true, val.isEmailValido("sienvf.sen.snboge@soeigns.er.et"));
		assertEquals("sienvf.sen.snboge@soeigns.er.et.rr", true,
				val.isEmailValido("sienvf.sen.snboge@soeigns.er.et.rr"));
		assertEquals("nseouv@nso", false, val.isEmailValido("nseouv@nso"));
		assertEquals("lsiednv@.sef.es", false, val.isEmailValido("lsiednv@.sef.es"));
		assertEquals("nseef-sneof@bhose.et", true, val.isEmailValido("nseef-sneof@bhose.et"));
		assertEquals("r.r@r.es", true, val.isEmailValido("r.r@r.es"));
		assertEquals("r.r@r.e", false, val.isEmailValido("r.r@r.e"));
	}

	@Test
	public void testCumpleDNI() {
		assertEquals("78800772N", false, val.cumpleDNI("78800772N"));
		assertEquals("78800772-N", false, val.cumpleDNI("78800772-N"));
		assertEquals("78.800.772N", false, val.cumpleDNI("78.800.772N"));
		assertEquals("78.800.772-N", true, val.cumpleDNI("78.800.772-N"));
		assertEquals("78.800.772-n", false, val.cumpleDNI("78.800.772-n"));
		assertEquals("78.800.772-J", false, val.cumpleDNI("78.800.772-J"));
		assertEquals("545.548.545-D", false, val.cumpleDNI("545.548.545-D"));
		assertEquals("54.g548.548-E", false, val.cumpleDNI("54.g548.548-E"));
		assertEquals("36.546.548-5", false, val.cumpleDNI("36.546.548-5"));
	}

	@Test
	public void testCumpleRangoIntIntInt() {
		assertEquals(" 8-12 9 ->", true, val.cumpleRango(9, 8, 12));
		assertEquals(" 8-12 6 ->", false, val.cumpleRango(6, 8, 12));
		assertEquals(" 8-12 15 ->", false, val.cumpleRango(15, 8, 12));
		assertEquals(" 8-12 8 ->", true, val.cumpleRango(8, 8, 12));
		assertEquals(" 8-12 12 ->", true, val.cumpleRango(12, 8, 12));
	}

	@Test
	public void testCumpleRangoDoubleIntInt() {
		assertEquals(" 8-12 9.0 ->", true, val.cumpleRango(9.0, 8, 12));
		assertEquals(" 8-12 9.6 ->", true, val.cumpleRango(9.6, 8, 12));
		assertEquals(" 8-12 8.0 ->", true, val.cumpleRango(8.0, 8, 12));
		assertEquals(" 8-12 8.3 ->", true, val.cumpleRango(8.3, 8, 12));
		assertEquals(" 8-12 12.0 ->", true, val.cumpleRango(12.0, 8, 12));
		assertEquals(" 8-12 12.3 ->", false, val.cumpleRango(12.3, 8, 12));
		assertEquals(" 8-12 6.0 ->", false, val.cumpleRango(6.0, 8, 12));
		assertEquals(" 8-12 15.0 ->", false, val.cumpleRango(15.0, 8, 12));
	}

	@Test
	public void testCumpleLongitudMin() {
		assertEquals("83nedieAGEW 11 ->", true, Validator.cumpleLongitudMin("83nedieAGEW", 11));
		assertEquals("83nedieAGEW 13 ->", false, Validator.cumpleLongitudMin("83nedieAGEW", 13));
		assertEquals("83nedieAGEW 9 ->", true, Validator.cumpleLongitudMin("83nedieAGEW", 9));
	}

	@Test
	public void testCumpleLongitudMax() {
		assertEquals("  83nedieAGEW 11 ->", true, val.cumpleLongitudMax("83nedieAGEW", 11));
		assertEquals("  83nedieAGEW 13 ->", true, val.cumpleLongitudMax("83nedieAGEW", 13));
		assertEquals("  83nedieAGEW 9 ->", false, val.cumpleLongitudMax("83nedieAGEW", 9));
	}

	@Test
	public void testCumpleLongitud() {
		assertEquals("  83nedieAGEW 8-14 ->", true, val.cumpleLongitud("83nedieAGEW", 8, 14));
		assertEquals("  83nedieAGEW 8-11 ->", true, val.cumpleLongitud("83nedieAGEW", 8, 11));
		assertEquals("  83nedieAGEW 11-14 ->", true, val.cumpleLongitud("83nedieAGEW", 11, 14));
		assertEquals("  83nedieAGEW 8-10 ->", false, val.cumpleLongitud("83nedieAGEW", 8, 10));
		assertEquals("  83nedieAGEW 12-14 ->", false, val.cumpleLongitud("83nedieAGEW", 12, 14));
	}

	@Test
	public void testValDateMin() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_MONTH, 3);

		assertEquals("Data mínima f ->", false, Validator.valDateMin(cal1, cal2));
		assertEquals("Data mínima t ->", true, Validator.valDateMin(cal2, cal1));
	}

	@Test
	public void testValDateMax() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_MONTH, 3);

		assertEquals("Data max t ->", true, val.valDateMax(cal1, cal2));
		assertEquals("Data max f ->", false, val.valDateMax(cal2, cal1));
	}

	@Test
	public void testEsFechaValida() {
		assertEquals("CheckFecha 12/02/2013 ->", true, val.esFechaValida("12/02/2013"));
		assertEquals("CheckFecha 31/02/2013 ->", false, val.esFechaValida("31/02/2013"));
		assertEquals("CheckFecha 12/13/2013 ->", false, val.esFechaValida("12/13/2013"));
		assertEquals("CheckFecha 29/02/2013 ->", false, val.esFechaValida("29/02/2013"));
		assertEquals("CheckFecha 29/02/2016 ->", true, val.esFechaValida("29/02/2016"));
		assertEquals("CheckFecha 12/s2/2016 ->", false, val.esFechaValida("12/s2/2016"));
		assertEquals("CheckFecha 12/2/2016 ->", false, val.esFechaValida("12/2/2016"));
		assertEquals("CheckFecha 12-02-2016 ->", false, val.esFechaValida("12-02-2016"));
	}

	@Test
	public void testEsPasswordValida() {
		assertEquals("Contraseña 83nedieAGEW ->", false, val.esPasswordValida("83nedieAGEW"));
		assertEquals("Contraseña 83ne%dieAGEW ->", true, val.esPasswordValida("83ne%dieAGEW"));
		assertEquals("Contraseña nedie%AGEW ->", false, val.esPasswordValida("nedie%AGEW"));
		assertEquals("Contraseña 8ne%eAW ->", false, val.esPasswordValida("8ne%eAW"));
		assertEquals("Contraseña 83nd@#$%ider@#$%rbsE@#$%GEW ->", false,
				val.esPasswordValida("83nd@#$%ider@#$%rbsE@#$%GEW"));
		assertEquals("Contraseña 83ned&ie AGEW ->", false, val.esPasswordValida("83ned&ie AGEW"));
	}

	@Test
	public void testEsCodigoProductoValida() {
		assertEquals("43543", false, val.esCodigoProductoValida("43543"));
		assertEquals("htgre", false, val.esCodigoProductoValida("htgre"));
		assertEquals("SEJYH", false, val.esCodigoProductoValida("SEJYH"));
		assertEquals("GRT56", false, val.esCodigoProductoValida("GRT56"));
		assertEquals("345GE", false, val.esCodigoProductoValida("345GE"));
		assertEquals("SD343", true, val.esCodigoProductoValida("SD343"));
		assertEquals("FE5e5", false, val.esCodigoProductoValida("FE5e5"));
		assertEquals("dfr34", false, val.esCodigoProductoValida("dfr34"));
		assertEquals("GRT5D6", false, val.esCodigoProductoValida("GRT5D6"));
		assertEquals("G5D6", false, val.esCodigoProductoValida("G5D6"));
	}

}
