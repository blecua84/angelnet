/* Copyright (c) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
  * Add support for Array.some() on older browsers.
  */
if (!Array.prototype.some)
{
    Array.prototype.some = function(fun)
    {
        var len = this.length;
        if (typeof fun != "function")
            throw new TypeError();

        var thisp = arguments[1];
        for (var i = 0; i < len; i++)
        {
            if (i in this &&
                fun.call(thisp, this[i], i, this))
                return true;
        }

        return false;
    };
}

var MAX = 8;

function rellenarVacio(longitud,codigo) {
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


var Picker = {
    AUTH_SCOPE: 'https://www.google.com/m8/feeds/',
    CONTACTS_URL: 'https://www.google.com/m8/feeds/contacts/default/full',
    GROUPS_URL: 'https://www.google.com/m8/feeds/groups/default/full',
    MAX: 8,

    GROUPS_PANE_ID: 'picker_groups_pane',
    CONTACTS_PANE_ID: 'picker_contacts_pane',
    INFO_PANEL_ID: 'picker_info_pane',
    INFO_CONTAINER_ID: 'picker_info_container',

    GROUPS_LIST_ID: 'picker_groups',
    CONTACT_LIST_ID: 'picker_contacts',

    GROUP_SELECTED_CLASS: 'picker_selected',
    GROUP_END_SPECIAL_CLASS: 'picker_endspecial',
    CONTACT_SELECTED_CLASS: 'picker_selected',

    CONTACT_INFO_BLOCK_CLASS: 'picker_info_block',
    CONTACT_INFO_TITLE_CLASS: 'picker_info_title',
    CONTACT_INFO_META_CLASS: 'picker_info_meta',
    GOOGLE_MAPS_QUERY_URL: 'http://maps.google.com/?q=',

    serviceName: 0,
    contactsService: 0,
    container: 0,
    groupSelector: 0,
    userAddCallback: 0,
    userRemoveCallback: 0,
    errorCallback: 0,
    selectedGroup: 0,
    selectedUser: 0,
    selectedUsers: [],


    /* Callback functions */
    /**
   * Callback function invoked by the Google Contacts library after calling
   * populateContatcts(). Generates the DOM entries that comprise the list
   * of contact entries. Do not call directly.
   *
   * @param feedRoot The list of contact entries as returned by the
   *        Contacts service.
   */
    processContactFeed: function(feedRoot) {
        initRender();
        // Convert result set to an array of entries
        var entries = feedRoot.feed.entry;

        // Write out new list of groups
        var contacts = '';
        var cont = parseInt(0);

        for (var i = 0; i < entries.length; i++) {
            var contactEntry = entries[i];
            var emailAddresses = contactEntry.getEmailAddresses();

            // Iterate through the array of emails belonging to a single contact entry
            for (var j = 0; j < emailAddresses.length; j++) {
                var nameAddress = contactEntry.getTitle().getText();
                var emailAddress = emailAddresses[j].getAddress();
                if(nameAddress == '' && emailAddress !=''){
                    nameAddress = emailAddress;
                }
                contacts = contacts + '<tr id="contact'+ cont +'" class="pijama1">'
                + '<td width="25px">'
                + '<input type="radio" id="rdContact'+ cont +'" '
                + 'onclick="seleccionarFila(\'contact'+cont+'\',\'rdContact'+cont+'\',\''+nameAddress+'\',\''+emailAddress+'\');" />'
                + '</td>'
                + '<td width="286px">' + nameAddress + '</td>'
                + '<td width="286px">' + emailAddress + '</td>'
                + '</tr>';

                cont = parseInt(cont) + parseInt(1);
            }
        }

        // Insert empty rows
        if(entries.length < MAX){
            rellenarVacio(emailAddresses.length,contacts);
        }else{
            document.getElementById('tabContacts').innerHTML = contacts;
        }

        this.deshabilitarBoton('btnLoginGoogle');
        this.deshabilitarBoton('btnAceptar');
        
        cargarInicioModal();
        comprobarAceptar();        
    },   

    /* Class methods */

    /**
   * Create an authenticated session with the Google Contacts server.
   * Requires that setServiceName() has been called previously.
   */
    login: function() {
        alert("ESTOY EN PICKER");
        if (this.serviceName != 0 && typeof(this.serviceName) != 'undefined') {
            // Obtain a login token
            google.accounts.user.login(this.AUTH_SCOPE);
            // Create a new persistant service object
            this.contactsService = new google.gdata.contacts.ContactsService(
                this.serviceName);
        } else {
            this.error('Service name undefined, call setServiceName()');
        }
    },

    /**
   * Destroy the current Google Contacts session, including cached
   * authentication tokens.
   */
    logout: function() {
        google.accounts.user.logout();
        this.container.innerHTML = '<h3 align=\'center\'>Please Sign In To' +
    ' Use This Feature</h3><p align=\'center\'><input type=\'button\'' +
    ' value=\'Sign In\' onclick=\'Picker.login()\' /></p>';
    },

    /**
   * Display an error message. Custom behavior can be defined by using
   * setErrorCallback() to register a callback function.
   *
   * @param errorMessage The error string to display.
   */
    error: function(errorMessage) {
        if (this.errorCallback != 0 && typeof(this.errorCallback)
            != 'undefined') {
            this.errorCallback(errorMessage);
        } else {
            alert(errorMessage);
        }
    },

    /**
   * Set the service name which will be provided to the Google Contacts
   * servers during login. This name should uniquely identify yourself,
   * your application's name, and your application's version. For example:
   * "SNSAngelGuardFB" would represent Google Picker Sample v1.0.
   *
   * @param serviceName A string indicating your service's name.
   */
    setServiceName: function(serviceName) {
        this.serviceName = serviceName;
    },

    /**
   * Set a callback function which will be invoked when a error is
   * thrown. If not set or set to 0, then alert() will be used as a
   * default error handler. This function should accept a single
   * parameter: A string representing the error message.
   *
   * @param callback The callback function to use, or 0 if alert() should
   *        be used instead.
   */
    setErrorCallback: function(callback) {
        this.errorCallback = callback;
    },

    /**
   * Set a callback function which will be invoked when a new user is
   * selected. This function should accept a single parameter: a
   * ContactEntry representing the newly selected contact.
   */
    setUserAddCallback: function(callback) {
        this.userAddCallback = callback;
    },

    /**
   * Set a callback function which will be invoked when a user is
   * deselected. This function should accept a single parameter: a
   * ContactEntry representing the newly deselected contact.
   */
    setUserRemoveCallback: function(callback) {
        this.userRemoveCallback = callback;
    },

    habilitarBoton: function(idBoton){
        //document.getElementById(idBoton).type = 'botonDisabled';
        document.getElementById(idBoton).disabled = false;
    },

    deshabilitarBoton: function(idBoton){
        //document.getElementById(idBoton).type = 'botonDisabled';
        document.getElementById(idBoton).disabled = true;
    },

    /**
   * Retrieve the list of user's groups and populate the group list. */
    populateGroups: function() {
        // Compose a new query requesting all groups
        var query = new google.gdata.contacts.ContactQuery(this.CONTACTS_URL);
        query.setParam('max-results', 1000);

        // Submit query for asynchronous execution. After execution,
        // processGroupFeed() will be called on success, error() on
        // failure.
        this.contactsService.getContactFeed(
            query, this.processContactFeed, this.error);
    },

    /**
   * Create the initial layout for this class and insert it into a div
   * with the given name.
   *
   * @param containerId The name of the div which will hold the contact
   *        picker.
   */
    render: function(containerId) {
        initRender();
        this.container = document.getElementById(containerId);

        // Make sure that the client library is initialized
        google.gdata.client.init(this.error);
        initRender();
        // Execute only if the current session is valid.
        if (google.accounts.user.checkLogin(this.AUTH_SCOPE)) {
            // Even though we're supposedly authenticated, let's be certain...
            this.login();
            initRender();
            // Begin loading data
            this.populateGroups();
        } else{}
    }
}
