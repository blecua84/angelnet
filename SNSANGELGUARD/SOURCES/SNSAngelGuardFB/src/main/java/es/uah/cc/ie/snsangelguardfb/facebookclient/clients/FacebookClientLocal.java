/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.facebookclient.clients;

import com.facebook.api.FacebookParam;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.restfb.DefaultLegacyFacebookClient;
import com.restfb.LegacyFacebookClient;
import com.restfb.Parameter;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import es.uah.cc.ie.snsangelguardfb.sources.utilities.JSONUtilities;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MultivaluedMap;
import net.sf.json.JSONSerializer;
import org.apache.commons.codec.binary.Base64;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openide.util.Exceptions;

/** Jersey REST client generated for REST resource:Social Networking Service [restserver.php]<br>
 *  USAGE:<pre>
 *        FacebookClientLocal client = new FacebookClientLocal();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 *  </pre>
 * @author tote
 */
public class FacebookClientLocal {

    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://api.facebook.com";

    public FacebookClientLocal() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("restserver.php");
    }

    /**
     * @param responseType Class representing the response
     * @param integration_point_name query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>callback [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T admin_getAllocation(Class<T> responseType, String integration_point_name, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "integration_point_name", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), integration_point_name, "1.0", "facebook.admin.getAllocation", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param start_date query parameter[REQUIRED]
     * @param end_date query parameter[REQUIRED]
     * @param metrics query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>callback [OPTIONAL]
     * <LI>period [OPTIONAL, DEFAULT VALUE: "86400"]
     * @return response object (instance of responseType class)
     */
    public <T> T admin_getMetrics(Class<T> responseType, String start_date, String end_date, String metrics, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "start_date", "end_date", "metrics", "v", "method"};
        String[] queryParamValues = new String[]{getApiKey(), start_date, end_date, metrics, "1.0", "facebook.admin.getMetrics"};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param properties query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T admin_getAppProperties(Class<T> responseType, String properties, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "properties", "v", "method"};
        String[] queryParamValues = new String[]{getApiKey(), properties, "1.0", "facebook.admin.getAppProperties"};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param properties query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T admin_setAppProperties(Class<T> responseType, String properties, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "properties", "v", "method"};
        String[] queryParamValues = new String[]{getApiKey(), properties, "1.0", "facebook.admin.setAppProperties"};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>application_id [OPTIONAL]
     * <LI>application_api_key [OPTIONAL]
     * <LI>application_canvas_name [OPTIONAL]
     * <LI>format [OPTIONAL]
     * <LI>callback [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T application_getPublicInfo(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "v", "method"};
        String[] queryParamValues = new String[]{getApiKey(), "1.0", "facebook.application.getPublicInfo"};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param uid query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>name [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T data_getCookies(Class<T> responseType, String uid, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"uid", "method"};
        String[] queryParamValues = new String[]{uid, "facebook.data.getCookies"};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param uid query parameter[REQUIRED]
     * @param name query parameter[REQUIRED]
     * @param value query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>expires [OPTIONAL]
     * <LI>path [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T data_setCookie(Class<T> responseType, String uid, String name, String value, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"uid", "name", "value", "method"};
        String[] queryParamValues = new String[]{uid, name, value, "facebook.data.setCookie"};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>uid [OPTIONAL]
     * <LI>eids [OPTIONAL]
     * <LI>start_time [OPTIONAL]
     * <LI>end_time [OPTIONAL]
     * <LI>rsvp_status [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T events_get(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.events.get", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param eid query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>cancel_message [OPTIONAL]
     * <LI>callback [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T events_cancel(Class<T> responseType, String eid, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "eid", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), eid, "1.0", "facebook.events.cancel", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param event_info query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>callback [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T events_create(Class<T> responseType, String event_info, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "event_info", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), event_info, "1.0", "facebook.events.create", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param eid query parameter[REQUIRED]
     * @param event_info query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>callback [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T events_edit(Class<T> responseType, String eid, String event_info, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "eid", "event_info", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), eid, event_info, "1.0", "facebook.events.edit", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param eid query parameter[REQUIRED]
     * @param rsvp_status query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>callback [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T events_rsvp(Class<T> responseType, String eid, String rsvp_status, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "eid", "rsvp_status", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), eid, rsvp_status, "1.0", "facebook.events.rsvp", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param eid query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T events_getMembers(Class<T> responseType, String eid, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "eid", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), eid, "1.0", "facebook.events.getMembers", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param url query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T fbml_refreshImgSrc(Class<T> responseType, String url, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "url", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), url, "1.0", "facebook.fbml.refreshImgSrc", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param url query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T fbml_refreshRefUrl(Class<T> responseType, String url, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "url", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), url, "1.0", "facebook.fbml.refreshRefUrl", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param handle query parameter[REQUIRED]
     * @param fbml query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T fbml_setRefHandle(Class<T> responseType, String handle, String fbml, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "handle", "fbml", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), handle, fbml, "1.0", "facebook.fbml.setRefHandle", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param native_strings query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>callback [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T fbml_uploadNativeStrings(Class<T> responseType, String native_strings, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "native_strings", "v", "method"};
        String[] queryParamValues = new String[]{getApiKey(), native_strings, "1.0", "facebook.fbml.uploadNativeStrings"};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param title query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>body [OPTIONAL]
     * <LI>image_1 [OPTIONAL]
     * <LI>image_1_link [OPTIONAL]
     * <LI>image_2 [OPTIONAL]
     * <LI>image_2_link [OPTIONAL]
     * <LI>image_3 [OPTIONAL]
     * <LI>image_3_link [OPTIONAL]
     * <LI>image_4 [OPTIONAL]
     * <LI>image_4_link [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T feed_publishActionOfUser(Class<T> responseType, String title, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "title", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), title, "1.0", "facebook.feed.publishActionOfUser", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param template_bundle_id query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T feed_deactivateTemplateBundleByID(Class<T> responseType, String template_bundle_id, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "template_bundle_id", "v", "method"};
        String[] queryParamValues = new String[]{getApiKey(), template_bundle_id, "1.0", "facebook.feed.deactivateTemplateBundleByID"};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param template_bundle_id query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T feed_getRegisteredTemplateBundleByID(Class<T> responseType, String template_bundle_id, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "template_bundle_id", "v", "method"};
        String[] queryParamValues = new String[]{getApiKey(), template_bundle_id, "1.0", "facebook.feed.getRegisteredTemplateBundleByID"};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T feed_getRegisteredTemplateBundles(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "v", "method"};
        String[] queryParamValues = new String[]{getApiKey(), "1.0", "facebook.feed.getRegisteredTemplateBundles"};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param template_bundle_id query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>template_data [OPTIONAL]
     * <LI>target_ids [OPTIONAL]
     * <LI>body_general [OPTIONAL]
     * <LI>story_size [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T feed_publishUserAction(Class<T> responseType, String template_bundle_id, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "template_bundle_id", "v", "method"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), template_bundle_id, "1.0", "facebook.feed.publishUserAction"};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param one_line_story_templates query parameter[REQUIRED]
     * @param short_story_templates query parameter[REQUIRED]
     * @param full_story_template query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T feed_registerTemplateBundle(Class<T> responseType, String one_line_story_templates, String short_story_templates, String full_story_template, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "one_line_story_templates", "short_story_templates", "full_story_template", "v", "method"};
        String[] queryParamValues = new String[]{getApiKey(), one_line_story_templates, short_story_templates, full_story_template, "1.0", "facebook.feed.registerTemplateBundle"};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param title query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>body [OPTIONAL]
     * <LI>image_1 [OPTIONAL]
     * <LI>image_1_link [OPTIONAL]
     * <LI>image_2 [OPTIONAL]
     * <LI>image_2_link [OPTIONAL]
     * <LI>image_3 [OPTIONAL]
     * <LI>image_3_link [OPTIONAL]
     * <LI>image_4 [OPTIONAL]
     * <LI>image_4_link [OPTIONAL]
     * <LI>priority [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T feed_publishStoryToUser(Class<T> responseType, String title, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "title", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), title, "1.0", "facebook.feed.publishStoryToUser", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param title_template query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>title_data [OPTIONAL]
     * <LI>body_template [OPTIONAL]
     * <LI>body_data [OPTIONAL]
     * <LI>body_general [OPTIONAL]
     * <LI>page_actor_id [OPTIONAL]
     * <LI>image_1 [OPTIONAL]
     * <LI>image_1_link [OPTIONAL]
     * <LI>image_2 [OPTIONAL]
     * <LI>image_2_link [OPTIONAL]
     * <LI>image_3 [OPTIONAL]
     * <LI>image_3_link [OPTIONAL]
     * <LI>image_4 [OPTIONAL]
     * <LI>image_4_link [OPTIONAL]
     * <LI>target_ids [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T feed_publishTemplatizedAction(Class<T> responseType, String title_template, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "title_template", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), title_template, "1.0", "facebook.feed.publishTemplatizedAction", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param recipient query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>event_name [OPTIONAL]
     * <LI>message [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T liveMessage_send(Class<T> responseType, String recipient, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "recipient", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), recipient, "1.0", "facebook.liveMessage.send", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param query query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T fql_query(Class<T> responseType, String query, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "query", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), query, "1.0", "facebook.fql.query", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param uids1 query parameter[REQUIRED]
     * @param uids2 query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T friends_areFriends(Class<T> responseType, String uids1, String uids2, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "uids1", "uids2", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), uids1, uids2, "1.0", "facebook.friends.areFriends", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>flid [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T friends_get(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.friends.get", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T friends_getAppUsers(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.friends.getAppUsers", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T friends_getLists(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.friends.getLists", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>uid [OPTIONAL]
     * <LI>gids [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T groups_get(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.groups.get", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param gid query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T groups_getMembers(Class<T> responseType, String gid, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "gid", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), gid, "1.0", "facebook.groups.getMembers", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>listing_id [OPTIONAL]
     * <LI>show_on_profile [OPTIONAL]
     * <LI>listing_attrs [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T marketplace_createListing(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.marketplace.createListing", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T marketplace_getCategories(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.marketplace.getCategories", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>listing_ids [OPTIONAL]
     * <LI>uids [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T marketplace_getListings(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.marketplace.getListings", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>category [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T marketplace_getSubCategories(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.marketplace.getSubCategories", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>listing_id [OPTIONAL]
     * <LI>status [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T marketplace_removeListing(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.marketplace.removeListing", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>category [OPTIONAL]
     * <LI>subcategory [OPTIONAL]
     * <LI>query [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T marketplace_search(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.marketplace.search", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T notifications_get(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.notifications.get", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param to_ids query parameter[REQUIRED]
     * @param notification query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T notifications_send(Class<T> responseType, String to_ids, String notification, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "to_ids", "notification", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), to_ids, notification, "1.0", "facebook.notifications.send", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param recipients query parameter[REQUIRED]
     * @param subject query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>text [OPTIONAL]
     * <LI>fbml [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T notifications_sendEmail(Class<T> responseType, String recipients, String subject, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "recipients", "subject", "v", "method"};
        String[] queryParamValues = new String[]{getApiKey(), recipients, subject, "1.0", "facebook.notifications.sendEmail"};
        System.out.println("QUERY EMAIL: " + queryParamValues[0] + ", " + queryParamValues[1] + ", " + queryParamValues[2] + ", " + queryParamValues[3] + ", " + queryParamValues[4]);
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        System.out.println("QUERY SIGNATURE EMAIL: " + signature);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param fields query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>page_ids [OPTIONAL]
     * <LI>uid [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T pages_getinfo(Class<T> responseType, String fields, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "fields", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), fields, "1.0", "facebook.pages.getinfo", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>page_id [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T pages_isAdmin(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.pages.isAdmin", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>page_id [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T pages_isAppAdded(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.pages.isAppAdded", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>page_id [OPTIONAL]
     * <LI>uid [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T pages_isFan(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.pages.isFan", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param pid query parameter[REQUIRED]
     * @param tag_uid query parameter[REQUIRED]
     * @param tag_text query parameter[REQUIRED]
     * @param x query parameter[REQUIRED]
     * @param y query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>tags [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T photos_addTag(Class<T> responseType, String pid, String tag_uid, String tag_text, String x, String y, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "pid", "tag_uid", "tag_text", "x", "y", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), pid, tag_uid, tag_text, x, y, "1.0", "facebook.photos.addTag", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param name query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>location [OPTIONAL]
     * <LI>description [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T photos_createAlbum(Class<T> responseType, String name, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "name", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), name, "1.0", "facebook.photos.createAlbum", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param subj_id query parameter[REQUIRED]
     * @param aid query parameter[REQUIRED]
     * @param pids query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T photos_get(Class<T> responseType, String subj_id, String aid, String pids, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "subj_id", "aid", "pids", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), subj_id, aid, pids, "1.0", "facebook.photos.get", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param uid query parameter[REQUIRED]
     * @param aids query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T photos_getAlbums(Class<T> responseType, String uid, String aids, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "uid", "aids", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), uid, aids, "1.0", "facebook.photos.getAlbums", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param pids query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T photos_getTags(Class<T> responseType, String pids, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "pids", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), pids, "1.0", "facebook.photos.getTags", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>session_key [OPTIONAL]
     * <LI>format [OPTIONAL]
     * <LI>uid [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T profile_getFBML(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), "1.0", "facebook.profile.getFBML", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>uid [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T profile_getInfo(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "v", "method"};
        String[] queryParamValues = new String[]{getApiKey(), "1.0", "facebook.profile.getInfo"};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>title [OPTIONAL]
     * <LI>type [OPTIONAL]
     * <LI>info_fields [OPTIONAL]
     * <LI>uid [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T profile_setInfo(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "v", "method"};
        String[] queryParamValues = new String[]{getApiKey(), "1.0", "facebook.profile.setInfo"};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>field [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T profile_getInfoOptions(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "v", "method"};
        String[] queryParamValues = new String[]{getApiKey(), "1.0", "facebook.profile.getInfoOptions"};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param options query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T profile_setInfoOptions(Class<T> responseType, String options, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "options", "v", "method"};
        String[] queryParamValues = new String[]{getApiKey(), options, "1.0", "facebook.profile.setInfoOptions"};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>uid [OPTIONAL]
     * <LI>markup [OPTIONAL]
     * <LI>profile [OPTIONAL]
     * <LI>profile_action [OPTIONAL]
     * <LI>mobile_fbml [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T profile_setFBML(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.profile.setFBML", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param uids query parameter[REQUIRED]
     * @param fields query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T users_getinfo(Class<T> responseType, String uids, String fields, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "uids", "fields", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), uids, fields, "1.0", "facebook.users.getinfo", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T users_getLoggedInUser(Class<T> responseType, HttpServletRequest request, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        httpServletRequest = request;
        httpServletRequest.getSession(true);
        System.out.println("USRGTLOG: " + httpServletRequest);
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.users.getLoggedInUser", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param ext_perm query parameter[REQUIRED]
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T users_hasAppPermission(Class<T> responseType, String ext_perm, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "ext_perm", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), ext_perm, "1.0", "facebook.users.hasAppPermission", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T users_isAppAdded(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.users.isAppAdded", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>callback [OPTIONAL]
     * <LI>uid [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T users_isAppUser(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.users.isAppUser", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>format [OPTIONAL]
     * <LI>status [OPTIONAL]
     * <LI>clear [OPTIONAL]
     * <LI>status_includes_verb [OPTIONAL]
     * @return response object (instance of responseType class)
     */
    public <T> T users_setStatus(Class<T> responseType, String... optionalQueryParams) throws UniformInterfaceException, IOException {
        String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method", "call_id"};
        String[] queryParamValues = new String[]{getApiKey(), getSessionKey(), "1.0", "facebook.users.setStatus", getCallId()};
        String signature = signParams(queryParamNames, queryParamValues, optionalQueryParams);
        return webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", signature).queryParams(getQParams(optionalQueryParams)).accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    private MultivaluedMap getQueryOrFormParams(String[] paramNames, String[] paramValues) {
        MultivaluedMap<String, String> qParams = new com.sun.jersey.api.representation.Form();
        for (int i = 0; i < paramNames.length; i++) {
            if (paramValues[i] != null) {
                qParams.add(paramNames[i], paramValues[i]);
            }
        }
        return qParams;
    }

    private MultivaluedMap getQParams(String... optionalParams) {
        MultivaluedMap<String, String> qParams = new com.sun.jersey.api.representation.Form();
        for (String qParam : optionalParams) {
            String[] qPar = qParam.split("=");
            if (qPar.length > 1) {
                qParams.add(qPar[0], qPar[1]);
            }
        }
        return qParams;
    }

    public void close() {
        client.destroy();
    }
    private static String api_key;
    private static String application_secret;
    private static String path_application = null;
    private static String createdSessionKey = null;
    private HttpServletRequest httpServletRequest;

    public void login(HttpServletRequest request, HttpServletResponse response, String apiKey, String applicationSecret, String pathApplication) throws IOException, JSONException {
        api_key = apiKey;
        application_secret = applicationSecret;
        path_application = pathApplication;
        httpServletRequest = request;
        dispatch(request, response);
    }

    public void loginOffline(HttpServletRequest request, HttpServletResponse response, String apiKey, String applicationSecret, String pathApplication) throws IOException, JSONException {
        api_key = apiKey;
        application_secret = applicationSecret;
        path_application = pathApplication;
        httpServletRequest = request;
    }

    public void setHttpServletRequest(HttpServletRequest request) {
        this.httpServletRequest = request;
    }

    public void logout(HttpServletRequest request) throws IOException {
        javax.servlet.http.HttpSession session = request.getSession(true);
        String sessionKey = (String) session.getAttribute("facebook_session_key");
        if (sessionKey != null) {
            String[] queryParamNames = new String[]{"api_key", "session_key", "v", "method"};
            String[] queryParamValues = new String[]{api_key, sessionKey, "1.0", "facebook.auth.expireSession"};
            String sig = signParams(queryParamNames, queryParamValues);
            String resp = webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).queryParam("sig", sig).get(String.class);
        }
        session.removeAttribute("facebook_session_key");
        session.removeAttribute("facebook_auth_token");
        session.removeAttribute("facebook_return_url");
        httpServletRequest = null;
    }

    private String getApiKey() {
        return api_key;
    }

    private String getCallId() {
        return String.valueOf(System.currentTimeMillis());
    }

    private String getSessionKey() {
        if (httpServletRequest == null) {
            throw new NullPointerException("httpServletRequest is null");
        }
        javax.servlet.http.HttpSession session = httpServletRequest.getSession(false);
        return (String) session.getAttribute("facebook_session_key");
    }

    private String getCreatedSessionKey() {
        return createdSessionKey;
    }

    private static String createSessionKey(String auth_token) throws IOException, JSONException {
        String[] queryParamNames = new String[]{"api_key", "auth_token", "v", "method"};
        String[] queryParamValues = new String[]{api_key, auth_token, "1.0", "facebook.auth.getSession"};
        String sig = signParams(queryParamNames, queryParamValues);
        Client c = new Client();
        WebResource webRes = c.resource(BASE_URI).path("restserver.php");
        String result = webRes.queryParam("api_key", api_key).queryParam("auth_token", auth_token).queryParam("v", "1.0").queryParam("method", "facebook.auth.getSession").queryParam("sig", sig).get(String.class);
        c.destroy();
        try {
            result = result.substring(result.indexOf("<session_key>"), result.indexOf("</session_key>")).replace("<session_key>", "");
            createdSessionKey = result;
            return result;
        } catch (Exception ex) {
            return null;
        }
    }

    private static void dispatch(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {


        HttpSession session = request.getSession(false);

        Object userId = session.getAttribute("user_id");
        Object oauthToken = session.getAttribute("oauth_token");

        if (userId == null && oauthToken == null) {
            response.sendRedirect(request.getContextPath() + "/FacebookCallbackServlet/");
            return;
        } else {
            request.setAttribute("user_id", userId);
            request.setAttribute("oauth_token", oauthToken);
            response.sendRedirect(request.getContextPath());
            return;
        }
    }

    private static String signParams(String[] paramNames, String[] paramValues, String[] optionalParams) throws IOException {
        if (application_secret == null) {
            throw new NullPointerException("secret is null");
        }
        java.util.TreeMap<String, String> map = new java.util.TreeMap<String, String>();
        for (int i = 0; i < paramNames.length; i++) {
            String key = paramNames[i];
            String value = paramValues[i];
            if (value != null) {
                map.put(key, value);
            }
        }
        for (String param : optionalParams) {
            String[] par = param.split("=");
            if (par.length > 1) {
                map.put(par[0], par[1]);
            }
        }
        try {
            String signature = "";
            java.util.Set<java.util.Map.Entry<String, String>> entrySet = map.entrySet();
            for (java.util.Map.Entry<String, String> entry : entrySet) {
                signature += entry.getKey() + "=" + entry.getValue();
            }
            signature += application_secret;
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] sum = md.digest(signature.getBytes("UTF-8"));
            java.math.BigInteger bigInt = new java.math.BigInteger(1, sum);
            return bigInt.toString(16);
        } catch (java.security.NoSuchAlgorithmException ex) {
        }
        return "";
    }

    private static String signParams(String[] paramNames, String[] paramValues) throws IOException {
        return signParams(paramNames, paramValues, new String[]{});
    }

    public static class FacebookLoginServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");

            HttpSession session = request.getSession(true);
            String urlLogin = "https://www.facebook.com/dialog/oauth/"
                    + "?client_id=" + api_key
                    + "&redirect_uri=" + path_application + "FacebookCallbackServlet/"
                    + "&scope=read_stream,offline_access,friends_birthday,user_about_me,user_relationships,user_religion_politics,"
                    + "user_birthday,user_work_history,user_education_history,user_website,user_hometown,user_location,user_relationship_details,email"
                    + "&response_type=token";
            response.sendRedirect(urlLogin);
            return;

        }
    }

    public static class FacebookCallbackServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String userId = null;
            String oauthToken = null;
            HttpSession session = request.getSession(true);

            if (request.getParameter("signed_request") != null) {
                try {
                    Base64 base64 = new Base64();
                    String[] signedRequest = request.getParameter("signed_request").split("\\.", 2);
                    JSONObject data = JSONUtilities.completStrToJSONObject(new String(base64.decode(signedRequest[1].getBytes())));

                    if (data.length() > 0) {
                        userId = data.getString("user_id");
                        oauthToken = data.getString("oauth_token");
                        if (userId != null && oauthToken != null) {
                            if (oauthToken != null) {
                                session.setAttribute("user_id", userId);
                                session.setAttribute("oauth_token", oauthToken);
                                dispatch(request,response);
                            }
                        } else {
                            response.sendRedirect(request.getContextPath() + "/FacebookLoginServlet/");
                        }
                    } else {
                        response.sendRedirect(request.getContextPath() + "/FacebookLoginServlet/");
                    }
                } catch (JSONException ex) {
                    Exceptions.printStackTrace(ex);
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/FacebookLoginServlet/");
            }
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
        }
    }

    public String getSessionKeyFacebook() {
        return this.getCreatedSessionKey();
    }
}
