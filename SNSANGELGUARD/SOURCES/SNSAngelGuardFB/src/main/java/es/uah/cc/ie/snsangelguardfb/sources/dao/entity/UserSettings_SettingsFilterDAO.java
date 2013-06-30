/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.sources.dao.entity;

import bsh.ParseException;
import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;
import es.uah.cc.ie.snsangelguardfb.sources.dao.UserSettingsDaoManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Clase que realiza todas las operaciones DAO necesarias para un filtro.
 *
 * @author tote
 */
public class UserSettings_SettingsFilterDAO {

    /** Logger Class */
    private static Logger logger = Logger.getLogger(UserSettings_SettingsFilterDAO.class);

    /** Manager del objeto UserSettingsDAO */
    private UserSettingsDaoManager manager;
    
    /** Identificador en base de datos del filtro */
    private Long uid;
    
    /** Frecuencia de ejecucion del filtro */
    private String frec;
    
    /** Angeles separados por el caracter ; */
    private String angels;
    
    /** Indicador de actividad del filtro */
    private String active;
    
    /** Identificador propietario del filtro */
    private Long uidProp;
    
    /** Ultimo chequeo realizado por el filtro */
    private Date lastCheck;

    /**
     * Constructor de clase. Recibir? todos los par?metros de la clase.
     *
     * @param manager
     * @param uid
     * @param frec
     * @param angels
     * @param active
     * @param uidProp
     * @param lastCheck
     */
    public UserSettings_SettingsFilterDAO(UserSettingsDaoManager manager, Long uid, String frec, String angels, String active, Long uidProp, Date lastCheck) {
        this.manager = manager;
        this.uid = uid;
        this.frec = frec;
        this.angels = angels;
        this.active = active;
        this.uidProp = uidProp;
        this.lastCheck = lastCheck;
    }

    /**
     * Constructor sin argumentos.
     */
    public UserSettings_SettingsFilterDAO(UserSettingsDaoManager manager) {
        this.manager = manager;
    }

    /**
     * @return the uid
     */
    public Long getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * @return the frec
     */
    public String getFrec() {
        return frec;
    }

    /**
     * @param frec the frec to set
     */
    public void setFrec(String frec) {
        this.frec = frec;
    }

    /**
     * @return the angels
     */
    public String getAngels() {
        return angels;
    }

    /**
     * @param angels the angels to set
     */
    public void setAngels(String angels) {
        this.angels = angels;
    }

    /**
     * @return the active
     */
    public String getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(String active) {
        this.active = active;
    }

    /**
     * @return the uidProp
     */
    public Long getUidProp() {
        return uidProp;
    }

    /**
     * @param uidProp the uidProp to set
     */
    public void setUidProp(Long uidProp) {
        this.uidProp = uidProp;
    }

    /**
     * @return the lastCheck
     */
    public Date getLastCheck() {
        return lastCheck;
    }

    /**
     * @param lastCheck the lastCheck to set
     */
    public void setLastCheck(Date lastCheck) {
        this.lastCheck = lastCheck;
    }

    /**
     * Formatea un String a un Date con formato "yyyy-MM-dd HH:mm:ss". Podr? lanzar excepciones del tipo ParseException o java.text.ParseException.
     *
     * @param strTime Fecha obtenida de la base de datos.
     * @return Date con la fecha parseada al formato anterior.
     * @throws ParseException
     * @throws java.text.ParseException
     */
    public Date formatTime(String strTime) throws ParseException, java.text.ParseException {
        logger.info(this.uid + " - formatTime: Inicio formatTime...");
        Date time = new Date(Long.parseLong(strTime));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       // time = sdf.parse(strTime);
        logger.info(this.uid + " - formatTime: Fin formatTime...");
        return time;
    }

    /**
     * Obtiene el filtro de la base de datos indicado por el par?metro de entrada desFiltro. Podr? lanzar excepciones del tipo JSONException.
     *
     * @param desFiltro Identificador de filtro.
     * @return
     * @throws JSONException
     */
    public JSONObject getObjectFilter(String desFiltro) throws JSONException {
        logger.info(this.uid + " - getObjectFilter: Inicio getObjectFilter para el filtro " + desFiltro);
        JSONObject newObject = new JSONObject();
        JSONObject jsonUri = new JSONObject();

        newObject.put("userSettingsUid", this.getUid().toString());
        newObject.put("frec" + desFiltro, this.getFrec());
        newObject.put("active" + desFiltro, this.getActive());
        newObject.put("lastCheck", "");

        jsonUri.put("uri", this.manager.getSnsObject().getConfigurationManager().getConfigHostApplication() + "SNSdataBaseIntegratorServer/resources/userSettingss/" + this.getUid().toString() + "/");
        newObject.put("userSettings", jsonUri);

        logger.info(this.uid + " - getObjectFilter: Fin getObjectFilter para el filtro " + desFiltro);
        return newObject;
    }

