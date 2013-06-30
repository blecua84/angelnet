/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb;


import com.restfb.DefaultFacebookClient;
import com.restfb.DefaultLegacyFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.exception.FacebookOAuthException;
import com.sun.jersey.api.client.UniformInterfaceException;
import es.uah.cc.ie.snsangelguardfb.exception.ExceptionManager;
import es.uah.cc.ie.snsangelguardfb.sources.email.GenericEmailObject;
import es.uah.cc.ie.snsangelguardfb.facebookclient.clients.FacebookClientLocal;
import es.uah.cc.ie.snsangelguardfb.sources.dao.LocaleSettingsDaoManager;
import es.uah.cc.ie.snsangelguardfb.sources.dao.UserSettingsDaoManager;
import es.uah.cc.ie.snsangelguardfb.sources.filtersfuncionality.FriendsFilterFuncionality;
import es.uah.cc.ie.snsangelguardfb.sources.filtersfuncionality.GenericFilterFuncionality;
import es.uah.cc.ie.snsangelguardfb.sources.filtersfuncionality.VisitsFilterFuncionality;
import es.uah.cc.ie.snsangelguardfb.sources.filtersfuncionality.WallFilterFuncionality;
import es.uah.cc.ie.snsangelguardfb.sources.snswebservicesclient.SNSdataBaseClient;
import es.uah.cc.ie.snsangelguardfb.sources.utilities.AngelsUtilities;
import es.uah.cc.ie.snsangelguardfb.sources.utilities.DateTimeUtilities;
import es.uah.cc.ie.snsangelguardfb.sources.utilities.JSONUtilities;
import es.uah.cc.ie.snsangelguardfb.sources.utilities.StringUtilities;
import es.uah.cc.ie.snsangelguardfb.sources.utilities.UserUtilities;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;


/**
 * Clase Manager de la aplicacion. Desde esta se controlara todo el flujo de
 * informacion que se vaya registrando a lo largo de la ejecucion del programa.
 * 
 * @author tote
 */
public final class SNSAngelGuardFBManager {

    /** Logger Class */
    private static Logger logger = Logger.getLogger(SNSAngelGuardFBManager.class);

    private ConfigurationManager configurationManager;
    
    /** APIs de acceso a Facebook */
    private static FacebookClientLocal facebookClient = new FacebookClientLocal();
    private DefaultLegacyFacebookClient facebookRestClient;
    private FacebookClient facebookQueryClient;

    /** Objeto DAO de control de los datos del usuario */
    private UserSettingsDaoManager userSettingsDaoManager = new UserSettingsDaoManager(this);

    /** Objeto DAO para los recursos de idioma del usuario actual */
    private LocaleSettingsDaoManager localeSettingsDaoManager = new LocaleSettingsDaoManager(this);
    
    /** Cliente REST de base de datos SocialNetwork */
    private SNSdataBaseClient client;
    
    /** Control de las excepciones que se produzcan en la aplicacion */
    private ExceptionManager exceptionManager = new ExceptionManager(this);

    /** Objeto de Filtros Generico */
    private GenericFilterFuncionality genericFilter = new GenericFilterFuncionality(this);

    /** Objeto para el Filtro de Vocabulario Ofensivo */
    private WallFilterFuncionality wallFilterFuncionality = new WallFilterFuncionality(this);

    /** Objeto para el Filtro de Amigos */
    private FriendsFilterFuncionality friendsFilterFuncionality = new FriendsFilterFuncionality(this);

    /** Objeto para el Filtro de Control de Visitas */
    private VisitsFilterFuncionality visitsFilterFuncionality = new VisitsFilterFuncionality(this);
    
    /** Objetos de utilidad en el sistema */
    private JSONUtilities jsonUtilities = new JSONUtilities(this);
    private AngelsUtilities angelsUtilities = new AngelsUtilities(this);
    private DateTimeUtilities dateTimeUtilities = new DateTimeUtilities(this);
    private StringUtilities stringUtilities = new StringUtilities(this);
    private UserUtilities userUtilities = new UserUtilities(this);

