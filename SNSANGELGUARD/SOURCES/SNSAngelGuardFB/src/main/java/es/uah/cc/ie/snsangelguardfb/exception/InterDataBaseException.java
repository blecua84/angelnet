/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.exception;

/**
 * Clase que controla las excepciones producidas por accesos a base de datos.
 * 
 * @author josejavierblecuadepedro
 */
public class InterDataBaseException extends GenericException {

    /** Constructor de clase */
    public InterDataBaseException(Exception e, CodeException messageException) {
        super(e,messageException);
    }
    
}
