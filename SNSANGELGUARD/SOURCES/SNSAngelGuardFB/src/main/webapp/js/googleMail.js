/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
// Create the contacts service object

var googleApi = {
    AUTH_SCOPE: 'https://www.google.com/m8/feeds',
    CONTACTS_URL: 'https://www.google.com/m8/feeds/contacts/default/full',
    GROUPS_URL: 'https://www.google.com/m8/feeds/groups/default/full',

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



    getContacts: function() {
        alert("DENTRO GETCONTACTS");
        var check = google.accounts.user.checkLogin(this.AUTH_SCOPE);
        alert("CHECK: " + check);
        if(check != ''){
            alert('RECUPERANDO CONTACTOS');
            this.getMyContacts();
        }else{
            alert('REDIRIGIENDO A GOOGLE: ' + this.AUTH_SCOPE);
            this.login();
        }
        alert("SALIENDO GETCONTACTS");
    },

    setupContactsService: function() {
        // Create a new persistant service object
        contactsService = new google.gdata.contacts.ContactsService(this.serviceName);
    },

    login: function() {
            alert("DENTRO LOGIN");
            // Obtain a login token
            var token = google.accounts.user.login(this.AUTH_SCOPE);
            alert("TOKEN: " + token);
    },

    logout: function() {
        google.accounts.user.logout();
    },

    error: function(errorMessage) {
        if (this.errorCallback != 0 && typeof(this.errorCallback)
            != 'undefined') {
            this.errorCallback(errorMessage);
        } else {
            alert(errorMessage);
        }
    },

    setServiceName: function(serviceName) {
        this.serviceName = serviceName;
    },

    callback: function(result) {
        alert("DENTRO CALLBACK: " + result);
        // An array of contact entries
        var entries = result.feed.entry;

        // Iterate through the array of contact entries
        for (var i = 0; i < entries.length; i++) {
            var contactEntry = entries[i];

            var emailAddresses = contactEntry.getEmailAddresses();

            // Iterate through the array of emails belonging to a single contact entry
            for (var j = 0; j < emailAddresses.length; j++) {
                var emailAddress = emailAddresses[j].getAddress();
                alert('email = ' + emailAddress);
            }
        }
    },

    getMyContacts: function (){
        /*
         * Retrieve all contacts
         */

        // The feed URI that is used for retrieving contacts
        var query = new google.gdata.contacts.ContactQuery(this.CONTACTS_URL);
        alert("1");
        // Set the maximum of the result set to be 50S
        query.setMaxResults(50);
        alert(query);

        // Submit the request using the contacts service object
        this.contactsService.getContactFeed(query, this.callback, this.error);
        alert("FIN CONTACTOS");
    }
}
