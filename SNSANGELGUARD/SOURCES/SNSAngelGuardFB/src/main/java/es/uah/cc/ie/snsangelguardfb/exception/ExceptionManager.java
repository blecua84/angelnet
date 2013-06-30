/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.exception;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.sun.jersey.api.client.UniformInterfaceException;
import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchProviderException;
import javax.mail.MessagingException;
import org.codehaus.jettison.json.JSONException;

/**
 * Clase que maneja los erroes que se producen en la aplicacion.
 * 
 * @author josejavierblecuadepedro
 */
public class ExceptionManager {
    private SNSAngelGuardFBManager snsManager;
    
    private CodeException resultCode;
    
    public ExceptionManager(SNSAngelGuardFBManager snsManager){
        this.snsManager = snsManager;
    }
    
    public void initControlException(Exception e) throws InterDataBaseException, InterProcessException, InterEmailException{
        if(e instanceof UniformInterfaceException){
            UniformInterfaceException ex = (UniformInterfaceException) e;
            int code = ex.getResponse().getStatus();
            
            if(code >= 400 && code < 500){
                throw new InterDataBaseException(ex, CodeException.ERROR_CLIENT_DATABASE);
            }else if(code >= 500){
                throw new InterDataBaseException(e, CodeException.ERROR_SERVER_DATABASE);
            }
        }else if(e instanceof JSONException){
            JSONException ex = (JSONException) e;
            
            throw new InterProcessException(ex, CodeException.JSON_EXCEPTION);
        } else if(e instanceof UnsupportedEncodingException){
            
            throw new InterDataBaseException(e, CodeException.UNSUPPORTED_ENCODING);
        } else if(e instanceof MySQLIntegrityConstraintViolationException){
            MySQLIntegrityConstraintViolationException ex = (MySQLIntegrityConstraintViolationException) e;
            
            throw new InterDataBaseException(ex, CodeException.MYSQL_INTEGRITY_CONSTRAINT_VIOLATION_EXCEPTION);
        } else if(e instanceof bsh.ParseException){
            bsh.ParseException ex = (bsh.ParseException) e;
            
            throw new InterProcessException(ex, CodeException.PARSE_EXCEPTION);
        } else if(e instanceof org.bouncycastle.crypto.DataLengthException){
            org.bouncycastle.crypto.DataLengthException ex = (org.bouncycastle.crypto.DataLengthException) e;
            
            throw new InterProcessException(ex, CodeException.DATA_LENGTH_EXCEPTION);
        } else if(e instanceof IllegalStateException){
            IllegalStateException ex = (IllegalStateException) e;
            
            throw new InterProcessException(ex, CodeException.ILEGAL_STATE_EXCEPTION);
        } else if(e instanceof NoSuchProviderException){
            NoSuchProviderException ex = (NoSuchProviderException) e;
            
            throw new InterEmailException(ex, CodeException.NO_SUCH_PROVIDER_EXCEPTION);
        } else if(e instanceof MessagingException){
            MessagingException ex = (MessagingException) e;
            
            throw new InterEmailException(ex, CodeException.MESSAGING_EXCEPTION);
        } else if(e instanceof IOException){
            IOException ex = (IOException) e;
            
            throw new InterProcessException(ex, CodeException.IO_EXCEPTION);
        } else{
            throw new InterProcessException(e, CodeException.UKNOWN_ERROR);
        }
    }
    
    public String exceptionToString(Exception e) throws UnsupportedEncodingException{
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        String exceptionAsString = URLEncoder.encode(sw.toString(), "UTF-8");
        
        return exceptionAsString;
    }
}
