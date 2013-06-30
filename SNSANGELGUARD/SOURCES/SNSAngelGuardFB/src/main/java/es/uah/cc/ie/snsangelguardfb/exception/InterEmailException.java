/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.exception;

/**
 * Clase que controla las excepciones que se producen al enviar emails.
 * 
 * @author josejavierblecuadepedro
 */
public class InterEmailException extends GenericException{

    /**
     * Constructor de clase.
     * 
     * @param e
     * @param messageException 
     */
    public InterEmailException(Exception e, CodeException messageException) {
        super(e, messageException);
    }
    
}
