<%-- 
    Document   : modalContacts
    Created on : 13-abr-2011, 0:28:57
    Author     : tote
--%>


<%@page import="es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager"%>
<%
            //Obtenemos la conexión a Facebookhttps://accounts.google.com/o/oauth2/auth?client_id=789909798690.apps.googleusercontent.com&scope=https%3A%2F%2Fwww.google.com%2Fm8%2Ffeeds%2F&redirect_uri=postmessage&origin=http%3A%2F%2Flocalhost%3A8080&proxy=oauth2relay403468579&response_type=token&state=345579805&authuser=0
            SNSAngelGuardFBManager snsObject = SNSAngelGuardFBManager.getSessionInstance(request);
            snsObject.logSession(request, response);

            //String angelsSelected = request.getParameter("hdAngelsGoogleSelected");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title><%=snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleGoogleCont()%></title>

        <link type="text/css" rel="stylesheet" href="Styles/facebook.css" />
        <script type="text/javascript" src="js/jQuery-1.8.2.js"></script>
        <script type='text/javascript' src='js/utilidadesFormularios.js'></script>
        <script type="text/javascript" src="https://apis.google.com/js/client.js"></script>

        <script type='text/javascript'>
            <!--
            var clientId = '541921444258.apps.googleusercontent.com';
            var apiKey = 'iU3fBdbX_2PFSTwsGpVQe-Dm';
            var scopes = 'https://www.googleapis.com/auth/plus.me';
            var MAX = 8;

            function auth() {
                var config = {
                    'client_id': clientId,
                    'scope': 'https://www.google.com/m8/feeds/'
                };

                gapi.auth.authorize(config, function() {
                    gapi.auth.getToken();
                    getMyContacts();
                });
            }

            function rellenarVaciosContactGoogle(longitud,codigo) {
                var faltan = MAX - longitud;
                var vacias = codigo;

                for(var i=0;i<faltan;i++){
                    vacias = vacias + '<tr id="contact'+ longitud +'" class="pijama1">'
                        + '<td width="25px"></td>'
                        + '<td width="286px"></td>'
                        + '<td width="286px"></td>'
                        + '</tr>';

                    longitud = longitud + 1;
                }

                document.getElementById('tabContacts').innerHTML = vacias;

            }

            function habilitarBoton(idBoton){
                //document.getElementById(idBoton).type = 'botonDisabled';
                document.getElementById(idBoton).disabled = false;
            }

            function deshabilitarBoton(idBoton){
                //document.getElementById(idBoton).type = 'botonDisabled';
                document.getElementById(idBoton).disabled = true;
            }

            function getMyContacts(){
                var contacts = '';
                var cont = parseInt(0);

                var authParams = gapi.auth.getToken() // from Google oAuth

                authParams.alt = 'json';

                $.ajax({
                    url: 'https://www.google.com/m8/feeds/contacts/default/full?max-results=1000',
                    dataType: 'jsonp',
                    data: authParams,
                    success: function(data) {
                        var xmlJson = data.feed.entry;
                        $(xmlJson).each(function() {
                            var entry = $(this);
                            var nameObject  = entry[0].title;
                            var name = $(nameObject).attr('$t');

                            if(entry[0].gd$email != null){
                                var emailAddresses = entry[0].gd$email;
                                if(emailAddresses.length > 0){
                                    for (var j = 0; j < emailAddresses.length; j++) {
                                        var email = emailAddresses[j].address;

                                        contacts = contacts + '<tr id="contact'+ cont +'" class="pijama1">'
                                            + '<td width="25px">'
                                            + '<input type="radio" id="rdContact'+ cont +'" '
                                            + 'onclick="seleccionarFila(\'contact' + cont + '\',\'rdContact' + cont + '\',\'' + name +'\',\''+ email +'\');" />'
                                            + '</td>'
                                            + '<td width="286px">' + name + '</td>'
                                            + '<td width="286px">' + email + '</td>'
                                            + '</tr>';

                                        cont = parseInt(cont) + parseInt(1);

                                    }
                                }
                            }
                        });

                        // Insert empty rows
                        if(xmlJson.length < MAX){
                            rellenarVaciosContactGoogle(emailAddresses.length,contacts);
                        }else{
                            document.getElementById('tabContacts').innerHTML = contacts;
                        }

                        deshabilitarBoton('btnLoginGoogle');
                        deshabilitarBoton('btnAceptar');

                        cargarInicioModal();
                        comprobarAceptar();
                    }
                });
            }


-->
        </script>
    </head>
    <body onload="iniciarModal();" onbeforeunload="checkChangeForm();">
        <form id="frModalContacts" action="" method="GET">
            <input type="hidden" id="hdAngelsGoogleSelected" name="hdAngelsGoogleSelected" value="" />

            <div id='picker_container' style='width: 100%; margin: auto'>
                <table width="100%">
                    <tr>
                        <td width="60%">
                            <h1 class="tituloMed"><%=snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleContGoogleCont()%></h1>
                        </td>
                        <td width="40%" align="right">
                            <input type="button" class="boton" id="btnLoginGoogle" value="<%=snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getBtnLogGoogleCont()%>"
                                   onclick="auth() "/>
                        </td>
                    </tr>
                </table>
                <hr class="linea" />
                <div id="contactContainer" style="margin:10px;">
                    <table width="630px">
                        <tr class="cabecera">
                            <td width="27px"></td>
                            <td width="291px"><%=snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleNameContactGoogleCont()%></td>
                            <td width="292px"><%=snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleEmailContactGoogleCont()%></td>
                            <td width="13px"></td>
                        </tr>
                    </table>
                    <div id="contactContent" class="contactContent" style="border:1px solid #CCC;">
                        <table id="tabContacts">
                            <tr class="pijama1">
                                <td width="25px"></td>
                                <td width="286px"></td>
                                <td width="286px"></td>
                            </tr>
                            <tr class="pijama1">
                                <td width="25px"></td>
                                <td width="286px"></td>
                                <td width="286px"></td>
                            </tr>
                            <tr class="pijama1">
                                <td width="25px"></td>
                                <td width="286px"></td>
                                <td width="286px"></td>
                            </tr>
                            <tr class="pijama1">
                                <td width="25px"></td>
                                <td width="286px"></td>
                                <td width="286px"></td>
                            </tr>
                            <tr class="pijama1">
                                <td width="25px"></td>
                                <td width="286px"></td>
                                <td width="286px"></td>
                            </tr>
                            <tr class="pijama1">
                                <td width="25px"></td>
                                <td width="286px"></td>
                                <td width="286px"></td>
                            </tr>
                            <tr class="pijama1">
                                <td width="25px"></td>
                                <td width="286px"></td>
                                <td width="286px"></td>
                            </tr>
                            <tr class="pijama1">
                                <td width="25px"></td>
                                <td width="286px"></td>
                                <td width="286px"></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div id="botoneraInferior" style="width:100%;" align="left" margin="15px">
                    <hr class="linea" />
                    <table>
                        <!-- <tr height="25px" > -->
                        <tr>
                            <td>
                                <input type="button" class="boton" id="btnAceptar" value="<%=snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getBtnAceptGoogleCont()%>"
                                       onclick="salirModal();enviarFormularioContacts('1')"/>
                            </td>
                            <td>
                                <input type="button" class="boton" id="btnCancelar" value="<%=snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getBtnCancelGoogleCont()%>"
                                       onclick="salirModal();enviarFormularioContacts('0')"/>
                            </td>
                            <td width="100%" align="right">
                                <img src="../SNSAngelGuardFB/resources/gmail.gif" align="middle" alt="">
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </form>
    </body>
</html>