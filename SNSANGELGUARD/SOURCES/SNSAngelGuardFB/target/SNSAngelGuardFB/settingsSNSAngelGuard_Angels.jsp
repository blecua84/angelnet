<%-- 
    Document   : settingsSNSAngelGuard_Angels
    Created on : 31-mar-2011, 23:00:05
    Author     : tote
--%>

<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterEmailException"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterProcessException"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterDataBaseException"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.entity.SettingsSNSAngelGuardJSPControler_Angels"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="org.codehaus.jettison.json.JSONArray"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
        SettingsSNSAngelGuardJSPControler_Angels controler = null;
    
        try {
            controler = new SettingsSNSAngelGuardJSPControler_Angels(request, response);
            controler.process();
        } catch (InterDataBaseException e) {
            String exceptionAsString = controler.getSnsObject().getExceptionManager().exceptionToString(e.getException());

            response.sendRedirect(request.getContextPath() + "/infoError.jsp?errorMessage=" + e.getMessageException() + "&exception=" + exceptionAsString);
        } catch (InterProcessException e) {
            String exceptionAsString = controler.getSnsObject().getExceptionManager().exceptionToString(e.getException());

            response.sendRedirect(request.getContextPath() + "/infoError.jsp?errorMessage=" + e.getMessageException() + "&exception=" + exceptionAsString);
        } catch (InterEmailException e) {
            String exceptionAsString = controler.getSnsObject().getExceptionManager().exceptionToString(e.getException());

            response.sendRedirect(request.getContextPath() + "/infoError.jsp?errorMessage=" + e.getMessageException() + "&exception=" + exceptionAsString);
        }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"lang="es" xml:lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title><%= controler.getSnsObject().getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleSettAng()%></title>

        <link type="text/css" rel="stylesheet" href="Styles/facebook.css" />
        <link type="text/css" rel="stylesheet" href="Styles/fcbklistselection.css" />
        <link type="text/css" rel="stylesheet" href="Styles/jquery.loader.css" />

        <script type="text/javascript" charset="UTF-8" src="js/jquery.corner.js"></script>
        <script type="text/javascript" charset="UTF-8" src="js/AjaxFlagMenu-1.0.2.min.js"></script>
        <script type="text/javascript" charset="UTF-8" src="js/jquery.loader.js"></script>

        <script type="text/javascript" charset="UTF-8" src="js/jquery.corner.js"></script>
        <script type="text/javascript" charset="UTF-8" src="js/fcbklistselection.js"></script>
        <script type="text/javascript" charset="UTF-8" src="js/utilidadesFormularios.js"></script>

        <script type="text/javascript" >
            $(function() {
                loadInicioDatesAngels('<%= controler.getHdAngels() %>','<%= controler.getHdAngelsEd() %>','<%= controler.getHdAngelsGoogleSelected() %>',
                '<%= controler.getHdLstAngelsFltWall() %>','<%= controler.getHdLstAngelsFltFriends() %>','<%= controler.getHdLstAngelsFltPriv() %>','<%= controler.getHdLstAngelsFltVist() %>',
                '<%= controler.getHdActiveFltWall() %>','<%= controler.getHdActiveFltFriends() %>','<%= controler.getHdActiveFltPriv() %>','<%= controler.getHdActiveFltVist() %>',
                '<%= controler.getHdFrecFltWall() %>','<%= controler.getHdFrecFltFriends() %>','<%= controler.getHdFrecFltPriv() %>','<%= controler.getHdFrecFltVist() %>','<%= controler.getHdAngelsAux() %>',
                '<%= controler.getJspResources().getArrayAltAngels() %>','<%= controler.getJspResources().getNameContact() %>','<%= controler.getJspResources().getEmailContact() %>','<%= controler.getJspResources().getConfirm() %>','<%= controler.getJspResources().getDelete() %>');
            });
        </script>
    </head>
    <body>
        <form id="frSNSAngels" action="" method="">
            <input type="hidden" id="hdAngels" name="hdAngels" value="" />
            <input type="hidden" id="hdAngelsEd" name="hdAngelsEd" value="" />
            <input type="hidden" id="hdAngelsEdAux" name="hdAngelsEdAux" value="" />
            <input type="hidden" id="hdAngelsGoogleSelected" name="hdAngelsGoogleSelected" value="" />
            <input type="hidden" id="hdAngelsGoogleSelectedAux" name="hdAngelsGoogleSelectedAux" value="" />
            <input type="hidden" id="hdLstAngelsFltWall" name="hdLstAngelsFltWall" value="" />
            <input type="hidden" id="hdLstAngelsFltFriends" name="hdLstAngelsFltFriends" value="" />
            <input type="hidden" id="hdLstAngelsFltPriv" name="hdLstAngelsFltPriv" value="" />
            <input type="hidden" id="hdLstAngelsFltVist" name="hdLstAngelsFltVist" value="" />
            <input type="hidden" id="hdActiveFltWall" name="hdActiveFltWall" value="0" />
            <input type="hidden" id="hdActiveFltFriends" name="hdActiveFltFriends" value="0" />
            <input type="hidden" id="hdActiveFltPriv" name="hdActiveFltPriv" value="0" />
            <input type="hidden" id="hdActiveFltVist" name="hdActiveFltVist" value="0" />
            <input type="hidden" id="hdFrecFltWall" name="hdFrecFltWall" value="0" />
            <input type="hidden" id="hdFrecFltFriends" name="hdFrecFltFriends" value="0" />
            <input type="hidden" id="hdFrecFltPriv" name="hdFrecFltPriv" value="0" />
            <input type="hidden" id="hdFrecFltVist" name="hdFrecFltVist" value="0" />
            <input type="hidden" id="hdAngelsAux" name="hdAngelsAux" value="0" />
            <input type="hidden" id="hdAnadirContacto" name="hdAnadirContacto" value="" />
            <input type="hidden" id="hdEditarContacto" name="hdEditarContacto" value="" />
            <input type="hidden" id="hdCancelarContacto" name="hdCancelarContacto" value="" />
            <input type="hidden" id="hdEliminarContacto" name="hdEliminarContacto" value="" />
            <input type="hidden" id="hdGuardarContacto" name="hdGuardarContacto" value="" />
            <input type="hidden" id="hdNameContact" name="hdNameContact" value="" />
            <input type="hidden" id="hdEmailContact" name="hdEmailContact" value="" />
            <input type="hidden" id="hdTitleAngelConfirm" name="hdTitleAngelConfirm" value="" />
            <input type="hidden" id="hdTitleAngelDelete" name="hdTitleAngelDelete" value="" />

            <div id="friendsContent" class="friendsContent">
                <h1 class="tituloMed"><%= controler.getSnsObject().getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleFriendsContentSettAng()%></h1>
                <ul id="fcbklist">
                </ul>
            </div>
            <div id="friendsGoogleImport" class="friendsGoogleImport">
                <h1 class="tituloMed"><%= controler.getJspResources().getArrayContacts()[0]%></h1>
                <table width="675px">
                    <tr>
                        <td width="536px">
                            <table>
                                <tr>
                                    <td>
                                        <div id="contactContainerGoogle" style="margin:5px;">
                                            <div id="contactContentGoogle" class="contactContentGoogle">
                                                <table id="tabContacts">
                                                    <tr class="pijama1">
                                                        <td width="16px"></td>
                                                        <td width="183px"></td>
                                                        <td width="278px"></td>
                                                    </tr>
                                                    <tr class="pijama1">
                                                        <td width="16px"></td>
                                                        <td width="183px"></td>
                                                        <td width="278px"></td>
                                                    </tr>
                                                    <tr class="pijama1">
                                                        <td width="16px"></td>
                                                        <td width="183px"></td>
                                                        <td width="278px"></td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </td>
                        <td width="133px" align="right">
                            <table>
                                <tr>
                                    <td width="122px" align="right">
                                        <input type="button" class="boton" id="btnImport" name="btnImport" value="<%= controler.getSnsObject().getLocaleSettingsDaoManager().getLocaleSettingsDao().getBtnImportSettAng()%>"
                                               onclick="setWinOpen();lanzarModal('../SNSAngelGuardFB/modalContacts.jsp',700,420);"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="122px" align="right">
                                        <input type="button" class="botonDisabled" id="btnDelContact" name="btnDelContact" value="Borrar"
                                               onclick="borrarContactGoogle();"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </div>
            <div id="friendsImport" class="friendsImport">
                <h1 class="tituloMed"><%= controler.getJspResources().getArrayContacts()[1] %></h1>
                <div id="friendsImportContainer" class="friendsImportContainer" style="margin:5px;">
                    <table id="tabFriendsImport" width="100%"></table>
                </div>
            </div>
        </form>
    </body>
</html>
