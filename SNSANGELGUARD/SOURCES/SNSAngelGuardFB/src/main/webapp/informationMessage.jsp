<%-- 
    Document   : informationMessage
    Created on : 29-may-2011, 17:23:32
    Author     : tote
--%>

<%@page import="java.io.IOException"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager"%>
<%@page import="org.codehaus.jettison.json.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SNSAngelGuardFBManager snsObject = null;
    String strPrueba = null;
    try {
        //Obtenemos la conexión a Facebook
        snsObject = SNSAngelGuardFBManager.getSessionInstance(request);
        

        String uidPublic = request.getParameter("par2");
        int typeMen = Integer.parseInt(request.getParameter("par1"));

        if (typeMen != 2) {
            // Obtener información de userSettings por su uidPublic
            JSONObject jsonUser = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getJsonUserByUidPublic(snsObject, uidPublic);

            snsObject.getUserSettingsDaoManager().loadUserConnected(jsonUser);
            snsObject.getLocaleSettingsDaoManager().loadLocaleSettingsOffLine();
            
            snsObject.getLoginAppOffline(request, response);
        }

        String[] strMens = snsObject.getStringUtilities().stringToArray(snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getInformationMessage());
        strPrueba = strMens[typeMen];

    } catch (FileNotFoundException e) {
        String exceptionAsString = snsObject.getExceptionManager().exceptionToString(e);

        response.sendRedirect(request.getContextPath() + "/infoError.jsp?errorMessage=" + e.getMessage() + "&exception=" + exceptionAsString);
    } catch (IOException e) {
        String exceptionAsString = snsObject.getExceptionManager().exceptionToString(e);

        response.sendRedirect(request.getContextPath() + "/infoError.jsp?errorMessage=" + e.getMessage() + "&exception=" + exceptionAsString);
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Information message</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

        <link type="text/css" rel="stylesheet" href="Styles/facebook.css" />

        <script type="text/javascript" charset="ISO-8859-1" src="js/utilidadesFormularios.js"></script>
    </head>
    <body >
        <form id="frInformationMessage" action="" method="">
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
                                                <td width="100%">
                                                    <h1 class="aceptinTerms"> <%= strPrueba%>
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
