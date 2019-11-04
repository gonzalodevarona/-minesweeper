/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Propuesta de soluci�n laboratorio Unidad 5
 * @author Gonzalo De Varona - gonzalo.de1@correo.icesi.edu.co
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package model;


import static org.junit.jupiter.api.Assertions.*;

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
	void testConstructor() {
		setupStage();
		if (casilla.esMina() && casilla.darSeleccionada()==false && casilla.darValor() == -1) {
			System.out.println(casilla.mostrarValorCasilla());
		} else {
			fail();
		}
		
	}
	
	@Test
	void testModificarValor() {
		setupStage();
		int valor = (int) Math.random()*100;
		casilla.modificarValor(valor);
		
		if (casilla.darValor() == valor) {
			
		} else {
			fail();
		}
		
	}
	
	@Test
	void testEsMina() {
		setupStage();
		
		if (casilla.esMina()) {
					
		} else {
			fail();
		}
	}
	
	
	@Test
	void testMostrarValorCasilla() {
		setupStage();
		
		if (casilla.mostrarValorCasilla().equals("-")) {
			
		} else {
			fail();
		}
		casilla.destapar();
		if (casilla.mostrarValorCasilla().equals("*")) {
			
		} else {
			fail();
		}
	}
	
	@Test
	void testDestapar() {
		setupStage();
		casilla.destapar();
		if (casilla.darSeleccionada() ) {
			
		} else {
			fail();
		}
	}
	
	
	
	
	
	//TESTS IT IS NOT A MINE
	
	@Test
	void testConstructor1() {
		setupStage1();
		if (casilla.esMina()== false && casilla.darSeleccionada()==false && casilla.darValor() == -1) {
			
		} else {
			fail();
		}
		
	}
	
	@Test
	void testModificarValor1() {
		setupStage1();
		int valor = (int) Math.random()*100;
		casilla.modificarValor(valor);
		
		if (casilla.darValor() == valor) {
			
		} else {
			fail();
		}
		
	}
	
	@Test
	void testEsMina1() {
		setupStage1();
		if (casilla.esMina() == false) {
			
		} else {
			fail();
		}
	}
	
	@Test
	void testDestapar1() {
		setupStage1();
		casilla.destapar();
		if (casilla.darSeleccionada() ) {
			
		} else {
			fail();
		}
	}
	
	@Test
	void testMostrarValorCasilla1() {
		setupStage1();
		
		if (casilla.mostrarValorCasilla().equals("-")) {
			
		} else {
			fail();
		}
		casilla.destapar();
		if (Integer.parseInt(casilla.mostrarValorCasilla()) ==   casilla.darValor()) {
			
		} else {
			fail();
		}
	}

} //end of class