    /**
     * Obtiene un JSONArray con todos los datos de los angeles de la aplicacion. Podr? lanzar excepciones del tipo JSONException.
     *
     * @param arrayAngels
     * @return
     * @throws JSONException
     */
    public JSONArray getAngelsFilter(String[][] arrayAngels) throws JSONException {
        logger.info(this.uid + " - getAngelsFilter: Inicio getAngelsFilter...");
        String[] arrayAngelsFilter = this.getAngels().split(";");
        JSONArray jsonAngelsFilter = new JSONArray();
        JSONObject jsonDatesAngel = null;

        for (int i = 0; i < arrayAngelsFilter.length; i++) {
            for (int j = 0; j < arrayAngels.length; j++) {
                if (arrayAngelsFilter[i].equals(arrayAngels[j][0])) {
                    jsonDatesAngel = new JSONObject();
                    jsonDatesAngel.put("idAngel", arrayAngels[j][0]);
                    jsonDatesAngel.put("nameAngel", arrayAngels[j][1]);
                    jsonDatesAngel.put("imgAngel", arrayAngels[j][2]);
                    jsonDatesAngel.put("typeAngel", arrayAngels[j][3]);
                    jsonDatesAngel.put("acceptAngel", "0");
                    jsonDatesAngel.put("userPropAngel", this.getUidProp());
                    jsonAngelsFilter.put(jsonDatesAngel);
                }
            }
        }
        logger.debug(this.uid + " - getAngelsFilter: Angeles seleccionados: " + jsonAngelsFilter.toString());
        logger.info(this.uid + " - getAngelsFilter: Fin getAngelsFilter...");
        return jsonAngelsFilter;
    }

    /**
     * Carga en la aplicacion un filtro seleccionado. Podr? lanzar excepciones del tipo JSONException, ParseException o java.text.ParseException.
     *
     * @param jsonFilter
     * @param jsonArrayAngels
     * @param des Identificador de filtro.
     * @throws JSONException
     * @throws ParseException
     * @throws java.text.ParseException
     */
    public void loadSettingsFilter(JSONObject jsonFilter, JSONArray jsonArrayAngels, String des) throws JSONException, ParseException, java.text.ParseException {
        logger.info(this.uid + " - loadSettingsFilter: Inicio loadSettingsFilter para el filtro " + des);
        this.setUid(new Double(jsonFilter.getString("userSettingsUid")).longValue());
        this.setFrec(jsonFilter.getString("frec" + des));
        this.setActive(jsonFilter.getString("active" + des));
        this.setUidProp(new Double(jsonFilter.getString("userSettingsUid")).longValue());
        this.setLastCheck(formatTime(jsonFilter.getString("lastCheck").replace("T", " ")));
        if (this.getActive().equals("1")) {
            loadAngelsFilter(jsonArrayAngels);
        }
        logger.info(this.uid + " - loadSettingsFilter: Fin loadSettingsFilter para el filtro " + des);
    }

    /**
     * Carga los angeles definidos en la aplicacion para presentarlos por pantalla. Podr? lanzar excepciones del tipo JSONException.
     *
     * @param jsonArrayAngels
     * @throws JSONException
     */
    public void loadAngelsFilter(JSONArray jsonArrayAngels) throws JSONException {
        logger.info(this.uid + " - loadAngelsFilter: Inicio loadAngelsFilter...");
        JSONObject jsonAngel = null;
        String lstAngels = "";
        if (jsonArrayAngels != null) {
            if (jsonArrayAngels.length() != 0) {
                for (int i = 0; i < jsonArrayAngels.length(); i++) {
                    jsonAngel = jsonArrayAngels.getJSONObject(i);
                    if (i == 0) {
                        lstAngels = jsonAngel.getString("idAngel") + ";";
                    } else {
                        lstAngels += jsonAngel.getString("idAngel") + ";";
                    }
                }
            }

            this.setAngels(lstAngels);
        }
        logger.info(this.uid + " - loadAngelsFilter: Fin loadAngelsFilter...");
    }
}