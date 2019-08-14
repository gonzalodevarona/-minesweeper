/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Propuesta de soluci�n laboratorio Unidad 5
 * @author Camilo Barrios - camilo.barrios@correo.icesi.edu.co
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */


package modelo;

import excepciones.ExceptionFakeDimensions;

public class Buscaminas {


	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Es una constante utilizada para indicar la cantidad de filas en el nivel principiante
	 */
	public static final int FILAS_PRINCIPIANTE = 8;

	/**
	 * Es una constante utilizada para indicar la cantidad de filas en el nivel intermedio
	 */
	public static final int FILAS_INTERMEDIO = 16;

	/**
	 * Es una constante utilizada para indicar la cantidad de filas en el nivel experto
	 */
	public static final int FILAS_EXPERTO = 16;

	/**
	 * Es una constante utilizada para indicar la cantidad de columnas en el nivel principiante
	 */
	public static final int COLUMNAS_PRINCIPIANTE = 8;

	/**
	 * Es una constante utilizada para indicar la cantidad de columnas en el nivel intermedio
	 */
	public static final int COLUMNAS_INTERMEDIO = 16;

	/**
	 * Es una constante utilizada para indicar la cantidad de columnas en el nivel experto
	 */
	public static final int COLUMNAS_EXPERTO = 30;

	/**
	 * Es una constante utilizada para saber la dificultad del juego, representa el nivel principiante
	 */
	public static final int PRINCIPIANTE = 1;

	/**
	 * Es una constante utilizada para saber la dificultad del juego, representa el nivel intermedio
	 */
	public static final int INTERMEDIO = 2;

	/**
	 * Es una constante utilizada para saber la dificultad del juego, representa el nivel experto
	 */
	public static final int EXPERTO = 3;

	/**
	 * Es una constante utilizada para saber la cantidad de minas en nivel principiante
	 */
	public static final int CANTIDAD_MINAS_PRINCIPANTE = 10;

	/**
	 * Es una constante utilizada para saber la cantidad de minas en nivel intermedio
	 */
	public static final int CANTIDAD_MINAS_INTERMEDIO = 40;

	/**
	 * Es una constante utilizada para saber la cantidad de minas en nivel experto
	 */
	public static final int CANTIDAD_MINAS_EXPERTO = 99;

	
	
	
	// -----------------------------------------------------------------
	// Atributos y relaciones
	// -----------------------------------------------------------------

	/**
	 * Relacion que tiene la matriz de casillas
	 */
	private Casilla[][] casillas;

	/**
	 * Atributo que representa el nivel del juego <Solo puede tomar valores PRINCIPIANTE, INTERMEDIO, EXPERTO>
	 */
	private int nivel;

	/**
	 * Atributo que tiene la cantidad de minas en el tablero
	 */
	private int cantidadMinas;

	/**
	 * Atributo que representa si el usuario perdio al abrir una mina
	 */
	private boolean perdio;

	
	
	
	
	
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructo de la clase Buscaminas
	 * @param nivel - el nivel seleccionado por el usuario
	 */
	public Buscaminas(int nivel) {
		this.nivel = nivel;
		perdio = false;
		inicializarPartida();

	}


	
	
	
	
	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------

