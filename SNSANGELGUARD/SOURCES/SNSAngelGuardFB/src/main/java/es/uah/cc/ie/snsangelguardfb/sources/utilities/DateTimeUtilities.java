/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.sources.utilities;

import bsh.ParseException;
import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;
import java.util.Calendar;
import java.util.Date;

/**
 * Sera la encargada de gestionar todas las operaciones con fechas que se realizan en la aplicacion.
 * 
 * @author tote
 */
public class DateTimeUtilities {

    /**
     * Atributos de clase
     */
    private SNSAngelGuardFBManager snsObject;

    /**
     * Constructor de clase
     * 
     * @param snsObject: Objeto manager de la aplicacion
     */
    public DateTimeUtilities(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    /**
     * Metodos de acceso p?blico
     */
    public SNSAngelGuardFBManager getSnsObject() {
        return snsObject;
    }

    public void setSnsObject(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    /**
     * Convierte un String a un objeto Date. Puede lanzar excepciones del tipo ParseException.
     * 
     * @param strTime
     * @return
     * @throws ParseException
     */
    public Date formatTime(String strTime) throws ParseException {
        Date time = new Date(Long.parseLong(strTime));

        return time;
    }

    /**
     * Formatea una fecha recibida como String a otro String con formato YYYY-MM-DD.
     * 
     * @param fecha
     * @return
     */
    public String formatearFecha(String fecha) {
        String strNula = null;

        try {
            fecha.equals(strNula);
            if (fecha.length() == 5) {
                fecha = fecha + "/0000";
            }

            String[] fechas = fecha.split("/");
            return fechas[1] + "-" + fechas[0] + "-" + fechas[2];

        } catch (Exception e) {
            return "00-00-0000";
        }
    }


    /**
     * Obtiene la proxima fecha en la que se debera hacer un chequeo de informacion.
     *
     * @param frecFilter Frecuencia definida para el filtro
     * @return long Pr?xima fecha de chequeo en formato long.
     */
    public long getNextCheckTime(int frecFilter, Date lastCheck) {
        Calendar dist = Calendar.getInstance();
        dist.setTime(lastCheck);

        switch (frecFilter) {
            case 0:
                /** Cada d?a */
                dist.add(Calendar.DAY_OF_YEAR, 1);
                break;
            case 1:
                /** Cada semana */
                dist.add(Calendar.WEEK_OF_YEAR, 1);
                break;
            case 2:
                /** Cada dos semanas */
                dist.add(Calendar.WEEK_OF_YEAR, 2);
                break;
            case 3:
                /** Cada mes */
                dist.add(Calendar.MONTH, 1);
                break;
            case 4:
                /** Cada dos meses */
                dist.add(Calendar.MONTH, 2);
                break;
            case 5:
                /** Cada seis meses */
                dist.add(Calendar.MONTH, 6);
                break;
            case 6:
                /** Cada a?o */
                dist.add(Calendar.YEAR, 1);
                break;

        }

        return dist.getTimeInMillis();
    }
}
