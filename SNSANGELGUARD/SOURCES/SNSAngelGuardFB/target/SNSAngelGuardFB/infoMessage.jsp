<%-- 
    Document   : infoMessage
    Created on : 24-nov-2012, 9:29:46
    Author     : tote
--%>

<%@page import="java.io.IOException"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterDataBaseException"%>
<%@page import="org.json.JSONObject"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SNSAngelGuardFBManager snsObject = null;
    String message = "";
    String pathImg = "";
    String title = "";
    try {
        //Obtenemos la conexión a Facebook
        snsObject = SNSAngelGuardFBManager.getSessionInstance(request);
        snsObject.logSession(request, response);

        int type = Integer.parseInt(request.getParameter("typeInfo").toString());
        message = request.getParameter("infoMessage").toString();

        pathImg = "";
        title = "";


        switch (type) {
            // Mensaje OK
            case 0:
                pathImg = "../SNSAngelGuardFB/resources/iconoOk.jpg";
                title = "Mensaje de confirmación";
                break;

            // Mensaje Alerta
            case 1:
                pathImg = "";
                pathImg = "../SNSAngelGuardFB/resources/iconoAlerta.jpg";
                title = "Alerta";
                break;

            // Mensaje Error
            case 2:
                pathImg = "";
                pathImg = "../SNSAngelGuardFB/resources/iconoError.jpg";
                title = "Error";
                break;
        }

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
        <title><%= title%></title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <script type="text/javascript" charset="ISO-8859-1" src="js/jQuery-1.8.2.js"></script>
        <script type="text/javascript" charset="ISO-8859-1" src="js/utilidadesFormularios.js"></script>
        <link type="text/css" rel="stylesheet" href="Styles/facebook.css" />
    </head>
    <body >
        <form id="frInformationMessage" action="" method="">
            <div id="divAngelUserContainer">
                <center>
                    <table width="95%">
                        <tr>
                            <td>
                                <div>
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
                                <div>
                                    <table width="660px">
                                        <tr>
                                            <td width="250px">
                                                <img src="<%= pathImg%>"/>
                                            </td>
                                            <td width="410px">
                                                <h1 class="aceptinTerms"><%= message%></h1>
                                            </td>
                                        </tr>
                                    </table>
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
                                                <input type="button" class="boton" name="btnAceptar" value="<%=snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getBtnAceptGoogleCont()%>"
                                                       onclick="cerrarInfoModal();"/>
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