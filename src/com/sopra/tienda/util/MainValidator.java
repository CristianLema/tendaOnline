package com.sopra.tienda.util;

import java.util.Calendar;

public class MainValidator {

	public static void main(String[] args) {

		System.out.println("Alfanumérico 83nedieAGEW ->" + Validator.isAlfanumeric("83nedieAGEW"));
		System.out.println("Alfanumérico 378sne.38sb ->" + Validator.isAlfanumeric("378sne.38sb"));

		System.out.println();

		System.out.println("Vacio \"\" ->" + Validator.isVacio(""));
		System.out.println("Vacio 4 ->" + Validator.isVacio("4"));

		System.out.println();

		System.out.println("NumTelf 9865345682 ->" + Validator.cumplePhoneNumber("9865345682"));
		System.out.println("NumTelf 586 684 658 654 564 ->" + Validator.cumplePhoneNumber("586 684 658 654 564"));
		System.out.println("NumTelf 5215 354 84 ->" + Validator.cumplePhoneNumber("5215 354 84"));
		System.out.println("NumTelf 153 514 548 ->" + Validator.cumplePhoneNumber("153 514 548"));
		System.out.println("NumTelf 548 584 485d 486d ->" + Validator.cumplePhoneNumber("548 584 485d 486d"));
		System.out.println("NumTelf d48.8483 ->" + Validator.cumplePhoneNumber("d48.8483"));
		System.out.println("NumTelf 985-468-4358-4387 ->" + Validator.cumplePhoneNumber("985-468-4358-4387"));
		System.out.println("NumTelf 6468468646863 468468468 68 6846  684 ->"
				+ Validator.cumplePhoneNumber("6468468646863 468468468 68 6846  684"));

		System.out.println();

		System.out.println("Email osneoi.novwi@nosie.nie ->" + Validator.isEmailValido("osneoi.novwi@nosie.nie"));
		System.out.println("Email .enis@nossi.eg ->" + Validator.isEmailValido(".enis@nossi.eg"));
		System.out.println("Email oiwe.@nhosie.se ->" + Validator.isEmailValido("oiwe.@nhosie.se"));
		System.out.println("Email nbseoi_f@snoe.esg ->" + Validator.isEmailValido("nbseoi_f@snoe.esg"));
		System.out.println(
				"Email sevne.she@nsoe.esae@nsle.sr ->" + Validator.isEmailValido("sevne.she@nsoe.esae@nsle.sr"));
		System.out.println("Email sienvf.sen.snboge@soeigns.er.et ->"
				+ Validator.isEmailValido("sienvf.sen.snboge@soeigns.er.et"));
		System.out.println("Email sienvf.sen.snboge@soeigns.er.et.rr ->"
				+ Validator.isEmailValido("sienvf.sen.snboge@soeigns.er.et.rr"));
		System.out.println("Email nseouv@nso ->" + Validator.isEmailValido("nseouv@nso"));
		System.out.println("Email lsiednv@.sef.es ->" + Validator.isEmailValido("lsiednv@.sef.es"));
		System.out.println("Email nseef-sneof@bhose.et ->" + Validator.isEmailValido("nseef-sneof@bhose.et"));
		System.out.println("Email r.r@r.es ->" + Validator.isEmailValido("r.r@r.es"));
		System.out.println("Email r.r@r.e ->" + Validator.isEmailValido("r.r@r.e"));

		System.out.println();

		System.out.println("DNI 78800772N ->" + Validator.cumpleDNI("78800772N"));
		System.out.println("DNI 78800772-N ->" + Validator.cumpleDNI("78800772-N"));
		System.out.println("DNI 78.800.772-N ->" + Validator.cumpleDNI("78.800.772-N"));
		System.out.println("DNI 78.800.772-n ->" + Validator.cumpleDNI("78.800.772-n"));
		System.out.println("DNI 78.800.772-J ->" + Validator.cumpleDNI("78.800.772-J"));
		System.out.println("DNI 545.548.545-D ->" + Validator.cumpleDNI("545.548.545-D"));
		System.out.println("DNI 54.g548.548-E ->" + Validator.cumpleDNI("54.g548.548-E"));
		System.out.println("DNI 36.546.548-5 ->" + Validator.cumpleDNI("36.546.548-5"));

		System.out.println();

		System.out.println("RangoInt 8-12 9 ->" + Validator.cumpleRango(9, 8, 12));
		System.out.println("RangoInt 8-12 6 ->" + Validator.cumpleRango(6, 8, 12));
		System.out.println("RangoInt 8-12 15 ->" + Validator.cumpleRango(15, 8, 12));
		System.out.println("RangoInt 8-12 8 ->" + Validator.cumpleRango(8, 8, 12));
		System.out.println("RangoInt 8-12 12 ->" + Validator.cumpleRango(12, 8, 12));

		System.out.println();

		System.out.println("RangoDou 8-12 9.0 ->" + Validator.cumpleRango(9.0, 8, 12));
		System.out.println("RangoDou 8-12 9.6 ->" + Validator.cumpleRango(9.6, 8, 12));
		System.out.println("RangoDou 8-12 8.0 ->" + Validator.cumpleRango(8.0, 8, 12));
		System.out.println("RangoDou 8-12 8.3 ->" + Validator.cumpleRango(8.3, 8, 12));
		System.out.println("RangoDou 8-12 12.0 ->" + Validator.cumpleRango(12.0, 8, 12));
		System.out.println("RangoDou 8-12 12.3 ->" + Validator.cumpleRango(12.3, 8, 12));
		System.out.println("RangoDou 8-12 6.0 ->" + Validator.cumpleRango(6.0, 8, 12));
		System.out.println("RangoDou 8-12 15.0 ->" + Validator.cumpleRango(15.0, 8, 12));

		System.out.println();

		System.out.println("Lonxitude mínima 83nedieAGEW 11 ->" + Validator.cumpleLongitudMin("83nedieAGEW", 11));
		System.out.println("Lonxitude mínima 83nedieAGEW 13 ->" + Validator.cumpleLongitudMin("83nedieAGEW", 13));
		System.out.println("Lonxitude mínima 83nedieAGEW 9 ->" + Validator.cumpleLongitudMin("83nedieAGEW", 9));

		System.out.println();

		System.out.println("Lonxitude máxima 83nedieAGEW 11 ->" + Validator.cumpleLongitudMax("83nedieAGEW", 11));
		System.out.println("Lonxitude máxima 83nedieAGEW 13 ->" + Validator.cumpleLongitudMax("83nedieAGEW", 13));
		System.out.println("Lonxitude máxima 83nedieAGEW 9 ->" + Validator.cumpleLongitudMax("83nedieAGEW", 9));

		System.out.println();

		System.out.println("Lonxitude mínima 83nedieAGEW 8-14 ->" + Validator.cumpleLongitud("83nedieAGEW", 8, 14));
		System.out.println("Lonxitude mínima 83nedieAGEW 8-11 ->" + Validator.cumpleLongitud("83nedieAGEW", 8, 11));
		System.out.println("Lonxitude mínima 83nedieAGEW 11-14 ->" + Validator.cumpleLongitud("83nedieAGEW", 11, 14));
		System.out.println("Lonxitude mínima 83nedieAGEW 8-10 ->" + Validator.cumpleLongitud("83nedieAGEW", 8, 10));
		System.out.println("Lonxitude mínima 83nedieAGEW 12-14 ->" + Validator.cumpleLongitud("83nedieAGEW", 12, 14));

		System.out.println();

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_MONTH, 3);
		
