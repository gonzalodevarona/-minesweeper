/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Propuesta de soluci�n laboratorio Unidad 5
 * @author Gonzalo De Varona - gonzalo.de1@correo.icesi.edu.co
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package test;


import org.junit.jupiter.api.Test;


import modelo.*;

class TestCasilla {
	
	Casilla casilla;
	
	
	
	//MINE
	public void setupStage() {
		casilla = new Casilla(Casilla.MINA); 
	}

	//NOT A MINE
	public void setupStage1() {
		casilla = new Casilla(Casilla.LIBRE); 
	}
	
	
	
	//TESTS WHEN IT IS A MINE
	
	@Test
	void testEsMina() {
		setupStage();
		casilla.esMina();
	}
	
	
	@Test
	void testMostrarValorCasilla() {
		setupStage();
		casilla.mostrarValorCasilla();
	}
	
	//TESTS IT IS NOT A MINE
	
	@Test
	void testEsMina1() {
		setupStage1();
		casilla.esMina();
	}
	
	@Test
	void testMostrarValorCasilla1() {
		setupStage1();
		casilla.mostrarValorCasilla();
	}

} //end of class
