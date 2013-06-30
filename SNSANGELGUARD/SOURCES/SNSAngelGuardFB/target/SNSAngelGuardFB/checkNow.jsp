<%-- 
    Document   : checkNow
    Created on : 30-ene-2011, 23:49:44
    Author     : tote
--%>

<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterEmailException"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterProcessException"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.exception.InterDataBaseException"%>
<%@page import="es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.entity.CheckNowJSPControler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
            CheckNowJSPControler jspControler = null;
            
            try {
                    jspControler = new CheckNowJSPControler(request, response);
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