	/**
	 * Se encarga de inicializar los atributos y relaciones de la clase buscaminas a partir del nivel elegido por el usuario
	 */
	private void inicializarPartida() {

		switch (nivel) {
		case PRINCIPIANTE:
			cantidadMinas = CANTIDAD_MINAS_PRINCIPANTE;
			casillas = new Casilla[FILAS_PRINCIPIANTE][COLUMNAS_PRINCIPIANTE];
			
			break;
		
		case INTERMEDIO:
			cantidadMinas = CANTIDAD_MINAS_INTERMEDIO;
			casillas = new Casilla[FILAS_INTERMEDIO][COLUMNAS_INTERMEDIO];
			
			break;
			
		case EXPERTO:
			cantidadMinas = CANTIDAD_MINAS_EXPERTO;
			casillas = new Casilla[FILAS_EXPERTO][COLUMNAS_EXPERTO];
			
			break;

		default:
			break;
		}
		
		
		generarMinas();
		inicializarCasillasLibres();
		
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[0].length; j++) {
				casillas[i][j].modificarValor(cantidadMinasAlrededor(i,j));
			}
		}
		
		mostrarTablero();
		

	}


	/**
	 * Metodo que se encarga de inicializar todas las casillas que no son minas
	 */
	public void inicializarCasillasLibres() {

		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[0].length; j++) {
				if(casillas[i][j] == null) {
					casillas[i][j] = new Casilla(Casilla.LIBRE);
				
				}
			}
		}

	}


	/**
	 * Metodo que permite contar la cantidad de minas que tiene alrededor una casillas
	 * @param i - La fila de la matriz
	 * @param j - la columna de la matriz
	 * @return int - La cantidad de minas que tiene alrededor la casilla [i][j]
	 */
	public int cantidadMinasAlrededor(int i, int j) {
		
		int minas = 0;
		
		int finalColumnas = (casillas[0].length)-1;
		
		if (casillas[i][j].esMina() == false) {
			
		
		
			if(i == 0|| i == (casillas.length-1) || j == 0 || j == finalColumnas) {
	
				if(i == 0 ) {
					
					if (j ==0) {
						if (casillas[i+1][j+1].esMina()) {
							++minas;
						}
						if (casillas[i][j+1].esMina()) {
							++minas;
						}
						if (casillas[i+1][j].esMina()) {
							++minas;
						}
					}
					
					else if (j == finalColumnas) {
						
						if (casillas[i+1][j-1].esMina()) {
							++minas;
						}
						if (casillas[i][j-1].esMina()) {
							++minas;
						}
						if (casillas[i+1][j].esMina()) {
							++minas;
						}
					} else if(j>0 && j<finalColumnas) {
						if (casillas[i][j+1].esMina()) {
							++minas;
						}
						if (casillas[i][j-1].esMina()) {
							++minas;
						}
						if (casillas[i+1][j].esMina()) {
							++minas;
						}
						if (casillas[i+1][j+1].esMina()) {
							++minas;
						}
						if (casillas[i+1][j-1].esMina()) {
							++minas;
						}
					}
					
					
				} else if (i == (casillas.length-1)) {
					
					if (j ==0) {
						
						if (casillas[i][j+1].esMina()) {
							++minas;
						}
						if (casillas[i-1][j].esMina()) {
							++minas;
						}
						if (casillas[i-1][j+1].esMina()) {
							++minas;
						}
						
					}else if (j == finalColumnas) {
						if (casillas[i-1][j].esMina()) {
							++minas;
						}
						if (casillas[i][j-1].esMina()) {
							++minas;
						}
						if (casillas[i-1][j-1].esMina()) {
							++minas;
						}
						
					} else if(j>0 && j<finalColumnas) {
						if (casillas[i-1][j].esMina()) {
							++minas;
						}
						if (casillas[i][j+1].esMina()) {
							++minas;
						}
						if (casillas[i][j-1].esMina()) {
							++minas;
						}
						if (casillas[i-1][j+1].esMina()) {
							++minas;
						}
						if (casillas[i-1][j-1].esMina()) {
							++minas;
						}
					}
				}
				
				if(j == 0 ) {
					if(i>0 && i<(casillas.length-1)) {
						if (casillas[i+1][j].esMina()) {
							++minas;
						}
						if (casillas[i-1][j].esMina()) {
							++minas;
						}
						if (casillas[i][j+1].esMina()) {
							++minas;
						}
						if (casillas[i+1][j+1].esMina()) {
							++minas;
						}
						if (casillas[i-1][j+1].esMina()) {
							++minas;
						}
					}
			
				} else if (j == finalColumnas) {
					if(i>0 && i<(casillas.length-1)) {
						if (casillas[i-1][j].esMina()) {
							++minas;
						}
						if (casillas[i+1][j].esMina()) {
							++minas;
						}
						if (casillas[i][j-1].esMina()) {
							++minas;
						}
						if (casillas[i+1][j-1].esMina()) {
							++minas;
						}
						if (casillas[i-1][j-1].esMina()) {
							++minas;
						}			
					}
					
				}
			
			} else {
				
				minas = minasFueraDeMarco(i,j);
			}
		}

		return minas;
	}
	
	/**
	 * Metodo que permite contar la cantidad de minas que tiene alrededor una casilla la cual limiteDeLasFilas>i>0 y limiteDeLasColumnas>j>0
	 * @param i - La fila de la matriz
	 * @param j - la columna de la matriz
	 * @return int - La cantidad de minas que tiene alrededor la casilla [i][j]
	 */

	public int minasFueraDeMarco(int i, int j) {
		int minas = 0;
		
		if (casillas[i-1][j].esMina()) {
			++minas;
		}
		
		if (casillas[i+1][j].esMina()) {
			++minas;
		}
		
		if (casillas[i][j-1].esMina()) {
			++minas;
		}
		
		if (casillas[i][j+1].esMina()) {
			++minas;
		}  
		
		if (casillas[i-1][j+1].esMina()) {
			++minas;
		}
		
		if (casillas[i+1][j-1].esMina()) {
			++minas;
		}
		
		if (casillas[i+1][j+1].esMina()) {
			++minas;
		}
		
		if (casillas[i-1][j-1].esMina()) {
			++minas;
		}
		
		return minas;
	}
	
	
	
	
	
	

	/**
	 * M�todo que se encarga de generar aleatoriomente las minas
	 */
	public void generarMinas() {
		int x = 0;
		int y = 0;
		
		for (int i = 1; i <= cantidadMinas; ++i) {
			x = (int)(Math.random() * casillas.length) ;
			y =(int) (Math.random() * casillas[0].length);
			if(casillas[x][y] != null && casillas[x][y].esMina()) {
				i = i-1;
			}else {
				casillas[x][y] = new Casilla(Casilla.MINA);
				
			}
			
			
		}
		
		
	}


	/**
	 * Metodo que se encarga de convertir el tablero a un String para poder verlo en pantalla
	 * @return String - El tablero en formato String
	 */
	public String mostrarTablero() {

		String tablero = "   ";
		
		
		
		for (int i = 1; i <= casillas[0].length; i++) {
			tablero += i+" ";
		}
		tablero += " \n \n";
		
		for (int j = 1; j <= casillas.length; j++) {
			
			if (j>9) {
				tablero += j+" ";
			} else {
				tablero += j+"  ";
			}
	
				for (int l = 0; l < casillas[0].length; l++) {
					tablero += casillas[j-1][l].mostrarValorCasilla();
					if (l>=9) {
						tablero +="  ";
					} else {
						tablero +=" ";
					}
					
				}
				
			
			tablero += "\n";
		}
		
		
		return tablero;
	}


	/**
	 * Metodo que se encarga de marcar todas las casillas como destapadas
	 */
	public void resolver() {

		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[0].length; j++) {
				casillas[i][j].destapar();
			}
		}
		
		mostrarTablero();

	}

	/**
	 * Metodo dar del atributo casillas
	 * @return la relacion casillas
	 */
	public Casilla[][] darCasillas(){
		return casillas;
	}


	/**
	 * Este metodo se encargaa de abrir una casilla
	 * Si se abre una casilla de tipo Mina, se marca que el jugador perdio el juego.
	 * @param i - la fila donde esta la casilla 
	 * @param j - la columna donde esta la casilla
	 * @return boolean - true si fue posible destaparla, false en caso contrario
	 */
	public boolean abrirCasilla(int i, int j) throws ExceptionFakeDimensions{
		boolean sePudo = false;
		try {
			if (i <=casillas.length && j<=casillas[0].length) {
				
				if (casillas[i][j].darSeleccionada() == false) {
					
					if (casillas[i][j].esMina()) {
						
						casillas[i][j].destapar();
						perdio = true;
						sePudo = true;
						
					} else {
						casillas[i][j].destapar();
						sePudo = true;
					}
					
					
				} 
			} else {
				throw new ExceptionFakeDimensions();
			}
			
		} catch (ArrayIndexOutOfBoundsException  e) {
			
		}
		
		
	
		return sePudo;
	}
	


	/**
	 * Metodo que se encarga de revisar si el jugador gano el juego
	 * @return boolean - true si gano el juego, false en caso contrario
	 */
	public boolean gano() {
		boolean gano = false;
		
		
		return gano;
	}


	/**
	 * Metodo que se encarga de abrir la primera casilla que no sea una Mina y cuyo valor sea Mayor que 0
	 * @return String, Mensaje de la Casilla que marco abierta, En caso de no haber casillas posibles para dar una pista, retorna el mensaje no hay pistas para dar
	 */
	public String darPista() {
		String pista = "No hay pista para dar";
		boolean stop = false; 
		
		for (int i = 0; i < casillas.length && !stop ; i++) {
			for (int j = 0; j < casillas[0].length && !stop; j++) {
				if (casillas[i][j].darSeleccionada() == false && casillas[i][j].esMina() == false && casillas[i][j].darValor() > 0) {
					
					pista = "La casilla destapada tiene coordenadas: ("+ (i+1) +","+ (j+1) +") \n";
					casillas[i][j].destapar();
					stop = true;
					
				} 
			}
		}
		
		return pista;
	}
	
	/***
	 * Metodo dar del atributo perdio
	 * @return boolean el atributo
	 */
	public boolean darPerdio(){
		return perdio;
	}

}