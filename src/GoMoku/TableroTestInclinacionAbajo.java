package GoMoku;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TableroTestInclinacionAbajo {

	@Test
	void inclinaciónFichaX() {
		String[][] comprobar = {
				{ "  ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o" },
				{ "01", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "02", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "03", ".", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "04", ".", ".", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "05", ".", ".", ".", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "06", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "07", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "08", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "09", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "10", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "11", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "12", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "13", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "14", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "15", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." } };
		boolean resultado=Tablero.inclinacionAbajoText(ficha.x, comprobar);
		Assert.assertTrue(resultado);
		
	}
	@Test
	void inclinaciónFichaO() {
		String[][] comprobar = {
				{ "  ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o" },
				{ "01", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "02", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "03", ".", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "04", ".", ".", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "05", ".", ".", ".", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "06", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "07", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "08", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "09", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "10", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "11", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "12", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "13", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "14", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "15", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." } };
		boolean resultado=Tablero.inclinacionAbajoText(ficha.o, comprobar);
		Assert.assertTrue(resultado);
		
	}
	@Test
	void inclinación1FichaX() {
		String[][] comprobar = {
				{ "  ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o" },
				{ "01", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "02", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "03", ".", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "04", ".", ".", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "05", ".", ".", ".", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "06", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "07", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "08", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "09", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "10", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "11", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "12", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "13", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "14", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "15", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." } };
		boolean resultado=Tablero.inclinacionAbajoText(ficha.x, comprobar);
		Assert.assertFalse(resultado);
		
	}
	@Test
	void inclinación1FichaO() {
		String[][] comprobar = {
				{ "  ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o" },
				{ "01", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "02", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "03", ".", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "04", ".", ".", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "05", ".", ".", ".", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "06", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "07", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "08", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "09", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "10", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "11", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "12", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "13", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "14", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "15", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." } };
		boolean resultado=Tablero.inclinacionAbajoText(ficha.o, comprobar);
		Assert.assertFalse(resultado);
		
	}
	@Test
	void inclinación2FichaX() {
		String[][] comprobar = {
				{ "  ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o" },
				{ "01", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "02", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "03", ".", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "04", ".", ".", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "05", ".", ".", ".", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "06", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "07", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "08", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "09", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "10", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "11", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "12", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "13", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "14", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "15", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." } };
		boolean resultado=Tablero.inclinacionAbajoText(ficha.x, comprobar);
		Assert.assertFalse(resultado);
		
	}
	@Test
	void inclinación2FichaO() {
		String[][] comprobar = {
				{ "  ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o" },
				{ "01", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "02", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "03", ".", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "04", ".", ".", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "05", ".", ".", ".", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "06", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "07", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "08", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "09", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "10", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "11", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "12", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "13", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "14", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "15", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." } };
		boolean resultado=Tablero.inclinacionArribaText(ficha.o, comprobar);
		Assert.assertFalse(resultado);
		
	}
	@Test
	void inclinación3FichaX() {
		String[][] comprobar = {
				{ "  ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o" },
				{ "01", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "02", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "03", ".", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "04", ".", ".", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "05", ".", ".", ".", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "06", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "07", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "08", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "09", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "10", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "11", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "12", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "13", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "14", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "15", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." } };
		boolean resultado=Tablero.inclinacionArribaText(ficha.x, comprobar);
		Assert.assertFalse(resultado);
		
	}
	@Test
	void inclinación3FichaO() {
		String[][] comprobar = {
				{ "  ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o" },
				{ "01", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "02", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "03", ".", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "04", ".", ".", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "05", ".", ".", ".", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "06", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "07", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "08", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "09", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "10", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "11", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "12", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "13", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "14", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "15", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." } };
		boolean resultado=Tablero.inclinacionAbajoText(ficha.o, comprobar);
		Assert.assertFalse(resultado);
		
	}
	@Test
	void inclinación4FichaX() {
		String[][] comprobar = {
				{ "  ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o" },
				{ "01", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "02", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "03", ".", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "04", ".", ".", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "05", ".", ".", ".", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "06", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "07", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "08", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "09", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "10", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "11", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "12", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "13", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "14", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "15", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." } };
		boolean resultado=Tablero.inclinacionAbajoText(ficha.x, comprobar);
		Assert.assertFalse(resultado);
		
	}
	@Test
	void inclinación4FichaO() {
		String[][] comprobar = {
				{ "  ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o" },
				{ "01", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "02", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "03", ".", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "04", ".", ".", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "05", ".", ".", ".", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "06", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "07", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "08", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "09", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "10", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "11", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "12", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "13", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "14", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "15", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." } };
		boolean resultado=Tablero.inclinacionAbajoText(ficha.o, comprobar);
		Assert.assertFalse(resultado);
		
	}
	@Test
	void inclinación5FichaX() {
		String[][] comprobar = {
				{ "  ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o" },
				{ "01", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "02", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "03", ".", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "04", ".", ".", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "05", ".", ".", ".", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "06", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "07", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "08", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "09", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "10", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "11", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "12", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "13", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "14", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "15", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." } };
		boolean resultado=Tablero.inclinacionAbajoText(ficha.x, comprobar);
		Assert.assertFalse(resultado);
		
	}
	@Test
	void inclinación5FichaO() {
		String[][] comprobar = {
				{ "  ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o" },
				{ "01", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "02", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "03", ".", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "04", ".", ".", ".", "o", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "05", ".", ".", ".", ".", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "06", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "07", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "08", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "09", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "10", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "11", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "12", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "13", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "14", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ "15", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." } };
		boolean resultado=Tablero.inclinacionAbajoText(ficha.o, comprobar);
		Assert.assertFalse(resultado);
		
	}

}
