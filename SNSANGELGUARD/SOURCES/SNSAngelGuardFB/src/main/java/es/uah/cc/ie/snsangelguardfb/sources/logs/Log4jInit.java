/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.sources.logs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.PropertyConfigurator;

/**
 * Clase que controla el manejo de los ficheros logs que genera la aplicacion.
 * 
 * @author tote
 */
public class Log4jInit extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void init() {
        Properties prop = new Properties();
        FileInputStream is = null;

        /*
         * Obtengo el contexto de la apliaci??n
         */
        String prefix = getServletContext().getRealPath("/");
        /*
         * Cargo desde el web.xml la ruta en donde se encontrara el archivo
         * properties
         */
        String file = getInitParameter("log4j-init-file");
        try {
            /*
             * Abre el fichero y carga el properties
             */
            is = new FileInputStream(prefix + file);
            prop.load(is);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        FileOutputStream out = null;
        /*
         * Se guarda la modificacion y se carga para log4j
         */
        try {

            out = new FileOutputStream(prefix + file);
            prop.store(out, "---No Comment---");
            out.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        /*
         * Setea para el log4j el properties modificado
         */
        if (file != null) {
            PropertyConfigurator.configure(prefix + file);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}