    /** Objeto para el envio de emails */
    private GenericEmailObject emailObject = new GenericEmailObject(this, facebookClient);

    /** Atributo de nueva conexion */
    private boolean newConnection = false;

    /** Atributo de inicio de la aplicacion */
    private boolean inicio = true;

    /** Contexto de la aplicaci?n */
    private static String context;


    /** Metodos de acceso publico */

    public boolean isNewConnection() {
        return newConnection;
    }

    public void setNewConnection(boolean newConnection) {
        this.newConnection = newConnection;
    }

    public ExceptionManager getExceptionManager() {
        return exceptionManager;
    }

    public void setExceptionManager(ExceptionManager exceptionManager) {
        this.exceptionManager = exceptionManager;
    }
    
    public GenericFilterFuncionality getGenericFilter() {
        return genericFilter;
    }

    public void setGenericFilter(GenericFilterFuncionality genericFilter) {
        this.genericFilter = genericFilter;
    }

    public WallFilterFuncionality getWallFilterFuncionality() {
        return wallFilterFuncionality;
    }

    public void setWallFilterFuncionality(WallFilterFuncionality wallFilterFuncionality) {
        this.wallFilterFuncionality = wallFilterFuncionality;
    }

    public FriendsFilterFuncionality getFriendsFilterFuncionality() {
        return friendsFilterFuncionality;
    }

    public void setFriendsFilterFuncionality(FriendsFilterFuncionality friendsFilterFuncionality) {
        this.friendsFilterFuncionality = friendsFilterFuncionality;
    }

    public VisitsFilterFuncionality getVisitsFilterFuncionality() {
        return visitsFilterFuncionality;
    }

    public void setVisitsFilterFuncionality(VisitsFilterFuncionality visitsFilterFuncionality) {
        this.visitsFilterFuncionality = visitsFilterFuncionality;
    }

    public UserSettingsDaoManager getUserSettingsDaoManager() {
        return userSettingsDaoManager;
    }

    public void setUserSettingsDaoManager(UserSettingsDaoManager userSettingsDaoManager) {
        this.userSettingsDaoManager = userSettingsDaoManager;
    }

    public LocaleSettingsDaoManager getLocaleSettingsDaoManager() {
        return localeSettingsDaoManager;
    }

    public void setLocaleSettingsDaoManager(LocaleSettingsDaoManager localeSettingsDaoManager) {
        this.localeSettingsDaoManager = localeSettingsDaoManager;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger aLogger) {
        logger = aLogger;
    }

    public boolean isInicio() {
        return inicio;
    }

    public void setInicio(boolean inicio) {
        this.inicio = inicio;
    }

    public static String getContext() {
        return context;
    }

    public void setContext(String context) {
        SNSAngelGuardFBManager.context = context;
    }

    public GenericEmailObject getEmailObject() {
        return emailObject;
    }

    public void setEmailObject(GenericEmailObject emailObject) {
        this.emailObject = emailObject;
    }

    /**
     * @return the client
     */
    public SNSdataBaseClient getClient() {
        return client;
    }

    /**
     * @param aClient the client to set
     */
    public void setClient(SNSdataBaseClient aClient) {
        this.client = aClient;
    }

    public JSONUtilities getJsonUtilities() {
        return jsonUtilities;
    }

    public void setJsonUtilities(JSONUtilities jsonUtilities) {
        this.jsonUtilities = jsonUtilities;
    }

    public static FacebookClientLocal getFacebookClient() {
        return facebookClient;
    }

    public static void setFacebookClient(FacebookClientLocal facebookClient) {
        SNSAngelGuardFBManager.facebookClient = facebookClient;
    }

    public AngelsUtilities getAngelsUtilities() {
        return angelsUtilities;
    }

    public void setAngelsUtilities(AngelsUtilities angelsUtilities) {
        this.angelsUtilities = angelsUtilities;
    }

    public DateTimeUtilities getDateTimeUtilities() {
        return dateTimeUtilities;
    }

