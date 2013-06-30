package es.uah.cc.ie.snsangelguardfb.sources.jspcontroler;

import es.uah.cc.ie.snsangelguardfb.exception.InterDataBaseException;
import es.uah.cc.ie.snsangelguardfb.exception.InterEmailException;
import es.uah.cc.ie.snsangelguardfb.exception.InterProcessException;

/**
 * Clase general a implementar por las clases JSPControler.
 *
 * @author tote
 */
public abstract class GenericJSPControler {

    public abstract void process() throws InterDataBaseException, InterProcessException, InterEmailException;
}
