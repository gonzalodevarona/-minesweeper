/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Propuesta de soluci�n laboratorio Unidad 5
 * @author Gonzalo De Varona - gonzalo.de1@correo.icesi.edu.co
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */


package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import excepciones.ExceptionFakeDimensions;
import modelo.Buscaminas;
import modelo.Casilla;

class TestBuscaminas {
	
	Buscaminas buscaminas;
	
	
	
	//BEGINNER LEVEL 
	
	public void setupStage() {
		buscaminas= new Buscaminas(Buscaminas.PRINCIPIANTE);	
	}
	
	//INTERMEDIUM LEVEL
	
	public void setupStage1() {
		buscaminas= new Buscaminas(Buscaminas.INTERMEDIO);	
	}
	
	//EXPERT LEVEL
	
	public void setupStage2() {
		buscaminas= new Buscaminas(Buscaminas.EXPERTO);	
	}
		
	
	
	
	//********************TESTS*************************
	
	
	//TESTS FOR FIRST STAGE - BEGINNER LEVEL
	
	@Test
	void testCreateBuscaminas() {
		setupStage();
		assertNotNull(buscaminas.darCasillas());
	}
	
	@Test
	void testFakeException() {
		setupStage();
		try {
			buscaminas.abrirCasilla(Buscaminas.FILAS_INTERMEDIO+1, -4);
			fail();
		} catch (ExceptionFakeDimensions e) {
			
		} catch (ArrayIndexOutOfBoundsException e2) {
			
		}
		
		
	}
	
	@Test
	void testSolve() {
		setupStage();
		int many =0;
		Casilla[][] position=	buscaminas.darCasillas();
		buscaminas.resolver();
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < position[0].length; j++) {
				if(position[i][j].darSeleccionada()) {
					++many;
				}
			
				
			}
		}
		
		assertTrue(many == (position.length*position[0].length));
	}

	
	
	//TESTS FOR SECOND STAGE - INTERMEDIUM LEVEL
	
	@Test
	void testCreateBuscaminas1() {
		setupStage1();
		assertNotNull(buscaminas.darCasillas());
	}
	
	@Test
	void testFakeException1() {
		setupStage1();
		try {
			buscaminas.abrirCasilla(-1, 86);
			fail();
		} catch (ExceptionFakeDimensions e) {
			
		} catch (ArrayIndexOutOfBoundsException e2) {
			
		}
		
		
	}
	
	@Test
	void testCountMines1() {
		setupStage1();
		int mines = 0;
		Casilla[][] position=	buscaminas.darCasillas();
		
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < position[0].length; j++) {
				if(position[i][j].esMina()) {
					++mines;
				}
			
				
			}
		}
		System.out.println(mines);
		System.out.println(Buscaminas.CANTIDAD_MINAS_INTERMEDIO);
		
		System.out.println("------");
		
		assertTrue(mines == Buscaminas.CANTIDAD_MINAS_INTERMEDIO);
	}
	
	@Test
	void testSolve1() {
		setupStage1();
		int many =0;
		Casilla[][] position=	buscaminas.darCasillas();
		buscaminas.resolver();
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < position[0].length; j++) {
				if(position[i][j].darSeleccionada()) {
					++many;
				}
			
				
			}
		}
		
		assertTrue(many == (position.length*position[0].length));
	}

	
	//TESTS FOR THIRD STAGE - EXPERT LEVEL
	@Test
	void testCreateBuscaminas2() {
		setupStage2();
		assertNotNull(buscaminas.darCasillas());
	}
	
	@Test
	void testFakeException2() {
		setupStage2();
		try {
			buscaminas.abrirCasilla(89, -349);
			fail();
		} catch (ExceptionFakeDimensions e) {
			
		} catch (ArrayIndexOutOfBoundsException e2) {
			
		}
		
		
	}
	
	
	@Test
	void testCountMines2() {
		setupStage2();
		int mines = 0;
		Casilla[][] position=	buscaminas.darCasillas();
		
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < position[0].length; j++) {
				if(position[i][j].esMina()) {
					++mines;
				}
			
				
			}
		}
		System.out.println(mines);
		System.out.println(Buscaminas.CANTIDAD_MINAS_EXPERTO);
		
		assertTrue(mines == Buscaminas.CANTIDAD_MINAS_EXPERTO);
	}
	
	@Test
	void testSolve2() {
		setupStage2();
		int many =0;
		Casilla[][] position=	buscaminas.darCasillas();
		buscaminas.resolver();
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < position[0].length; j++) {
				if(position[i][j].darSeleccionada()) {
					++many;
				}
			
				
			}
		}
		
		assertTrue(many == (position.length*position[0].length));
	}

} //end of class
