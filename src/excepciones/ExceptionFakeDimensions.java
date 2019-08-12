/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Propuesta de soluci�n laboratorio Unidad 5
 * @author Gonzalo De Varona - gonzalo.de1@correo.icesi.edu.co
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package excepciones;

public class ExceptionFakeDimensions extends Exception {
	
	public ExceptionFakeDimensions(){
		super("ERROR: Non-existent position.");
		
	}

}
