package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
	
	//FAKE LEVEL
	
	
	
	
	//********************TESTS*************************
	
	
	//TESTS FOR FIRST STAGE - BEGINNER LEVEL
	
	@Test
	void testCreateBuscaminas() {
		setupStage();
		assertNotNull(buscaminas.darCasillas());
	}
	
	
	@Test
	void testCountBlankSpaces() {
		setupStage();
		Casilla[][] cas = buscaminas.darCasillas(); 
		
		int totalCas = cas.length*cas[0].length;
		totalCas = totalCas-Buscaminas.CANTIDAD_MINAS_PRINCIPANTE;
		
		int realValue = Buscaminas.FILAS_PRINCIPIANTE * Buscaminas.COLUMNAS_PRINCIPIANTE;
		realValue = realValue-Buscaminas.CANTIDAD_MINAS_PRINCIPANTE;
		
		assertTrue(realValue == totalCas);
	}
	
	@Test
	void testFakeExceptionEasy() {
		setupStage();
		try {
			if(buscaminas.abrirCasilla(Buscaminas.FILAS_INTERMEDIO+1, Buscaminas.COLUMNAS_INTERMEDIO+1)) 
			{fail();}
		} catch (ArrayIndexOutOfBoundsException e2) {
			
		}
		
		
	}
	
	@Test
	void testFakeExceptionEasy1() {
		setupStage();
		try {
			if(buscaminas.abrirCasilla(-20, -324342)) 
			{fail();}
		} catch (ArrayIndexOutOfBoundsException e2) {
			
		}
		
		
	}
	
	@Test
	void testFakeExceptionEasy2() {
		setupStage();
		try {
			if(buscaminas.abrirCasilla(20, -324342)) 
			{fail();}
			
			if(buscaminas.abrirCasilla(-20, 324342)) 
			{fail();}
			
		} catch (ArrayIndexOutOfBoundsException e2) {
			
		}
		
		
	}
	
	@Test
	void testCountMines() {
		setupStage();
		int mines = 0;
		Casilla[][] position=	buscaminas.darCasillas();
		
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < position[0].length; j++) {
				if(position[i][j].esMina()) {
					++mines;
				}
	
			}
		}
		
		assertTrue(mines == Buscaminas.CANTIDAD_MINAS_PRINCIPANTE);
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
	void testCountBlankSpaces1() {
		setupStage1();
		Casilla[][] cas = buscaminas.darCasillas(); 
		
		int totalCas = cas.length*cas[0].length;
		totalCas = totalCas-Buscaminas.CANTIDAD_MINAS_INTERMEDIO;
		
		int realValue = Buscaminas.FILAS_INTERMEDIO * Buscaminas.COLUMNAS_INTERMEDIO;
		realValue = realValue-Buscaminas.CANTIDAD_MINAS_INTERMEDIO;
		
		assertTrue(realValue == totalCas);
	}
	
	@Test
	void testFakeExceptionIntermedium() {
		setupStage1();
		try {
			if(buscaminas.abrirCasilla(20, 300)) {fail();}

			
		} catch (ArrayIndexOutOfBoundsException e2) {
			
		}
		
		
	}
	
	@Test
	void testFakeExceptionIntermedium1() {
		setupStage1();
		try {
			if(buscaminas.abrirCasilla(-20, -300)) {fail();}

			
		} catch (ArrayIndexOutOfBoundsException e2) {
			
		}
		
		
	}
	
	@Test
	void testFakeExceptionIntermedium2() {
		setupStage1();
		try {
			if(buscaminas.abrirCasilla(20, -324342)) 
			{fail();}
			
			if(buscaminas.abrirCasilla(-20, 324342)) 
			{fail();}
			
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
	void testCountBlankSpaces2() {
		setupStage2();
		Casilla[][] cas = buscaminas.darCasillas(); 
		
		int totalCas = cas.length*cas[0].length;
		totalCas = totalCas-Buscaminas.CANTIDAD_MINAS_EXPERTO;
		
		int realValue = Buscaminas.FILAS_EXPERTO * Buscaminas.COLUMNAS_EXPERTO;
		realValue = realValue-Buscaminas.CANTIDAD_MINAS_EXPERTO;
		
		assertTrue(realValue == totalCas);
	}
	
	@Test
	void testFakeExceptionExpert() {
		setupStage2();
		try {
			if(buscaminas.abrirCasilla(20, 300)) {fail();}

			
		} catch (ArrayIndexOutOfBoundsException e2) {
			
		}
		
		
	}
	
	@Test
	void testFakeExceptionExpert1() {
		setupStage2();
		try {
			if(buscaminas.abrirCasilla(-20, -300)) {fail();}

			
		} catch (ArrayIndexOutOfBoundsException e2) {
			
		}
		
		
	}
	
	@Test
	void testFakeExceptionExpert2() {
		setupStage2();
		try {
			if(buscaminas.abrirCasilla(20, -324342)) 
			{fail();}
			
			if(buscaminas.abrirCasilla(-20, 324342)) 
			{fail();}
			
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


}
