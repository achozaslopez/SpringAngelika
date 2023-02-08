package es.rf.tienda.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ValidatorTest {

	static final String TEXTO_CORRECTO = "3st03sUnT3xt0C0rr3ct0";
	static final String TEXTO_INCORRECTO = "3st0 3s un t3xt0 inc0rr3ct0";
	
	static final String PHONE_MENOSDE10_DIGITOS = "1 2 3 4 5 6";
	static final String PHONE_CORRECTO = "0 1 2 3 4 5 6 7 8 9 ";
	static final String PHONE_LARGO = " 0 1 2 3 4 5 6 7 8 9 ";
	static final String PHONE_VACIO = "           ";
	
	static final String EMAIL_CORRECTO = "google@gmail.com";
	static final String EMAIL_INCORRECTO = "@@.com.google";
	
	static final String DNI_CORRECTO_MAYUS = "12.121.212-M";
	static final String DNI_INCORRECTO_MINUS = "12.121.212-m";
	static final String DNI_LETRA_INCORRECTA = "12.121.212-S";
	static final String DNI_FORMATO_INCORRECTO = "12121212M";
	
	static final double VALOR = 1.1;
	static final double VALOR_ERR = 0.5;
	static final int VALOR_MINIMO = 1;
	static final int VALOR_MAXIMO = 2;
	
	static final String TEXTO = "Puede que me cumpla o puede que no";
	static final int LONGITUD_MINIMA = 10;
	static final int LONGITUD_MINIMA_ERR = 35;
	static final int LONGITUD_MAXIMA = 40;
	static final int LONGITUD_MAXIMA_ERR = 20;
	
	static final LocalDate FECHA = LocalDate.now();
	static final LocalDate FECHA_MAYOR = LocalDate.now().plusYears(3);
	static final LocalDate FECHA_MENOR = LocalDate.now().minusYears(3);
	static final LocalDate FECHA_PARSE = LocalDate.parse("1990-10-25");
	static final LocalDate FECHA_OF = LocalDate.of(1993, 05, 28);
	
	static final String FECHA_VALIDA = "28/01/2023";
	static final String FECHA_NO_VALIDA = "28-01-2023";
	
	static final String PASSWORD_VALIDA = "Acc3ntur3#";
	static final String PASSWORD_NO_VALIDA = "Accenture3";

	@Test
	void testIsAlfanumeric() {
		assertTrue(Validator.isAlfanumeric(TEXTO_CORRECTO));
		assertFalse(Validator.isAlfanumeric(TEXTO_INCORRECTO));
	}
	
	@Disabled
	void testIsVacio() {
		
	}

	@Test
	void testCumplePhoneNumber() {
		assertTrue(Validator.cumplePhoneNumber(PHONE_CORRECTO));
		assertFalse(Validator.cumplePhoneNumber(PHONE_MENOSDE10_DIGITOS));
		assertFalse(Validator.cumplePhoneNumber(PHONE_LARGO));
		assertFalse(Validator.cumplePhoneNumber(PHONE_VACIO));
	}

	@Test
	void testIsEmailValido() {
		assertTrue(Validator.isEmailValido(EMAIL_CORRECTO));
		assertFalse(Validator.isEmailValido(EMAIL_INCORRECTO));
	}

	@Test
	void testCumpleDNI() {
		assertTrue(Validator.cumpleDNI(DNI_CORRECTO_MAYUS));
		assertFalse(Validator.cumpleDNI(DNI_INCORRECTO_MINUS));
		assertFalse(Validator.cumpleDNI(DNI_LETRA_INCORRECTA));
		assertFalse(Validator.cumpleDNI(DNI_FORMATO_INCORRECTO));
	}

	@Test
	void testCumpleRango() {
		assertTrue(Validator.cumpleRango(VALOR, VALOR_MINIMO, VALOR_MAXIMO));
		assertFalse(Validator.cumpleRango(VALOR_ERR, VALOR_MINIMO, VALOR_MAXIMO));
	}

	@Test
	void testCumpleLongitudMin() {
		assertTrue(Validator.cumpleLongitudMin(TEXTO, LONGITUD_MINIMA));
		assertFalse(Validator.cumpleLongitudMin(TEXTO, LONGITUD_MINIMA_ERR));
	}

	@Test
	void testCumpleLongitudMax() {
		assertTrue(Validator.cumpleLongitudMax(TEXTO, LONGITUD_MAXIMA));
		assertFalse(Validator.cumpleLongitudMax(TEXTO, LONGITUD_MAXIMA_ERR));
	}

	@Test
	void testCumpleLongitud() {
		assertTrue(Validator.cumpleLongitud(TEXTO, LONGITUD_MINIMA, LONGITUD_MAXIMA));
		assertFalse(Validator.cumpleLongitud(TEXTO, LONGITUD_MINIMA, LONGITUD_MAXIMA_ERR));
	}

	@Test
	void testValDateMin() {
		assertTrue(Validator.valDateMin(FECHA, FECHA_MENOR));
		assertFalse(Validator.valDateMin(FECHA, FECHA_MAYOR));
	}

	@Test
	void testValDateMax() {
		assertTrue(Validator.valDateMax(FECHA_PARSE, FECHA_OF));
		assertFalse(Validator.valDateMax(FECHA_OF, FECHA_PARSE));
	}

	@Test
	void testEsFechaValida() {
		assertTrue(Validator.esFechaValida(FECHA_VALIDA));
		assertFalse(Validator.esFechaValida(FECHA_NO_VALIDA));
	}

	@Test
	void testEsPasswordValida() {
		assertTrue(Validator.esPasswordValida(PASSWORD_VALIDA));
		assertFalse(Validator.esPasswordValida(PASSWORD_NO_VALIDA));
	}
}