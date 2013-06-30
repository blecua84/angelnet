<%-- 
    Document   : angelUser
    Created on : 02-may-2011, 12:29:00
    Author     : tote
--%>

<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterEmailException"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterProcessException"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterDataBaseException"%>
<%@page import="com.restfb.DefaultLegacyFacebookClient"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.sources.dao.UserSettingsDaoManager"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.sources.dao.LocaleSettingsDaoManager"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.sources.snswebservicesclient.SNSdataBaseClient"%>
<%@page import="org.codehaus.jettison.json.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
        SNSAngelGuardFBManager snsObject = null;
        String nameUser = null;
        String srcImg = null;
        
        try {
            //Obtenemos la seson de la aplicacion
            snsObject = SNSAngelGuardFBManager.getSessionInstance(request);
            
            //snsObject.setClient(new SNSdataBaseClient());

            String uidPublic = request.getParameter("par1");

            // Obtener informaci√≥n de userSettings por su uidPublic
            JSONObject jsonUser = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getJsonUserByUidPublic(snsObject, uidPublic);
            System.out.println("JSON USER ANGEL: " + jsonUser.toString());

            snsObject.getUserSettingsDaoManager().loadUserConnected(jsonUser);
            snsObject.getLocaleSettingsDaoManager().loadLocaleSettingsOffLine();
            
            //Obtenemos la conexión a Facebook
            snsObject.getLoginAppOffline(request, response);

            nameUser = jsonUser.getString("userName");
            srcImg = snsObject.getUserUtilities().getImgUser(jsonUser.getString("uid"));
        } catch (InterDataBaseException e) {
            String exceptionAsString = snsObject.getExceptionManager().exceptionToString(e.getException());

            response.sendRedirect(request.getContextPath() + "/infoError.jsp?errorMessage=" + e.getMessageException() + "&exception=" + exceptionAsString);
        } catch (InterProcessException e) {
            String exceptionAsString = snsObject.getExceptionManager().exceptionToString(e.getException());

            response.sendRedirect(request.getContextPath() + "/infoError.jsp?errorMessage=" + e.getMessageException() + "&exception=" + exceptionAsString);
        } catch (InterEmailException e) {
            String exceptionAsString = snsObject.getExceptionManager().exceptionToString(e.getException());

            response.sendRedirect(request.getContextPath() + "/infoError.jsp?errorMessage=" + e.getMessageException() + "&exception=" + exceptionAsString);
        }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>

        <title><%=snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleAngUser()%></title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

        <link type="text/css" rel="stylesheet" href="Styles/facebook.css" />

        <script type="text/javascript" charset="ISO-8859-1" src="js/utilidadesFormularios.js"></script>
    </head>
    <body >
        <form id="frAngeUser" action="" method="">
            <div id="divAngelUserContainer" class="divAngelUserContainer">
                <center>
                    <table width="95%">
                        <tr>
                            <td>
                                <div id="divAngelUserTitle">
                                    <table width="100%">
                                        <tr>
                                            <td width="90%">
                                                <h1 class="tituloMed"><%=snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleAngUser()%></h1>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="90%">
                                                <hr class="linea" />
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div id="divAngelUser" class="divAngelUser">
                                    <center>
                                        <table id="tabUserInformation" class="tabCenter">
                                            <tr>
                                                <td width="35%" align="center">
                                                    <img src="<%= srcImg%>" alt="">
                                                </td>
                                                <td width="65%">
                                                    <h1 class="aceptinTerms"> <%= nameUser%>
                                                    </h1>
                                                </td>
                                            </tr>
                                        </table>
                                    </center>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div id="botoneraInferior" align="right" margin="15px">
                                    <table width="100%">
                                        <tr>
                                            <td>
                                                <hr class="linea" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                                <input type="button" class="boton" name="btnCerrar" value="<%=snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getBtnCloseAngUser()%>"
                                                       onclick="cerrarVentana();"/>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                    </table>
                </center>
            </div>
        </form>
    </body>
</html>
