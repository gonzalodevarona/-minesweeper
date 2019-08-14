/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Propuesta de soluci�n laboratorio Unidad 5
 * @author Gonzalo De Varona - gonzalo.de1@correo.icesi.edu.co
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package excepciones;

public class ExceptionInvalidChoice extends Exception {
	
	public ExceptionInvalidChoice(int x){
		super("ERROR: "+x+" is an invalid choice.");
		
	}

	
}
