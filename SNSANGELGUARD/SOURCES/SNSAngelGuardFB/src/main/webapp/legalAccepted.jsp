<%--
    Document   : legalAccepted
    Created on : 20-dic-2010, 13:36:31
    Author     : tote
--%>


<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterEmailException"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterProcessException"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterDataBaseException"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.entity.LegalAcceptedJSPControler"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    //Obtenemos la conexión a Facebook
    LegalAcceptedJSPControler jspControler = null;

    try {
        jspControler = new LegalAcceptedJSPControler(request, response);
        jspControler.process();
    } catch (InterDataBaseException e) {
        String exceptionAsString = jspControler.getSnsObject().getExceptionManager().exceptionToString(e.getException());

        response.sendRedirect(request.getContextPath() + "/infoError.jsp?errorMessage=" + e.getMessageException() + "&exception=" + exceptionAsString);
    } catch (InterProcessException e) {
        String exceptionAsString = jspControler.getSnsObject().getExceptionManager().exceptionToString(e.getException());

        response.sendRedirect(request.getContextPath() + "/infoError.jsp?errorMessage=" + e.getMessageException() + "&exception=" + exceptionAsString);
    } catch (InterEmailException e) {
        String exceptionAsString = jspControler.getSnsObject().getExceptionManager().exceptionToString(e.getException());

        response.sendRedirect(request.getContextPath() + "/infoError.jsp?errorMessage=" + e.getMessageException() + "&exception=" + exceptionAsString);
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"lang="es" xml:lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title><%=jspControler.getJspResources().getTitle()%></title>

        <!--import css -->
        <link rel="stylesheet" type="text/css" href="Styles/facebook.css" />
        <link rel="stylesheet" type="text/css" href="Styles/jquery.loader.css" />

        <!--import jquery lib -->
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/utilidadesFormularios.js"></script>
        <script type="text/javascript" src="js/jquery.loader.js"></script>
        <script type="text/javascript">

        </script>
    </head>
    <body>
        <form id="frLegalAccepted" action="">
            <input type="hidden" id="newConection" name="newConection" value="0" />
            <input type="hidden" id="ok" name="ok" value="0" />
            <div id="legalAccepted">
                <center>
                    <div id="contenido" style="width:97%;" >
                        <h1 class="titulo"><%=jspControler.getJspResources().getTitle()%></h1>
                        <table>
                            <tr>
                                <td></td>
                            </tr>
                            <tr>
                                <td width="10%">
                                    <img src="<%= jspControler.getJspResources().PATH_IMAGE_ICONO_LEFT%>" WIDTH="83" HEIGHT="111" alt="" />
                                </td>
                                <td width="80%">
                                    <h1 class="aceptinTerms"><%= jspControler.getJspResources().getAcceptingTerms()%></h1>
                                </td>
                                <td width="10%">
                                    <img src="<%= jspControler.getJspResources().PATH_IMAGE_ICONO_RIGHT%>" WIDTH="83" HEIGHT="111" alt="" />
                                </td>
                            </tr>
                        </table>
                        <div class="acuerdoLegal">
                            <h1 class="acuerdoLegal"><%= jspControler.getJspResources().getLegalAccepted()%></h1>
                        </div>
                        <div id="botoneraInferior" style="width:80%;" align="left" margin="15px">
                            <hr class="linea" />
                            <table>
                                <tr>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="button" class="boton" name="btnCancel" value="<%=jspControler.getJspResources().getTitleBtnCancel()%>"
                                               onclick="removeApp();"/>
                                    </td>
                                    <td>
                                        <input type="button" class="boton" id="btnIagree" name="btnIagree" value="<%= jspControler.getJspResources().getTitleBtnIAgree()%>"
                                               onclick="muestraLoader('<%= jspControler.getJspResources().getLoaderSave()%>', '<%= jspControler.getJspResources().getLoaderWait()%>');
                enviarFormularioLegalA('<%= jspControler.getJspResources().DESTINY_REDIRECT_JPS%>');"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="10%">
                                        <img src="<%= jspControler.getJspResources().PATH_IMAGE_LOADING%>" style="display: none" />
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </center>
            </div>
        </form>
    </body>
</html>