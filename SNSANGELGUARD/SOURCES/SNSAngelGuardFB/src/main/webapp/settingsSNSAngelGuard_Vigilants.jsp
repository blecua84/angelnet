<%-- 
    Document   : settingsSNSAngelGuard_Vigilants
    Created on : 31-mar-2011, 23:00:34
    Author     : tote
--%>


<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterEmailException"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterProcessException"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterDataBaseException"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.entity.SettingsSNSAngelGuardJSPControler_Vigilants"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager"%>
<%@page import="java.net.URLDecoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

        SettingsSNSAngelGuardJSPControler_Vigilants controler = null;
    
        try {
            controler = new SettingsSNSAngelGuardJSPControler_Vigilants(request, response);
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
        <title><%=controler.getSnsObject().getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleSettVig()%></title>

        <link type="text/css" rel="stylesheet" href="Styles/facebook.css" />
        <link type="text/css" rel="stylesheet" href="Styles/smoothness/jquery-ui-1.8.12.custom.css" />
        <link type="text/css" rel="stylesheet" href="Styles/jquery.loader.css" />
        <link type="text/css" rel="stylesheet" href="Styles/fcbklistselection.css" />

        <script type="text/javascript" charset="UTF-8" src="js/jquery-1.5.1.min.js"></script>
        <script type="text/javascript" charset="UTF-8" src="js/jquery-ui-1.8.12.custom.min.js"></script>
        <script type="text/javascript" charset="UTF-8" src="js/utilidadesFormularios.js"></script>
        <script type="text/javascript" charset="UTF-8" src="js/AjaxFlagMenu-1.0.2.min.js"></script>
        <script type="text/javascript" charset="UTF-8" src="js/jquery.loader.js"></script>
        <script type="text/javascript" charset="UTF-8" src="js/fcbklistselectionVig.js"></script>

        <script type="text/javascript" >
          $(function() {
                loadInicioDatesVigilants('<%= controler.getHdAngels() %>','<%= controler.getHdAngelsEd() %>','<%= controler.getHdAngelsGoogleSelected() %>',
                    '<%= controler.getHdLstAngelsFltWall() %>','<%= controler.getHdLstAngelsFltFriends() %>','<%= controler.getHdLstAngelsFltPriv() %>','<%= controler.getHdLstAngelsFltVist() %>',
                    '<%= controler.getHdActiveFltWall() %>','<%= controler.getHdActiveFltFriends() %>','<%= controler.getHdActiveFltPriv() %>','<%= controler.getHdActiveFltVist() %>',
                    '<%= controler.getHdFrecFltWall() %>','<%= controler.getHdFrecFltFriends() %>','<%= controler.getHdFrecFltPriv() %>','<%= controler.getHdFrecFltVist() %>','<%= controler.getHdAngelsAux() %>');

                loadTitleFcbList('<%= controler.getJspResources().getTitleFbList() %>','<%= controler.getJspResources().getTitleAngelSettAng() %>');
                setArrayAngels('<%= controler.getSnsObject().getStringUtilities().arrayToString(controler.getArrayAngels())%>');
            });  

            $(function(){
                loadTitleFcbList('<%= controler.getJspResources().getTitleFbList() %>','<%= controler.getJspResources().getTitleAngelSettAng() %>');
                setArrayAngels('<%= controler.getSnsObject().getStringUtilities().arrayToString(controler.getArrayAngels())%>');

                loadCheckFiltro('FltWall');
                loadCheckFiltro('FltFriends');
                loadCheckFiltro('FltPriv');
                loadCheckFiltro('FltVist');

                habilitarGuardar();
            });
        </script>

    </head>
    <body>
        <form id="frSNSVigilants" action="" method="">
            <input type="hidden" id="hdAngels" name="hdAngels" value="" />
            <input type="hidden" id="hdAngelsEd" name="hdTxtNameAngel" value="" />
            <input type="hidden" id="hdAngelsGoogleSelected" name="hdAngelsGoogleSelected" value="" />
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
            <input type="hidden" id="hdAngelsAux" name="hdAngelsAux" value="" />
            <input type="hidden" id="hdFiltroActual" name="hdFiltroActual" value="" />

            <!-- Variables de idioma  -->
            <input type="hidden" id="hdTitleFbList" name="hdTitleFbList" value="0" />
            <input type="hidden" id="hdTitleAngelSettAng" name="hdTitleAngelSettAng" value="0" />


            <div id="vigilants" class="vigilants">
                <h1 class="tituloMed"><%= controler.getJspResources().getTitleSettVig()%></h1>
                <hr class="linea" />
                <table width="630px">
                    <tr>
                        <td>
                            <table width="188px">
                                <tr class="cabeceraVigilants">
                                    <td width="147px"><%=controler.getJspResources().getTitleVigilantSettVig()%></td>
                                    <td width="20px">
                                        <input type="checkbox" id="chkAllFilters" name="chkAllFilters" value="chkAllFilters" 
                                               disabled="disabled" onclick=""/>
                                    </td>
                                    <td width="17px"></td>
                                </tr>
                            </table>
                            <div id="vigilantsContent" class="vigilantsContent">
                                <table>
                                    <tr id="vigilant0" class="pijama1">
                                        <td width="141px" style="cursor:pointer;" onclick="seleccionVig('vigilant0');cargarOpcionesFiltros('<%= controler.getJspResources().getArrayDes()[2]%>','FltWall');habilitarCheck('chkVig0','FltWall');"><%= controler.getJspResources().getArrayVig()[0]%></td>
                                        <td width="20px">
                                            <input type="checkbox" style="cursor:pointer;" id="chkVig0" name="chkVig0" value="chkVig0"
                                                   disabled="disabled" onclick="" />
                                        </td>
                                    </tr>
                                   <tr id="vigilant1" class="pijama1">
                                        <td width="141px" style="cursor:pointer;" onclick="seleccionVig('vigilant1');cargarOpcionesFiltros('<%= controler.getJspResources().getArrayDes()[1]%>','FltFriends');habilitarCheck('chkVig1','FltFriends');"><%= controler.getJspResources().getArrayVig()[1]%></td>
                                        <td width="20px">
                                            <input type="checkbox" style="cursor:pointer;" id="chkVig1" name="chkVig1" value="chkVig1"
                                                   disabled="disabled" onclick="" />
                                        </td>
                                    </tr>
                                    <tr id="vigilant2" class="pijama1">
                                        <td width="141px" style="cursor:pointer;" onclick="seleccionVig('vigilant2');cargarOpcionesFiltros('<%= controler.getJspResources().getArrayDes()[3]%>','FltPriv');habilitarCheck('chkVig2','FltPriv');"><%= controler.getJspResources().getArrayVig()[2]%></td>
                                        <td width="20px">
                                            <input type="checkbox" style="cursor:pointer;" id="chkVig2" name="chkVig2" value="chkVig2"
                                                   disabled="disabled" onclick="" />
                                        </td>
                                    </tr>
                                    <tr id="vigilant3" class="pijama1">
                                        <td width="141px" style="cursor:pointer;" onclick="seleccionVig('vigilant3');cargarOpcionesFiltros('<%= controler.getJspResources().getArrayDes()[4]%>','FltVist');habilitarCheck('chkVig3','FltVist');"><%= controler.getJspResources().getArrayVig()[3]%></td>
                                        <td width="20px">
                                            <input type="checkbox" style="cursor:pointer;" id="chkVig3" name="chkVig3" value="chkVig3"
                                                   disabled="disabled" onclick="" />
                                        </td>
                                    </tr>
                                    <tr class="pijama1">
                                        <td width="141px"</td>
                                        <td width="20px"></td>
                                    </tr>
                                    <tr class="pijama1">
                                        <td width="141px"</td>
                                        <td width="20px"></td>
                                    </tr>
                                    <tr class="pijama1">
                                        <td width="141px"</td>
                                        <td width="20px"></td>
                                    </tr>
                                    <tr class="pijama1">
                                        <td width="141px"</td>
                                        <td width="20px"></td>
                                    </tr>
                                    <tr class="pijama1">
                                        <td width="141px"</td>
                                        <td width="20px"></td>
                                    </tr>
                                    <tr class="pijama1">
                                        <td width="141px"</td>
                                        <td width="20px"></td>
                                    </tr>
                                    <tr class="pijama1">
                                        <td width="141px"</td>
                                        <td width="20px"></td>
                                    </tr>
                                    <tr class="pijama1">
                                        <td width="141px"</td>
                                        <td width="20px"></td>
                                    </tr>
                                    <tr class="pijama1">
                                        <td width="141px"</td>
                                        <td width="20px"></td>
                                    </tr>
                                    <tr class="pijama1">
                                        <td width="141px"</td>
                                        <td width="20px"></td>
                                    </tr>
                                    <tr class="pijama1">
                                        <td width="141px"</td>
                                        <td width="20px"></td>
                                    </tr>
                                    <tr class="pijama1">
                                        <td width="141px"</td>
                                        <td width="20px"></td>
                                    </tr>
                                    <tr class="pijama1">
                                        <td width="141px"</td>
                                        <td width="20px"></td>
                                    </tr>
                                    <tr class="pijama1">
                                        <td width="141px"</td>
                                        <td width="20px"></td>
                                    </tr>
                                    <tr class="pijama1">
                                        <td width="141px"</td>
                                        <td width="20px"></td>
                                    </tr>
                                    <tr class="pijama1">
                                        <td width="141px"</td>
                                        <td width="20px"></td>
                                    </tr>
                                </table>
                            </div>
                        </td>
                        <td>
                            <table width="350px">
                                <tr>
                                    <td>
                                        <h1 class="letraNorm"><%= controler.getJspResources().getArrayDes()[0]%></h1>
                                        <div id="vigilantDescription" class="vigilantDescription">
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div id="vigilantFrec" class="vigilantFrec">
                                            <table width="100%">
                                                <tr>
                                                    <td width="60%" align="left">
                                                        <h1 class="letraNorm"><%= controler.getJspResources().getTitleVigFrecSettVig() %> </h1>
                                                    </td>
                                                    <td width="40%" align="right">
                                                        <select id="slcFrecuency" disabled="disabled"
                                                                onchange="obtenerFrecuencia(this.id);">
                                                            <option value="0"><%= controler.getJspResources().getArrayFrc()[0]%></option>
                                                            <option value="1"><%= controler.getJspResources().getArrayFrc()[1]%></option>
                                                            <option value="2"><%= controler.getJspResources().getArrayFrc()[2]%></option>
                                                            <option selected value="3"><%= controler.getJspResources().getArrayFrc()[3]%></option>
                                                            <option value="4"><%= controler.getJspResources().getArrayFrc()[4]%></option>
                                                            <option value="5"><%= controler.getJspResources().getArrayFrc()[5]%></option>
                                                            <option value="6"><%= controler.getJspResources().getArrayFrc()[6]%></option>
                                                        </select>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <h1 class="letraNorm"><%=controler.getJspResources().getTitleVigAngSettVig() %></h1>
                                        <div id="vigilantAngels" class="vigilantAngels">
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </body>
</html>
