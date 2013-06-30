/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.exception;

/**
 * Clase generica que representa a todas las excepciones que pueden darse en el sistema.
 * 
 * @author josejavierblecuadepedro
 */
public abstract class GenericException extends Exception{
    
    /** Excepcion capturada  */
    private Exception exception;
    
    /** Codigo de la excepcion capturada */
    private CodeException messageException;
    
    /**
     * Obtiene la excepcion que ha desencadenado la parada de la aplicacion.
     * 
     * @return Exception
     */
    public Exception getException() {
        return exception;
    }
      
    /**
     * Obtiene el mensaje generado al analizar la Excepcion.
     * 
     * @return CodeException 
     */
    public CodeException getMessageException() {
        return messageException;
    }
    
    /**
     * Constructor de clase.
     * 
     * @param e
     * @param messageException 
     */
    public GenericException(Exception e, CodeException messageException){
        this.exception = e;
        this.messageException = messageException;
    }
}