    public void setDateTimeUtilities(DateTimeUtilities dateTimeUtilities) {
        this.dateTimeUtilities = dateTimeUtilities;
    }

    public StringUtilities getStringUtilities() {
        return stringUtilities;
    }

    public void setStringUtilities(StringUtilities stringUtilities) {
        this.stringUtilities = stringUtilities;
    }

    public UserUtilities getUserUtilities() {
        return userUtilities;
    }

    public void setUserUtilities(UserUtilities userUtilities) {
        this.userUtilities = userUtilities;
    }

    public DefaultLegacyFacebookClient getFacebookRestClient() {
        return facebookRestClient;
    }

    public void setFacebookRestClient(DefaultLegacyFacebookClient facebookRestClient) {
        this.facebookRestClient = facebookRestClient;
    }

    public FacebookClient getFacebookQueryClient() {
        return facebookQueryClient;
    }

    public void setFacebookQueryClient(FacebookClient facebookQueryClient) {
        this.facebookQueryClient = facebookQueryClient;
    }

    public String getSessionKey() throws UniformInterfaceException, IOException {
        return facebookClient.getSessionKeyFacebook();
    }

    public ConfigurationManager getConfigurationManager() {
        return configurationManager;
    }

    public void setConfigurationManager(ConfigurationManager configurationManager) {
        this.configurationManager = configurationManager;
    }
    
    public SNSAngelGuardFBManager() throws FileNotFoundException, IOException{
        this.configurationManager = new ConfigurationManager();
    }
    
    
    
    /**
     * Obtiene el objeto SNSAngelGuardFBManager por el cual se mantiene abierta
     * la sesion para un mismo usuario durante toda la navegacion de la
     * aplicacion.
     *
     * @param request HttpServletRequest obtenido de la sesion del navegador.
     * @return SNSAngelGuardFBManager con los datos del usuario conectado.
     */
    public static SNSAngelGuardFBManager getSessionInstance(HttpServletRequest request) throws FileNotFoundException, IOException {
        getLogger().info("Inicio Sesion - getSessionInstance: Inicio getSessionInstance...");
        SNSAngelGuardFBManager instance = (SNSAngelGuardFBManager) request.getSession().getAttribute("snsangelguardfb");

        if (instance == null) {
            instance = new SNSAngelGuardFBManager();
            instance.setClient(new SNSdataBaseClient(instance.getConfigurationManager().getConfigHostRESTFullWS()));
            getLogger().info("Inicio Sesion - getSessionInstance: Obteniendo sesion...");
            request.getSession().setAttribute("snsangelguardfb", instance);
            getLogger().info("Inicio Sesion - getSessionInstance: Sesion obtenida!!");
        }
        context = request.getRequestURL().toString();
        getLogger().info("Inicio Sesion - getSessionInstance: Fin getSessionInstance...");
        return instance;
    }

