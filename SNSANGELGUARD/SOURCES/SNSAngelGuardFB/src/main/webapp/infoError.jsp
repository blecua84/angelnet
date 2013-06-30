<%-- 
    Document   : infoError
    Created on : 01-may-2013, 14:12:15
    Author     : josejavierblecuadepedro
--%>
<%@page import="java.net.URLDecoder"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager"%>
<%
    String pathImg = "../SNSAngelGuardFB/resources/iconoError.jpg";
    String title = null;
    String mensError = null;
    String details = null;
    String message = null;
    String btnAceptar = null;
    String e = null;

    try {
        //Obtenemos la conexión a Facebook
        SNSAngelGuardFBManager snsObject = SNSAngelGuardFBManager.getSessionInstance(request);
        snsObject.logSession(request, response);

        message = request.getParameter("errorMessage").toString();
        e = URLDecoder.decode(request.getParameter("exception").toString(), "UTF-8");

        String[] warnings = snsObject.getStringUtilities().stringToArray(snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getWarnings());
        btnAceptar = snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getBtnAceptGoogleCont();

        title = warnings[7];
        mensError = warnings[8];
        details = warnings[9];
    } catch (Exception ex) {
        // Si se produce un error al obtener los parametros anteriores, mostramos un mensaje por defecto.
        title = "Error";
        mensError = "Se ha producido un error inesperado...";
        details = "Detalles";
        message = request.getParameter("errorMessage").toString();
        e = URLDecoder.decode(request.getParameter("exception").toString(), "UTF-8");
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title><%= title%></title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

        <!--import css -->
        <link rel="stylesheet" type="text/css" href="Styles/facebook.css" />

        <!--import jquery lib -->
        <script type="text/javascript" charset="ISO-8859-1" src="js/jQuery-1.8.2.js"></script>
        <script type="text/javascript" charset="ISO-8859-1" src="js/utilidadesFormularios.js"></script>

    </head>
    <body >
        <form id="frErrorMessage" action="" method="">
            <div id="divAngelUserContainer">
                <center>
                    <table width="95%">
                        <tr>
                            <td>
                                <div>
                                    <table width="100%">
                                        <tr>
                                            <td width="90%">
                                                <h1 class="tituloMed"><%= message%></h1>
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
                                    <table width="98%">
                                        <tr>
                                            <td width="15%">
                                                <img class="errorInfo" src="<%=pathImg%>"/>
                                            </td>
                                            <td width="85%">
                                                <table width="100%">
                                                    <tr>
                                                        <td>
                                                            <h1 class="aceptinTerms"><%= mensError%></h1>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <img id="idBtnMostrar" class="cabBtnDespError" src="../SNSAngelGuardFB/resources/desplegar.gif" alt="" onclick="muestraDetalles()" />
                                                            <h1 class="acuerdoLegal"><%= details%></h1>

                                                            <div id="idDivDetails" class="divDetails" style="display:none;">
                                                                <h1 class="divDetails"><%= e%></h1>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
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
                                                <input type="button" class="boton" name="btnAceptar" value="<%= btnAceptar%>"
                                                       onclick="cerrarInfoError();" />
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
