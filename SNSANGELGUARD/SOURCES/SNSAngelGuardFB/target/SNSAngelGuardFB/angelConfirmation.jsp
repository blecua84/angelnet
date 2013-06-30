<%-- 
    Document   : angelConfirmation
    Created on : 02-may-2011, 11:48:22
    Author     : tote
--%>


<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterProcessException"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterEmailException"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterDataBaseException"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.sources.snswebservicesclient.SNSdataBaseClient"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="org.codehaus.jettison.json.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>SNSAngelGuard</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

        <link type="text/css" rel="stylesheet" href="Styles/facebook.css" />
        <link type="text/css" rel="stylesheet" href="Styles/jquery.loader.css" />

        <script type="text/javascript" charset="ISO-8859-1" src="js/jquery.corner.js"></script>
        <script type="text/javascript" charset="ISO-8859-1" src="js/jquery.loader.js"></script>
        <script type="text/javascript" charset="ISO-8859-1" src="js/utilidadesFormularios.js"></script>
    </head>
    <body >
        <form id="frIndex" action="" onload="muestraLoader('Guardando datos','Espere por favor...');">
        </form>
    </body>
</html>

<%
    //Obtenemos la conexión a Facebook
    request.getSession(true);
    SNSAngelGuardFBManager snsObject = SNSAngelGuardFBManager.getSessionInstance(request);
    String uidPublic = null;
    
    try {
            snsObject.getFacebookQueryClient();
            

            uidPublic = request.getParameter("par1");
            String idAngel = request.getParameter("par2");
            boolean accept = request.getParameter("par3").equals("1");

            // Obtener información de userSettings por su uidPublic
            JSONObject jsonUser = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getJsonUserByUidPublic(snsObject, uidPublic);
            snsObject.getUserSettingsDaoManager().loadUserConnected(jsonUser);
            snsObject.getLocaleSettingsDaoManager().loadLocaleSettingsOffLine();
            
            snsObject.getLoginAppOffline(request, response);
            snsObject.setClient(new SNSdataBaseClient(snsObject.getConfigurationManager().getConfigHostRESTFullWS()));

            JSONObject jsonAngel = snsObject.getAngelsUtilities().getJsonAngel(idAngel, jsonUser.getString("uid"));

            if (!jsonAngel.toString().equals("{}")) {
                if (jsonAngel.getString("confirmAngel").equals("0")) {

                    jsonAngel.put("confirmAngel", "1");
                    if (accept) {
                        jsonAngel.put("acceptAngel", "1");
                    } else {
                        jsonAngel.put("acceptAngel", "0");
                    }

                    // Guardamos la configuracion del angel
                    snsObject.getAngelsUtilities().setJsonAngel(jsonAngel);

                    if (accept) {
                        // Se realiza el primer chequeo de información
                        snsObject.getGenericFilter().firstCheckAngelConfirmation(request, jsonAngel);
                        // Guardamos la información de configuración
                        snsObject.getUserSettingsDaoManager().checkAngelConfirmation(jsonUser);
                    }

                    // Mensaje de Confirmacion
                    response.sendRedirect(request.getContextPath() + "/informationMessage.jsp?par1=0&par2=" + uidPublic);
                } else {
                    // Mensaje de Aviso ("El usuario ya está confirmado")
                    response.sendRedirect(request.getContextPath() + "/informationMessage.jsp?par1=1&par2=" + uidPublic);
                }
            } else {
                // Mensaje de Error ("El angel indicado ha sido borrado por el usuario")
                response.sendRedirect(request.getContextPath() + "/informationMessage.jsp?par1=2&par2=" + uidPublic);
            }
    }catch(InterDataBaseException e){
        // Mensaje de Error ("El angel indicado ha sido borrado por el usuario")
        String exceptionAsString = snsObject.getExceptionManager().exceptionToString(e.getException());
        
        response.sendRedirect(request.getContextPath() + "/infoError.jsp?errorMessage=" + e.getMessageException() + "&exception=" + exceptionAsString);
    } catch(InterProcessException e){
        String exceptionAsString = snsObject.getExceptionManager().exceptionToString(e.getException());
        
        // Mensaje de Error ("El angel indicado ha sido borrado por el usuario")
        response.sendRedirect(request.getContextPath() + "/infoError.jsp?errorMessage=" + e.getMessageException() + "&exception=" + exceptionAsString);
    } catch(InterEmailException e){
        String exceptionAsString = snsObject.getExceptionManager().exceptionToString(e.getException());
        
        // Mensaje de Error ("El angel indicado ha sido borrado por el usuario")
        response.sendRedirect(request.getContextPath() + "/infoError.jsp?errorMessage=" + e.getMessageException() + "&exception=" + exceptionAsString);
    }
    
%>
