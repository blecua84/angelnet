package es.uah.cc.ie.snsangelguardfb.sources.offline;

import bsh.ParseException;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.restfb.DefaultFacebookClient;
import com.restfb.DefaultLegacyFacebookClient;
import com.sun.jersey.api.client.UniformInterfaceException;
import es.uah.cc.ie.snsangelguardfb.exception.InterDataBaseException;
import es.uah.cc.ie.snsangelguardfb.exception.InterEmailException;
import es.uah.cc.ie.snsangelguardfb.exception.InterProcessException;
import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchProviderException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Clase que realiza las operaciones de backup de la informacion de la base de
 * datos y realiza los chequeos de informacion cuando sea necesario para cada
 * uno de los filtros activos definidos para cada usuario.
 *
 * @author tote
 */
public class HarvestedSNS extends HttpServlet {

    /** Logger Class */
    private static Logger logger = Logger.getLogger(HarvestedSNS.class);

    /** Clase Manager de la aplicaci?n */
    private SNSAngelGuardFBManager snsObject;

    /**
     * Realiza la actualizacion de las ultimas novedades de la actividad social en Facebook de todos los usuarios
     * de la aplicacion y realiza los chequeos de informacion para los angeles definidos por cada usuario. Podra lanzar excepciones
     * del tipo ParseException, FileNotFoundException, NoSuchProviderException, MessagingException, MySQLIntegrityConstraintViolationException, bsh.ParseException, java.security.NoSuchProviderException, InterDataBaseException, InterProcessException o InterEmailException.
     *
     * @param request HttpServletRequest Contiene todos los par?metros de la sesi?n donde se conectar?n offline todos los usuarios
     * de la aplicaci?n en Facebook para acceder a sus datos.
     * @param response HttpServletResponse Response de la sesi?n.
     * @throws ParseException
     * @throws FileNotFoundException
     * @throws NoSuchProviderException
     * @throws MessagingException
     * @throws MySQLIntegrityConstraintViolationException
     * @throws bsh.ParseException
     * @throws java.security.NoSuchProviderException
     */
    public void updateUsers(HttpServletRequest request, HttpServletResponse response) throws ParseException, FileNotFoundException, NoSuchProviderException, MessagingException, MySQLIntegrityConstraintViolationException, bsh.ParseException, java.security.NoSuchProviderException, InterDataBaseException, InterProcessException, InterEmailException {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        logger.info(formateador.format(new Date()) + " - updateUsers: Iniciando tarea harvested...");
        HttpSession session = request.getSession(false);
        try {
            JSONArray arrayUsers = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getEntitiesUserSettings(this.snsObject);

            for (int i = 0; i < arrayUsers.length(); i++) {
                logger.debug(formateador.format(new Date()) + " - updateUsers: Iniciando proceso harvested para el usuario: " + arrayUsers.getJSONObject(i).getString("uid"));

                /** Cargamos el usuario actual */
                this.snsObject.getUserSettingsDaoManager().loadUserConnected(arrayUsers.getJSONObject(i));

                /** Cargamos los recursos de idioma */
                this.snsObject.getLocaleSettingsDaoManager().loadLocaleSettingsOffLine();

                /** Si la aplicaci?n se encuentra activada, realizamos el tratamiento de la informaci?n */
                if (this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().isAppActivated()) {
                    try {
                        /** Abrimos la conexi?n para el usuario actual */
                        session = openConectionOffLine(session);

                        /** Actualizamos la fecha de backup a la fecha actual */
                        this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().updateBackUpCheckUS();

                        /** Realizamos la actualizaci?n de la informaci?n del usuario en la base de datos */
                        this.snsObject.getUserSettingsDaoManager().getUserInfo(false);

                        /** Obtenemos los angeles definidos por el usuario */
                        String respuesta = this.snsObject.getClient().settingsAngels_getAngelsByUid(String.class, "\"" + this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + "\"");
                        JSONObject jsonRespuesta = new JSONObject(respuesta);
                        JSONArray angelsUser = this.snsObject.getJsonUtilities().getJSONArray(jsonRespuesta.getString("settingsAngels").toString());

                            // Realizamos los chequeos de informaci?n para los ?ngeles definidos
                            this.snsObject.getGenericFilter().checkUserSettingsOffLine(request, angelsUser);

                        /** Cerramos la conexi?n para el usuario actual */
                        session = closeConectionOffLine(session);

                        logger.debug(formateador.format(new Date()) + " - updateUsers: Proceso harvested terminado para el usuario: " + this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid());
                    } catch (IOException ex) {
                        logger.error(formateador.format(new Date()) + " - updateUsers: Excepcion capturada IOException: " + ex.getMessage());
                        logger.fatal(ex);
                    } catch (UniformInterfaceException ex) {
                        logger.error(formateador.format(new Date()) + " - updateUsers: Excepcion capturada UniformInterfaceException: " + ex.getMessage());
                        logger.fatal(ex);
                    } catch (com.restfb.exception.FacebookOAuthException ex){
                        logger.debug(formateador.format(new Date()) + " - updateUsers: No se ha podido actualizar la informacion del usuario...");
                        logger.error(formateador.format(new Date()) + " - updateUsers: Excepcion capturada com.restfb.exception.FacebookOAuthException: " + ex.getMessage());
                        logger.fatal(ex);
                    }
                }
            }
        } catch (JSONException ex) {
            logger.debug(formateador.format(new Date()) + " - updateUsers: Error al obtener los usuarios de la aplicacion...");
            logger.error(formateador.format(new Date()) + " - updateUsers: Excepcion capturada JSONException: " + ex.getMessage());
            logger.fatal(ex);
        }

        logger.info(formateador.format(new Date()) + " - updateUsers: Tarea harvested finalizada!!");
    }