		System.out.println("Data mínima f ->" + Validator.valDateMin(cal1, cal2));
		System.out.println("Data mínima t ->" + Validator.valDateMin(cal2, cal1));
		
		System.out.println();
		
		System.out.println("Data máxima t ->" + Validator.valDateMax(cal1, cal2));
		System.out.println("Data máxima f ->" + Validator.valDateMax(cal2, cal1));
		
		System.out.println();
		
		System.out.println("CheckFecha 12/02/2013 ->" + Validator.esFechaValida("12/02/2013"));
		System.out.println("CheckFecha 31/02/2013 ->" + Validator.esFechaValida("31/02/2013"));
		System.out.println("CheckFecha 12/13/2013 ->" + Validator.esFechaValida("12/13/2013"));
		System.out.println("CheckFecha 29/02/2013 ->" + Validator.esFechaValida("29/02/2013"));
		System.out.println("CheckFecha 29/02/2016 ->" + Validator.esFechaValida("29/02/2016"));
		System.out.println("CheckFecha 12/s2/2016 ->" + Validator.esFechaValida("12/s2/2016"));
		System.out.println("CheckFecha 12/2/2016 ->" + Validator.esFechaValida("12/2/2016"));
		System.out.println("CheckFecha 12-02-2016 ->" + Validator.esFechaValida("12-02-2016"));
		
		System.out.println();
		
		System.out.println("Contraseña 83nedieAGEW ->" + Validator.esPasswordValida("83nedieAGEW"));
		System.out.println("Contraseña 83ne%dieAGEW ->" + Validator.esPasswordValida("83ne%dieAGEW"));
		System.out.println("Contraseña nedie%AGEW ->" + Validator.esPasswordValida("nedie%AGEW"));
		System.out.println("Contraseña 8ne%eAW ->" + Validator.esPasswordValida("8ne%eAW"));
		System.out.println("Contraseña 83nd@#$%ider@#$%rbsE@#$%GEW ->" + Validator.esPasswordValida("83nd@#$%ider@#$%rbsE@#$%GEW"));
		System.out.println("Contraseña 83ned&ie AGEW ->" + Validator.esPasswordValida("83ned&ie AGEW"));
		
		
	}

}
