/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.exception;

/**
 * Clase que controla todas las excepciones producidas por operaciones de proceso generales.
 * 
 * @author josejavierblecuadepedro
 */
public class InterProcessException extends GenericException{

    /**
     * Constructor de clase.
     * 
     * @param e
     * @param messageException 
     */
    public InterProcessException(Exception e, CodeException messageException) {
        super(e, messageException);
    }
    
}