    /**
     * Abre la conexion off line del usuario actual que se va a analizar.
     *
     * @param session Sesi?n obtenida del servlet.
     * @return HttpSession Nueva sesi?n con la conexi?n abierta para el usuario
     * actual.
     */
    private HttpSession openConectionOffLine(HttpSession session){
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        logger.info(formateador.format(new Date()) + " - openConectionOffLine: Iniciando apertura conexion offline...");
        HttpSession newSession = session;
        String oauth_token = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUserSession();
        
        newSession.setAttribute("oauth_token", oauth_token);
        newSession.setAttribute("user_id", this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid());

        logger.debug(formateador.format(new Date()) + " - openConectionOffLine: Uid offline: " + newSession.getAttribute("user_id"));
        logger.debug(formateador.format(new Date()) + " - openConectionOffLine: Token offline: " + newSession.getAttribute("oauth_token"));

        this.snsObject.setFacebookRestClient(new DefaultLegacyFacebookClient(oauth_token));
        this.snsObject.setFacebookQueryClient(new DefaultFacebookClient(oauth_token));

        logger.info(formateador.format(new Date()) + " - openConectionOffLine: Apertura conexion offline finalizada!!");

        return newSession;
    }

    /**
     * Cierra la conexion off line del usuario que se estaba analizando.
     *
     * @param session Sesi?n actual
     * @return HttpSession Nueva sesi?n con la conexi?n cerrada para el usuario
     * actual.
     */
    private HttpSession closeConectionOffLine(HttpSession session){
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        logger.info(formateador.format(new Date()) + " - closeConectionOffLine: Iniciando finalizacion conexion offline...");
        HttpSession newSession = session;

        newSession.setAttribute("oauth_token", "");
        newSession.setAttribute("user_id", "");

        this.snsObject.setFacebookRestClient(null);
        this.snsObject.setFacebookQueryClient(null);

        logger.info(formateador.format(new Date()) + " - closeConectionOffLine: Finalizacion del cierre conexion offline!!");

        return newSession;
    }

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        logger.info(formateador.format(new Date()) + " - doGet: Estableciendo sesion harvested...");
        this.snsObject = SNSAngelGuardFBManager.getSessionInstance(request);
        try {
            this.snsObject.getLoginAppOffline(request, response);
            this.updateUsers(request, response);
        } catch (Exception ex) {
            logger.error(formateador.format(new Date()) + " - doGet: Excepcion capturada Exception: " + ex.getMessage());
            logger.fatal(ex);
        }
        logger.info(formateador.format(new Date()) + " - doGet: Sesion harvested finalizada!!");
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}