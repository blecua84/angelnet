/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.exception;

/**
 * Enumerado que controla los tipos de errores que pueden darse en la aplicacion.
 * ?
 * @author josejavierblecuadepedro
 */
public enum CodeException {
    ERROR_CLIENT_DATABASE,
    ERROR_SERVER_DATABASE,
    USER_NOT_FOUND_UID_PUBLIC,
    UNSUPPORTED_ENCODING,
    MYSQL_INTEGRITY_CONSTRAINT_VIOLATION_EXCEPTION,
    PARSE_EXCEPTION,
    DATA_LENGTH_EXCEPTION,
    ILEGAL_STATE_EXCEPTION,
    NO_SUCH_PROVIDER_EXCEPTION,
    MESSAGING_EXCEPTION,
    JSON_EXCEPTION,
    IO_EXCEPTION,
    UNIFORM_INTERFACE_EXCEPTION,
    UKNOWN_ERROR
}
