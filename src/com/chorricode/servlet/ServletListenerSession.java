package com.chorricode.servlet;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ServletListenerSession
 *
 */
@WebListener
public class ServletListenerSession implements HttpSessionListener, HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public ServletListenerSession() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  {
    	System.out.println("");
    	System.out.println("DESDE SERVLET LISTENER: Session Creada: ");
		System.out.println("arg0.getSession().getId(): " + arg0.getSession().getId());
		System.out.println("");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
    	System.out.println("");
    	System.out.println("DESDE SERVLET LISTENER: Atributo añadido");
    	System.out.println("arg0.getName(): " + arg0.getName());
    	System.out.println("");
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
    	System.out.println("DESDE SERVLET LISTENER: Atributo reemplazado");
    }
	
}
