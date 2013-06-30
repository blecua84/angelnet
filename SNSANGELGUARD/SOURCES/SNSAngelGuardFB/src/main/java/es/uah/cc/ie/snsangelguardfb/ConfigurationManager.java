/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openide.util.Exceptions;

/**
 * Carga los ficheros de configuracion y los almacena en parametros que seran 
 * utilizados por la clase SNSAngelGuardFBManager.
 * 
 * @author josejavierblecuadepedro1
 */
public class ConfigurationManager {
    
    /** Ruta al fichero de configuracion */
    private static final String PATH_FILE_CONFIG = "/usr/local/snsangelguardfb/config/config.properties";
    
    /** Clave al host de la aplicacion en el fichero de configuracion */
    private static final String NAME_CONTEXT_APPLICATION = "configHostApplication";
    
    /** Clave SSL al host de la aplicacion en el fichero de configuracion */
    private static final String NAME_CONTEXT_APPLICATION_SSL = "configHostApplicationSSL";
    
    /** Clave al host de los servicios RESTFul en el fichero de configuracion */
    private static final String NAME_CONTEXT_RESTFULWS = "configHostRESTFullWS";
    
    /** Clave de aplicacion SNSAngelGuard en Facebook */
    public static final String API_KEY = "apiKey";

    /** Clave secreta de la aplicacion SNSAngelGuard en Facebook */
    public static final String API_SECRET_KEY = "apiSecretKey";
    
    /** Clave del path del certificado de confianza SSL */
    public static final String PATH_KEYSTORE_SSL = "pathKeyStoreSSL";
    
    /** Clave del password del certificado de confianza SSL */
    public static final String PASSWORD_KEYSTORE_SSL = "passwordKeyStoreSSL";
    
    /** Clave de la direccion de la aplicacion en Facebook */
    public static final String PATH_APPLICATION_FACEBOOK = "pathApplicationFacebook";
    
    /** Host de la aplicacion */
    private String configHostApplication;
    
    /** Host SSL de la aplicacion */
    private String configHostApplicationSSL;
    
    /** Host a los Servicios RESTFul */
    private String configHostRESTFullWS;
    
    /** Identificador de Facebook de la aplicacion */
    private String apiKey;
    
    /** Identificador secreto de Facebook de la aplicacion */
    private String apiSecretKey;
    
    /** Path al certificado de confianza SSL */
    private String pathKeyStoreSSL;
    
    /** Password del certificado de confianza SSL */
    private String passwordKeyStoreSSL;
    
    /** Path de la aplicacion en Facebook */
    private String pathApplicationFacebook;
    
    public String getConfigHostApplication() {
        return configHostApplication;
    }
    
    public String getConfigHostApplicationSSL() {
        return configHostApplicationSSL;
    }

    public String getConfigHostRESTFullWS() {
        return configHostRESTFullWS;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiSecretKey() {
        return apiSecretKey;
    } 

    public String getPathKeyStoreSSL() {
        return pathKeyStoreSSL;
    }

    public String getPasswordKeyStoreSSL() {
        return passwordKeyStoreSSL;
    }

    public String getPathApplicationFacebook() {
        return pathApplicationFacebook;
    }
    
    /**
     * Constructor de clase.
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public ConfigurationManager() throws FileNotFoundException, IOException {
        loadConfigFile();
    }
    
    
    /**
     * Carga el fichero de configuracion con los parametros necesarios.
     */
    private void loadConfigFile() throws FileNotFoundException, IOException{
        FileInputStream in = null;
        try {
            Properties defaultProps = new Properties();
            in = new FileInputStream(PATH_FILE_CONFIG);
            defaultProps.load(in);
            
            this.configHostApplication = defaultProps.getProperty(NAME_CONTEXT_APPLICATION);
            this.configHostApplicationSSL = defaultProps.getProperty(NAME_CONTEXT_APPLICATION_SSL);
            this.configHostRESTFullWS  = defaultProps.getProperty(NAME_CONTEXT_RESTFULWS);
            this.apiKey = defaultProps.getProperty(API_KEY);
            this.apiSecretKey = defaultProps.getProperty(API_SECRET_KEY);
            this.pathKeyStoreSSL = defaultProps.getProperty(PATH_KEYSTORE_SSL);
            this.passwordKeyStoreSSL = defaultProps.getProperty(PASSWORD_KEYSTORE_SSL);
            this.pathApplicationFacebook = defaultProps.getProperty(PATH_APPLICATION_FACEBOOK);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }
}