    /**
     * Realiza el login del usuario actual en Facebook.
     *
     * @param request HttpServletRequest de la sesi?n actual.
     * @param response HttpServletResponse de la sesi?n actual.
     * @throws IOException
     */
    public void getLoginFacebook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        getLogger().info(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - getLoginFacebook: Inicio getLoginFacebook...");
        HttpSession session = request.getSession();

        if (session.getAttribute("oauth_token") != null && session.getAttribute("user_id") != null) {
            String userId = session.getAttribute("user_id").toString();
            String accessToken = session.getAttribute("oauth_token").toString();

            try {
                getLogger().info(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - getLoginFacebook: Obteniendo acceso a Facebook...");
                this.userSettingsDaoManager.getUserSettingsDAO().setUserSession(accessToken);
                this.userSettingsDaoManager.getUserSettingsDAO().setUid(userId);
                this.facebookRestClient = new DefaultLegacyFacebookClient(accessToken);
                this.facebookQueryClient = new DefaultFacebookClient(accessToken);
            } catch (FacebookOAuthException ex) {
                try {
                    getLogger().info(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - getLoginFacebook: Obteniendo acceso a Facebook -  Nueva Conexion por FacebookOAuthException...");
                    facebookClient.login(request, response, this.configurationManager.getApiKey(), this.configurationManager.getApiSecretKey(), this.configurationManager.getPathApplicationFacebook());
                } catch (JSONException ex1) {
                    getLogger().error(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - getLoginFacebook: Excepcion capturada JSONException: " + ex1.getMessage());
                }
            }
        } else {
            try {
                getLogger().info(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - getLoginFacebook: Obteniendo acceso a Facebook - Nuevo Usuario...");
                facebookClient.login(request, response, this.configurationManager.getApiKey(), this.configurationManager.getApiSecretKey(), this.configurationManager.getPathApplicationFacebook());
                return;
            } catch (JSONException ex) {
                getLogger().error(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - getLoginFacebook: Excepcion capturada JSONException: " + ex.getMessage());
            }
        }
        getLogger().info(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - getLoginFacebook: Fin getLoginFacebook...");
    }

    /**
     * Establece la sesion actual en Facebook para el usuario conectado.
     *
     * @param request HttpServletRequest de la sesi?n actual.
     * @param response HttpServletResponse de la sesi?n actual.
     * @throws IOException
     * @throws JSONException
     */
    public void logSession(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        getLogger().info(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - logSession: Inicio logSession...");
        HttpSession session = request.getSession(false);
        if (session.getAttribute("oauth_token") != null && session.getAttribute("user_id") != null) {
            getLogger().debug(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - logSession: Nueva Sesion Obtenida: " + session.getAttribute("oauth_token"));
            getLogger().debug(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - logSession: Nuevo UID Usuario: " + session.getAttribute("uid"));
            getLogger().info(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - logSession: Guardando parametros de conexion obtenidos...");
            this.userSettingsDaoManager.getUserSettingsDAO().setUserSession((String) session.getAttribute("oauth_token"));
            this.userSettingsDaoManager.getUserSettingsDAO().setUid((String) session.getAttribute("user_id"));
        } else {
            getLogger().info(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - logSession: Obteniendo conexion a Facebook...");
            facebookClient.login(request, response, this.configurationManager.getApiKey(), this.configurationManager.getApiSecretKey(), this.configurationManager.getPathApplicationFacebook());
            getLogger().info(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - logSession: Conexion a Facebook obtenida!!");
        }
        getLogger().info(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - logSession: Fin logSession...");
    }

    /**
     * Cierra la conexion con la base de datos de SocialNetwork.
     */
    public void cerrarConexionSNS() {
        getLogger().info(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - cerrarConexionSNS: Finalizando conexion con base de datos...");
        getClient().close();
        getLogger().info(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - cerrarConexionSNS: Conexion con base de datos finalizada!!");
    }

    /**
     * Obtiene la conexion Offline del usuario que se esta tratando actualmente en la aplicacion.
     *
     * @param request HttpServletRequest de la sesi?n.
     * @param response HttpServletResponse de la sesi?n.
     */
    public void getLoginAppOffline(HttpServletRequest request, HttpServletResponse response) {
        getLogger().info(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - getLoginAppOffline: Inicio getLoginAppOffline...");
        try {
            getLogger().info(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - getLoginAppOffline: Obteniendo conexion Offline con Facebook...");

            facebookClient.loginOffline(request, response, this.configurationManager.getApiKey(), this.configurationManager.getApiSecretKey(), this.configurationManager.getPathApplicationFacebook());
            
            getLogger().info(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - getLoginAppOffline: Conexion Offline con Facebook obtenida!!");
        } catch (IOException ex) {
            getLogger().error(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - getLoginAppOffline: Excepcion capturada IOException: " + ex.getMessage());
        } catch (JSONException ex) {
            getLogger().error(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - getLoginAppOffline: Excepcion capturada JSONException: " + ex.getMessage());
        }
        getLogger().info(this.userSettingsDaoManager.getUserSettingsDAO().getUid() + " - getLoginAppOffline: Inicio getLoginAppOffline...");
    }
}